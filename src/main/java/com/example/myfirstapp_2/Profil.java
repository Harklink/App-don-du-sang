package com.example.myfirstapp_2;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class Profil extends AppCompatActivity {

    TextView surname, name, sex, birthDate, bloodType, weight, height, imc, diseases, countDons;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Cas où la personne n'est pas connectée : redirigée vers la page pour s'identifier
        UserLocalStore userLocalStore = new UserLocalStore(this);
        if (!userLocalStore.getUserLoggedIn()){
            Intent myIntent = new Intent(this,Login.class);
            //myIntent.putExtra("previousActivity", "Profil");
            startActivity(myIntent);

        }
        //
        User storedUser = userLocalStore.getLoggedInUser();

        //surname = (TextView) findViewById(R.id.surname);
        //name = (TextView) findViewById(R.id.name);
        sex = (TextView) findViewById(R.id.sex);
        birthDate = (TextView) findViewById(R.id.birthDate);
        bloodType = (TextView) findViewById(R.id.bloodType);
        weight = (TextView) findViewById(R.id.weight);
        height = (TextView) findViewById(R.id.height);
        imc = (TextView) findViewById(R.id.imc);
        diseases = (TextView) findViewById(R.id.diseases);
        countDons = (TextView) findViewById(R.id.countDons);
        //surname.setText(storedUser.surname);
        //name.setText(storedUser.name);
        //sex.setText(storedUser.sexe);
        setContentView(R.layout.activity_profil);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}