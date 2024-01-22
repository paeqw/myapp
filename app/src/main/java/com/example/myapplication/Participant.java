package com.example.myapplication;

import java.util.List;

public class Participant {
    private String firstname;
    private String lastname;
    private List<String> intrests;

    private String plec;
    private String wojewodztwo;

    public Participant(String firstname, String lastname, List<String> intrests) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.intrests = intrests;
    }

    public Participant(String firstname, String lastname, List<String> intrests, String plec, String wojewodztwo) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.intrests = intrests;
        this.plec = plec;
        this.wojewodztwo = wojewodztwo;
    }



    @Override
    public String toString() {
        String toReturn = "imie='" + firstname + '\'' +
                ", nazwisko='" + lastname + '\'' +
                ", zainteresowania=" + intrests;
        if (wojewodztwo != null) toReturn +=", plec='" + plec + '\'' + ", wojewodztwo='" + wojewodztwo;
        return toReturn;
    }
}
