package com.kotobadon.pensk.skeewati_sizebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//Responsible for editing Person data for new and already created records.
public class EditPersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_person);

        //Load the elements in the activity for editing
        Button backButton = (Button) findViewById(R.id.backButton);
        Button submitButton = (Button) findViewById(R.id.submitButton);
        final TextView name = (TextView) findViewById(R.id.nameEdit);
        final TextView date = (TextView) findViewById(R.id.dateEdit);
        final TextView bust = (TextView) findViewById(R.id.bustEdit);
        final TextView neck = (TextView) findViewById(R.id.neckEdit);
        final TextView chest = (TextView) findViewById(R.id.chestEdit);
        final TextView waist = (TextView) findViewById(R.id.waistEdit);
        final TextView hip = (TextView) findViewById(R.id.hipEdit);
        final TextView inseam = (TextView) findViewById(R.id.inseamEdit);
        final TextView comment = (TextView) findViewById(R.id.commentEdit);

        //If the ID of the current user is not -1 (new user), load the current information for the Person into the fields.
        System.out.println(SizeBookApplication.getController().getCurrentId());
        if(SizeBookApplication.getController().getCurrentId() > -1){
            Person p = SizeBookApplication.getController().getCurrentPerson();

            name.setText(p.getName());
            date.setText(p.getDate());
            neck.setText(String.valueOf(p.getNeck()));
            bust.setText(String.valueOf(p.getBust()));
            chest.setText(String.valueOf(p.getChest()));
            waist.setText(String.valueOf(p.getWaist()));
            hip.setText(String.valueOf(p.getHip()));
            inseam.setText(String.valueOf(p.getInseam()));
            comment.setText(p.getComment());
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditPersonActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //First, check that the name field is not empty.
        //Then, Depending on whether the current user exists or not editPerson or addPerson with the entered data.
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().length() > 0) {
                    if(SizeBookApplication.getController().getCurrentId() > -1) {
                        SizeBookApplication.getController().editPerson(
                                name.getText(),
                                date.getText(),
                                bust.getText(),
                                neck.getText(),
                                chest.getText(),
                                waist.getText(),
                                hip.getText(),
                                inseam.getText(),
                                comment.getText());
                    } else {
                        SizeBookApplication.getController().addPerson(
                                name.getText(),
                                date.getText(),
                                bust.getText(),
                                neck.getText(),
                                chest.getText(),
                                waist.getText(),
                                hip.getText(),
                                inseam.getText(),
                                comment.getText());
                    }
                    Intent intent = new Intent(EditPersonActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
