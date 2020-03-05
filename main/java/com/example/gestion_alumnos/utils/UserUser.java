package com.example.gestion_alumnos.utils;

public class UserUser {

    String name, surname;
    int phone, photo;

    public UserUser(String name, String surname, int phone, int photo) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPhone() {
        return phone;
    }

    public int getPhoto() {
        return photo;
    }
}