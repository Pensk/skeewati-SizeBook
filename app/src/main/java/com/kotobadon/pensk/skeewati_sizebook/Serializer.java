package com.kotobadon.pensk.skeewati_sizebook;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by pensk on 2017/02/02.
 */

public class Serializer {
    private Gson gson;
    private String filename;
    private static final String FILENAME = "file.sav";

    public Serializer(){
        gson = new Gson();
    }

    public ArrayList<Person> loadFromFile(){
        return new ArrayList<Person>();
    }

    public void saveToFile(ArrayList<Person> Persons){

    }
}
