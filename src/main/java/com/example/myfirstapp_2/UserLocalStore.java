package com.example.myfirstapp_2;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * The type User local store.
 */
public class UserLocalStore {

    /**
     * The constant SP_NAME.
     */
    public static final String SP_NAME="userDetails";
    /**
     * The User local database.
     */
    SharedPreferences userLocalDatabase;

    /**
     * Instantiates a new User local store.
     *
     * @param context the context
     */
    public UserLocalStore(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    /**
     * Stocker les données utilisateur
     *
     * @param user the user
     */
    public void storeUserData(User user){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("name", user.name);
        spEditor.putString("surname", user.surname);
        spEditor.putString("mail", user.mail);
        spEditor.putString("sexe", user.sexe);
        spEditor.putString("username", user.username);
        spEditor.putString("password", user.password);
        spEditor.commit();
    }

    /**
     * Gets logged in user.
     *
     * @return l'utilisateur en tant que connecté
     */
    public User getLoggedInUser() {
        String name = userLocalDatabase.getString("name", "");
        String surname = userLocalDatabase.getString("surname", "");
        String mail = userLocalDatabase.getString("mail", "");
        String sexe = userLocalDatabase.getString("sexe", "");
        String username = userLocalDatabase.getString("username", "");
        String password = userLocalDatabase.getString("password", "");

        User storedUser = new User(name, surname, mail, sexe, username, password);
        return storedUser;

    }

    /**
     * Set userlogged in.
     *
     * @param loggedIn the logged in
     */
    public void setUserloggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();
    }


    /**
     * Get user logged in boolean.
     *
     * @return the boolean
     */
    public boolean getUserLoggedIn(){
        if (userLocalDatabase.getBoolean("loggedIn", false)){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Clear user data.
     */
    public void clearUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();

    }

}
