package com.example.myfirstapp_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

/**
 * The type Register.
 */
public class Register extends AppCompatActivity implements View.OnClickListener{

    /**
     * The B register.
     */
    Button bRegister;
    /**
     * The Et name.
     */
    EditText etName, /**
     * The Et surname.
     */
    etSurname, /**
     * The Et mail.
     */
    etMail, /**
     * The Et sexe.
     */
    etSexe, /**
     * The Et username.
     */
    etUsername, /**
     * The Et password.
     */
    etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.etName);
        etSurname = (EditText) findViewById(R.id.etSurname);
        etMail = (EditText) findViewById(R.id.etMail);
        etSexe = (EditText) findViewById(R.id.etSexe);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.bRegister){

                String name = etName.getText().toString();
                String surname = etSurname.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String mail = etMail.getText().toString();
                String sexe = etSexe.getText().toString();

                User registerData = new User(name, surname, mail, sexe, username, password);
                UserLocalStore userLocalStore = new UserLocalStore(this);
                userLocalStore.storeUserData(registerData);
                userLocalStore.setUserloggedIn(false);

            Intent myIntent = new Intent(this,Login.class);
            startActivity(myIntent);
        }

    }
}