package com.kotobadon.pensk.skeewati_sizebook;


import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by pensk on 2017/02/05.
 */

//Models the array of persons used to to hold the sizebook data. Is responsible for updating the array and saving and loading from disk.
public class SizeBookModel{
    //use Gson to store the objects as json in a file.
    private Gson gson;
    //The name of the file.
    private static final String FILENAME = "file.sav";
    //The array of persons to hold the sizebook data.
    private ArrayList<Person> persons;

    //Initialize the model, load persons from disk and prepare gson.
    public SizeBookModel() {
        gson = new Gson();
        loadFromFile();
    }

    //return the array of persons.
    public ArrayList<Person> getPersons(){
        return this.persons;
    }

    //Add a person on the end of the array and save it to disk.
    public void addPerson(Person p){
        persons.add(p);
        saveToFile();
    }

    //Save the array to disk.
    public void updatePerson(){
        saveToFile();
    }

    //Remove a person at position position, and save the array to disk.
    public void removePerson(int position){
        persons.remove(position);
        saveToFile();
    }

    //return the current count of persons in the array.
    public String getCount(){
        return String.valueOf(this.persons.size());
    }

    //Load the array from the file using json.
    private void loadFromFile(){
        this.persons = new ArrayList<Person>();

        try {
            FileInputStream fis = SizeBookApplication.getInstance().openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            String line = in.readLine();
            while (line != null) {
                this.persons.add(gson.fromJson(line, Person.class));
                line = in.readLine();
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
            File file = new File(SizeBookApplication.getInstance().getFilesDir(), FILENAME);
            file.setWritable(Boolean.TRUE);
        }
    }

    //Save the objects in a file with json.
    private void saveToFile(){
        try {
            FileOutputStream fos = SizeBookApplication.getInstance().openFileOutput(FILENAME, Context.MODE_PRIVATE);
            for(int x=0; x<persons.size(); x++) {
                fos.write((gson.toJson(persons.get(x))+"\n").getBytes());
            }
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
