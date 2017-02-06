package com.kotobadon.pensk.skeewati_sizebook;

import java.util.ArrayList;

/**
 * Created by pensk on 2017/02/05.
 */
public class SizeBookController {

    public String[] personsToString(ArrayList<Person> persons){
        //persons.toArray();
        String[] people = new String[persons.size()];
        for(int x=0; x<persons.size(); ++x){
            Person person = persons.get(x);
            people[x] = person.getName() + "\n " + person.getBustString() + person.getChestString() + person.getWaistString() + person.getInseamString();
        }
        return people;
    }
}