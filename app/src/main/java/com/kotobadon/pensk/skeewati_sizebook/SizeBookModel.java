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
    private ArrayList<Person> persons;

    public SizeBookModel() {
        gson = new Gson();
        loadFromFile();
    }

    public ArrayList<Person> getPersons(){
        return this.persons;
    }

    public void addPerson(Person p){
        persons.add(p);
        saveToFile();
    }

    public void updatePerson(){
        saveToFile();
    }

    public void removePerson(int position){
        persons.remove(position);
        saveToFile();
    }

    public String getCount(){
        return String.valueOf(this.persons.size());
    }

    //public String[] personsToString(){
        //persons.toArray();

    //}

    private void loadFromFile(){
        this.persons = new ArrayList<Person>();

        try {
            FileInputStream fis = SizeBookApplication.getInstance().openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            String line = in.readLine();
            System.out.println("---------- NEW READ -----------------");
            while (line != null) {
                System.out.println("---- "+ line);
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
