package com.example.myfirstapp_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

/**
 * The type Main activity security.
 */
public class MainActivitySecurity extends AppCompatActivity implements View.OnClickListener {


    /**
     * The B logout.
     */
    Button bLogout;
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
    etUsername;
    /**
     * The User local store.
     */
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_security);

        etName = (EditText) findViewById(R.id.etName);
        etSurname = (EditText) findViewById(R.id.etSurname);
        etMail = (EditText) findViewById(R.id.etMail);
        etSexe = (EditText) findViewById(R.id.etSexe);
        etUsername = (EditText) findViewById(R.id.etUsername);

        bLogout = (Button) findViewById(R.id.bLogout);

        bLogout.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);

    }

    @Override
    protected void onStart(){
        super.onStart();

        if (authenticate() == true){
            displayUserDetails();
        }

    }

    private boolean authenticate(){
        return userLocalStore.getUserLoggedIn();
    }

    private void displayUserDetails(){
        User user = userLocalStore.getLoggedInUser();
        etUsername.setText(user.username);
        etName.setText(user.name);
        etSurname.setText(user.surname);
        etMail.setText(user.mail);
        etSexe.setText(user.sexe);

    }



    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bLogout:
                userLocalStore.clearUserData();
                userLocalStore.setUserloggedIn(false);




                startActivity(new Intent(this, Register.class));
                break;
        }

    }
}