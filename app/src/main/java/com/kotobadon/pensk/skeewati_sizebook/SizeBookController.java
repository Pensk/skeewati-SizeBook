package com.kotobadon.pensk.skeewati_sizebook;

import android.util.Size;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by pensk on 2017/02/05.
 */

//Manipulates the information from the user and modifies the model. Formats data from the model for the views.
public class SizeBookController {
    private SizeBookModel sizeBookModel;

    public SizeBookController(SizeBookModel sizeBookModel){
        this.sizeBookModel = sizeBookModel;
    }

    public void setCurrentId(int id){
        SizeBookApplication.setCurrent(id);
    }

    public int getCurrentId(){
        return SizeBookApplication.getCurrent();
    }

    public Person getCurrentPerson(){
        return sizeBookModel.getPersons().get(SizeBookApplication.getCurrent());
    }

    public void removeCurrentPerson(){
        sizeBookModel.removePerson(SizeBookApplication.getCurrent());
    }

    //Add and Edit person takes the CharSequence data from TextEdits, and tries to format them into their respective formats.
    //If formatting fails (invalid or missing data) then the values are set to sensible defaults.
    public void addPerson(CharSequence name, CharSequence date, CharSequence bust, CharSequence neck, CharSequence chest, CharSequence waist, CharSequence hip, CharSequence inseam, CharSequence comment) {
        Person p = new Person(name.toString());
        p.setComment(comment.toString());
        try {
            p.setDate(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(date.toString()));
        } catch(Exception e){
            e.printStackTrace();
        }
        try {
            p.setBust(Float.parseFloat(bust.toString()));
        } catch(Exception e){
            p.setBust(0);
        }
        try {
            p.setNeck(Float.parseFloat(neck.toString()));
        } catch(Exception e){
            p.setNeck(0);
        }
        try {
            p.setChest(Float.parseFloat(chest.toString()));
        } catch(Exception e){
            p.setChest(0);
        }
        try {
            p.setWaist(Float.parseFloat(waist.toString()));
        } catch(Exception e){
            p.setWaist(0);
        }
        try {
            p.setHip(Float.parseFloat(hip.toString()));
        } catch(Exception e){
            p.setHip(0);
        }
        try {
            p.setInseam(Float.parseFloat(inseam.toString()));
        } catch(Exception e){
            p.setInseam(0);
        }

        sizeBookModel.addPerson(p);
    }

    public void editPerson(CharSequence name, CharSequence date, CharSequence bust, CharSequence neck, CharSequence chest, CharSequence waist, CharSequence hip, CharSequence inseam, CharSequence comment) {
        Person p = getCurrentPerson();
        p.setComment(comment.toString());
        try {
            p.setDate(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(date.toString()));
        } catch(Exception e){
            e.printStackTrace();
        }
        try {
            p.setBust(Float.parseFloat(bust.toString()));
        } catch(Exception e){
            p.setBust(0);
        }
        try {
            p.setNeck(Float.parseFloat(neck.toString()));
        } catch(Exception e){
            p.setNeck(0);
        }
        try {
            p.setChest(Float.parseFloat(chest.toString()));
        } catch(Exception e){
            p.setChest(0);
        }
        try {
            p.setWaist(Float.parseFloat(waist.toString()));
        } catch(Exception e){
            p.setWaist(0);
        }
        try {
            p.setHip(Float.parseFloat(hip.toString()));
        } catch(Exception e){
            p.setHip(0);
        }
        try {
            p.setInseam(Float.parseFloat(inseam.toString()));
        } catch(Exception e){
            p.setInseam(0);
        }
        sizeBookModel.updatePerson();
    }

    public String getCount() {
        return sizeBookModel.getCount();
    }

    //This formats the minimum necessary data for the MainActivity's list.
    public String[] personsToString() {
        ArrayList<Person> persons = sizeBookModel.getPersons();
        String[] people = new String[persons.size()];
        for(int x=0; x<persons.size(); x++){
            Person person = persons.get(x);
            people[x] = person.getName() + "\n " + person.getBustString() + person.getChestString() + person.getWaistString() + person.getInseamString();
        }
        return people;
    }
}
