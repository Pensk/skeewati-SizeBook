package com.kotobadon.pensk.skeewati_sizebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//Show the data for a single Person record.
public class PersonViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_view);

        //Get the current person using the ID from the controller.
        Person p = SizeBookApplication.getController().getCurrentPerson();

        TextView name = (TextView) findViewById(R.id.personName);
        TextView date = (TextView) findViewById(R.id.personDate);
        TextView neck = (TextView) findViewById(R.id.personNeck);
        TextView bust = (TextView) findViewById(R.id.personBust);
        TextView chest = (TextView) findViewById(R.id.personChest);
        TextView waist = (TextView) findViewById(R.id.personWaist);
        TextView hip = (TextView) findViewById(R.id.personHip);
        TextView inseam = (TextView) findViewById(R.id.personInseam);
        TextView comment = (TextView) findViewById(R.id.personComment);
        Button backButton = (Button) findViewById(R.id.backButton);
        Button deleteButton = (Button) findViewById(R.id.deleteButton);
        Button editButton = (Button) findViewById(R.id.editButton);

        //Fill the fields with the current data
        name.setText("Name: " + p.getName());
        date.setText("Date: " + p.getDate());
        neck.setText("Neck: " + p.getNeck());
        bust.setText("Bust: " + p.getBust());
        chest.setText("Chest: " + p.getChest());
        waist.setText("Waist: " + p.getWaist());
        hip.setText("Hip: " + p.getHip());
        inseam.setText("Inseam: " + p.getInseam());
        comment.setText("Comment: " + p.getComment());

        //Listeners for Edit/Delete/Return to Main
        backButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(PersonViewActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SizeBookApplication.getController().removeCurrentPerson();
                Intent intent = new Intent(PersonViewActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonViewActivity.this, EditPersonActivity.class);
                startActivity(intent);
            }
        });
    }

}
