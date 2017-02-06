package com.kotobadon.pensk.skeewati_sizebook;

import java.util.Date;

/**
 * Created by pensk on 2017/02/02.
 */

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

    public Person(String name, Date date, float neck, float bust, float chest, float waist, float hip, float inseam, String comment) {
        this.name = name;
        this.date = date;
        this.neck = neck;
        this.bust = bust;
        this.chest = chest;
        this.waist = waist;
        this.hip = hip;
        this.inseam = inseam;
        this.comment = comment;
    }

    public Person(String name){
        this.name = name;
    }

    public String getName() { return this.name; }

    public float getBust() { return this.bust; }

    public float getChest() { return this.chest; }

    public float getWaist() { return this.waist; }

    public float getInseam() { return this.inseam; }

    public String getBustString() {
        if (this.bust > 0) {
            return "bust: " + this.bust;
        } else {
            return "";
        }
    }

    public String getChestString() {
        if (this.chest > 0) {
            return "chest: " + this.chest;
        } else {
            return "";
        }
    }

    public String getWaistString() {
        if (this.waist > 0) {
            return "waist: " + this.waist;
        } else {
            return "";
        }
    }

    public String getInseamString() {
        if (this.inseam > 0) {
            return "inseam: " + this.inseam;
        } else {
            return "";
        }
    }

    public void setBust(float bust){
        this.bust = bust;
    }

    public void setWaist(float waist) {
        this.waist = waist;
    }
}
