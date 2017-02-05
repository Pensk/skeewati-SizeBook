package com.kotobadon.pensk.skeewati_sizebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Serializer serializer;
    private ArrayList<Person> persons;
    private ListView personList;
    private TextView personCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personList = (ListView) findViewById(R.id.personList);
        personCount = (TextView) findViewById(R.id.personCountText);

        persons = new ArrayList<Person>();
        serializer = new Serializer();


        Person person1 = new Person("Boi");
        person1.setWaist(5f);
        person1.setBust(2f);
        persons.add(person1);
        persons.add(new Person("Boi 2"));

        personCount.setText(String.valueOf(persons.size()));

        personList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person p = persons.get(position);
                Intent intent = new Intent();
                startActivity(intent);
            }
        });


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
