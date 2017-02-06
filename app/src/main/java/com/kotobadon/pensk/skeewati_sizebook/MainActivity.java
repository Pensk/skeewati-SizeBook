package com.kotobadon.pensk.skeewati_sizebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

//The first activity when loading the app. Lists all the current Person records, and their count.
//Information is fetched from the controller.
public class MainActivity extends AppCompatActivity {
    ListView personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personList = (ListView) findViewById(R.id.personList);
        TextView personCount = (TextView) findViewById(R.id.personCountText);
        Button newButton = (Button) findViewById(R.id.newPerson);

        //get a reference to the controller for the data.
        final SizeBookController sizeBookController = SizeBookApplication.getController();

        personCount.setText("Records: " + sizeBookController.getCount());

        //Set the CurrentID when an item is selected (-1 for new user, position in the list for current ones)
        personList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sizeBookController.setCurrentId(position);
                Intent intent = new Intent(MainActivity.this, PersonViewActivity.class);
                startActivity(intent);
            }
        });

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sizeBookController.setCurrentId(-1);
                Intent intent = new Intent(MainActivity.this, EditPersonActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.person_item, SizeBookApplication.getController().personsToString());
        personList.setAdapter(adapter);
    }
}
