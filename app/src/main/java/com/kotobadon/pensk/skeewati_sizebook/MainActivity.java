package com.kotobadon.pensk.skeewati_sizebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Serializer serializer;
    private ArrayList<Person> persons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        persons = new ArrayList<Person>();
        serializer = new Serializer();

        persons.add(new Person("Boi"));
        persons.add(new Person("Boi 2"));
    }
}
