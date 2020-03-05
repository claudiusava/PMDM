package com.example.gestion_alumnos.utils;

public class Usuario {

    String  name, surname, dni, email, password, course;


    public Usuario(String name, String surname, String dni, String email, String password, String course) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.email = email;
        this.password = password;
        this.course = course;
    }

    public boolean CampoVacio(){
        if(dni.equals("")&& name.equals("") && password.equals("") && course.equals("")){
            return false;
        } else {
            return true;
        }
    }



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getApellidos() {
        return surname;
    }
    public void setApellidos(String surname) {
        this.surname = surname;
    }


    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
}