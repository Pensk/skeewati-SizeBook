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
public class SizeBookModel extends Model<View>{
    private Gson gson;
    private String filename;
    private static final String FILENAME = "file.sav";
    ArrayList<Person> persons;

    public SizeBookModel() {
        this.persons = new ArrayList<Person>();
        gson = new Gson();
        loadFromFile();
    }

    public ArrayList<Person> getPersons(){
        return this.persons;
    }

    public String getCount(){
        return String.valueOf(this.persons.size());
    }
    public String[] personsToString(){
        //persons.toArray();
        String[] people = new String[persons.size()];
        for(int x=0; x<persons.size(); ++x){
            Person person = persons.get(x);
            people[x] = person.getName() + "\n " + person.getBustString() + person.getChestString() + person.getWaistString() + person.getInseamString();
        }
        return people;
    }

    private void loadFromFile(){
        try {
            FileInputStream fis = SizeBookApplication.getContext().openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            String line = in.readLine();
            this.persons = new ArrayList<Person>();
            while (line != null) {
                this.persons.add(gson.fromJson(line, Person.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveToFile(){
        try {
            FileOutputStream fos = SizeBookApplication.getContext().openFileOutput(FILENAME, Context.MODE_PRIVATE);
            for(int x=0; x<persons.size(); ++x) {
                fos.write(gson.toJson(persons.get(x)).getBytes());
            }
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
