package com.example.myfirstapp_2;

/**
 * The type User.
 */
public class User {

    /**
     * The Name.
     */
    public String name, /**
     * The Surname.
     */
    surname, /**
     * The Username.
     */
    username, /**
     * The Mail.
     */
    mail, /**
     * The Sexe.
     */
    sexe, /**
     * The Password.
     */
    password;

    /**
     * Instantiates a new User.
     *
     * @param name     nom
     * @param surname  prénom
     * @param mail     email
     * @param sexe     sexe (Femme/Homme)
     * @param username nom d'utilisateur
     * @param password mot de passe
     */
    public User(String name, String surname, String mail, String sexe, String username, String password ){
        this.name = name;
        this.mail = mail;
        this.surname = surname;
        this.sexe = sexe;
        this.username = username;
        this.password = password;
    }

    /**
     * Instantiates a new User.
     *
     * @param username nom d'utilisateur
     * @param password mot de passe
     */
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.name="";
        this.surname ="";
        this.mail="";
        this.sexe="";
    }
}
