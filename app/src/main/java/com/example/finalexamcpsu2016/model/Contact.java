package com.example.finalexamcpsu2016.model;

/**
 * Created by TOSHIBA on 18/12/2559.
 */
public class Contact {

    private String Name;
    private String Username;
    private String Password;



    public Contact(String Name, String Username, String Password){
        this.Name = Name;
        this.Username =Username;
        this.Password =Password;
           }


    public String getName() {

        return Name;
    }

    public String getUsername() {

        return Username;
    }

    public String getPassword() {

        return Password;
    }


    @Override
    public String toString() {

        return Name;
    }


}
