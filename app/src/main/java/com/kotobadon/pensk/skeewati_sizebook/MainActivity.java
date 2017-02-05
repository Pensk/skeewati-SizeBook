package com.kotobadon.pensk.skeewati_sizebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Serializer serializer;
    private ArrayList<Person> persons;
    private ListView personList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        persons = new ArrayList<Person>();
        serializer = new Serializer();
        personList = (ListView) findViewById(R.id.personList);

        Person person1 = new Person("Boi");
        person1.setWaist(5f);
        person1.setBust(2f);
        persons.add(person1);
        persons.add(new Person("Boi 2"));
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        //String[] persons = Serializer.loadFromFile();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.person_item, serializer.personsToString(persons));
        personList.setAdapter(adapter);
    }
}
