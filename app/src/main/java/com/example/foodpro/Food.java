package com.example.foodpro;

public class Food {
    String s_name;
    String s_email;
    String s_username;
    String s_address;
    String s_password;

    public Food(String sName, String s_name, String s_email, String s_address, String s_place) {
        this.s_name = s_name;
        this.s_email = s_email;
        this.s_address = s_address;
        this.s_username = s_username;
        this.s_password= s_password;
    }

    public String getS_name() {
        return s_name;
    }

    public String getS_email() {
        return s_email;
    }

    public String getS_address() {
        return s_address;
    }

    public String getS_username() {
        return s_username;
    }

    public String getS_password(){return s_password;}
}
