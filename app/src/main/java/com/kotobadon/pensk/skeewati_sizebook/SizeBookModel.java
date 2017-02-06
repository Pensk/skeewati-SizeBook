package com.kotobadon.pensk.skeewati_sizebook;


import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by pensk on 2017/02/05.
 */
public class SizeBookModel extends Model<View>{
    private Gson gson;
    private String filename;
    private static final String FILENAME = "file.sav";
    ArrayList<Person> persons;

    public String[] personsToString(){
        //persons.toArray();
        String[] people = new String[persons.size()];
        for(int x=0; x<persons.size(); ++x){
            Person person = persons.get(x);
            people[x] = person.getName() + "\n " + person.getBustString() + person.getChestString() + person.getWaistString() + person.getInseamString();
        }
        return people;
    }
}
