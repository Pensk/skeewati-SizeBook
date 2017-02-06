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

public class PersonViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_view);

        Intent intent = getIntent();

        TextView name = (TextView) findViewById(R.id.personName);
        TextView bust = (TextView) findViewById(R.id.personBust);
        TextView chest = (TextView) findViewById(R.id.personChest);
        TextView waist = (TextView) findViewById(R.id.personWaist);
        TextView inseam = (TextView) findViewById(R.id.personInseam);
        Button backButton = (Button) findViewById(R.id.backButton);

        name.setText("Name: " + intent.getStringExtra("name"));
        bust.setText("Bust: " + intent.getFloatExtra("bust", 0));
        chest.setText("Chest: " + intent.getFloatExtra("chest", 0));
        waist.setText("Waist: " + intent.getFloatExtra("waist", 0));
        inseam.setText("Inseam: " + intent.getFloatExtra("inseam", 0));

        backButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(PersonViewActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
