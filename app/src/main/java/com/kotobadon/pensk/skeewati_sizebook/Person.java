package com.kotobadon.pensk.skeewati_sizebook;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by pensk on 2017/02/02.
 */

//Person holds the individual data of a record.
public class Person {
    private String name; // (textual)
    private Date date; // (when the dimensions were reasonably valid, in yyyy-mm-dd format)
    private float neck; // (circumference in inches, numeric)
    private float bust; // (circumference in inches, numeric)
    private float chest; // (circumference in inches, numeric)
    private float waist; // (circumference in inches, numeric)
    private float hip; // (circumference in inches, numeric)
    private float inseam; // (length in inches, numeric)
    private String comment; // (textual)

    //Getters and Setters for the information.

    public Person(String name){
        this.name = name;
    }

    public String getName() { return this.name; }

    public float getBust() { return this.bust; }

    public float getChest() { return this.chest; }

    public float getWaist() { return this.waist; }

    public float getInseam() { return this.inseam; }

    public void setBust(float bust){
        this.bust = bust;
    }

    public void setWaist(float waist) {
        this.waist = waist;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNeck(float neck) {
        this.neck = neck;
    }

    public void setChest(float chest) {
        this.chest = chest;
    }

    public String getDate() {
        if(this.date == null){
            return "n/a";
        }
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        return format.format(this.date);
    }

    public float getNeck() {
        return neck;
    }

    public float getHip() {
        return hip;
    }

    public String getComment() {
        if(comment == null){
            return "";
        }
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setInseam(float inseam) {
        this.inseam = inseam;
    }

    public void setHip(float hip) {
        this.hip = hip;
    }

    //Format the minimum necessary data for the mainactivity's list
    public String getBustString() {
        if (this.bust > 0) {
            return "bust: " + this.bust + " ";
        } else {
            return "";
        }
    }

    public String getChestString() {
        if (this.chest > 0) {
            return "chest: " + this.chest + " ";
        } else {
            return "";
        }
    }

    public String getWaistString() {
        if (this.waist > 0) {
            return "waist: " + this.waist + " ";
        } else {
            return "";
        }
    }

    public String getInseamString() {
        if (this.inseam > 0) {
            return "inseam: " + this.inseam + " ";
        } else {
            return "";
        }
    }
}
