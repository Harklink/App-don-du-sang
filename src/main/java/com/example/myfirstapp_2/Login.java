package com.example.myfirstapp_2;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.myfirstapp_2.ui.Historiquedon.HistoriqueFragment;

/**
 * The type Login.
 */
public class Login extends AppCompatActivity implements View.OnClickListener {

    /**
     * The B login.
     */
    Button bLogin;
    /**
     * The Et username.
     */
    EditText etUsername, /**
     * The Et password.
     */
    etPassword;
    /**
     * The Tvregister link.
     */
    TextView tvregisterLink;
    /**
     * The User local store.
     */
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = findViewById(R.id.bLogin);
        tvregisterLink = (TextView) findViewById((R.id.tvRegisterLink));

        bLogin.setOnClickListener(this);
        tvregisterLink.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);



    }


    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.bLogin:
                User storedUser = userLocalStore.getLoggedInUser();
                if (storedUser.username == ""){
                    Intent intent = new Intent(this, Register.class);
                    startActivity(intent);
                }

                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                if (username != storedUser.username || password != storedUser.password){
                    //break;
                }

                String previousActivity = "";
                if (getIntent().hasExtra("previousActivity")){
                    previousActivity = getIntent().getStringExtra("previousActivity");
                }

                userLocalStore.setUserloggedIn(true);
                switch(previousActivity){
                    case "":
                    case "Profil":
                        Intent i = new Intent(this, Profil.class);
                        startActivity(i);
                        break;
                    case "Historique":
                        Fragment historiqueFragment = new HistoriqueFragment();
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.container, historiqueFragment).commit();
                }



            break;

            case R.id.tvRegisterLink:
                startActivity(new Intent(this, Register.class));
                break;
        }

    }
}