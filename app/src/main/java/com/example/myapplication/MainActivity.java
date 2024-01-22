package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    LinearLayout toggleSection;
    EditText firstnameEditText;
    EditText lastnameEditText;
    Spinner spinner;
    CheckBox javaCheckBox;
    CheckBox csharpCheckBox;
    CheckBox cplusCheckBox;
    RadioButton woman;
    RadioButton man;

    AlertDialog.Builder builder;
    Button btn;

    String wojewodztwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleSectiontoggle);
        toggleSection = findViewById(R.id.section1);// done


        firstnameEditText = findViewById(R.id.firstname);
        lastnameEditText = findViewById(R.id.lastname);//done

        spinner = findViewById(R.id.spinner); //done

        javaCheckBox = findViewById(R.id.javacheck);//done
        csharpCheckBox = findViewById(R.id.csharp);
        cplusCheckBox = findViewById(R.id.cplus);

        woman = findViewById(R.id.woman);
        man = findViewById(R.id.man);

        btn = findViewById(R.id.btn);

        List<String> lista = new ArrayList<>();
        lista.add("dolnośląskie");
        lista.add("kujawsko-pomorskie");
        lista.add("lubelskie");
        lista.add("lubuskie");
        lista.add("łódzkie");
        lista.add("małopolskie");
        lista.add("mazowieckie");
        lista.add("podkarpackie");

        ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,lista);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(ad);

        builder = new AlertDialog.Builder(this);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButton.isChecked()) {
                    System.out.println("a");
                    toggleSection.setVisibility(View.VISIBLE);
                } else {
                    toggleSection.setVisibility(View.GONE);
                }
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = firstnameEditText.getText().toString();
                String lname = lastnameEditText.getText().toString();

                List<String> zainteresowania = new ArrayList<>();

                if (javaCheckBox.isChecked()) zainteresowania.add("Java");
                if (cplusCheckBox.isChecked()) zainteresowania.add("C++");
                if (csharpCheckBox.isChecked()) zainteresowania.add("C#");
                Participant participant;
                String plec;
                if (toggleButton.isChecked()) {
                    if (woman.isChecked()) plec = "kobieta";
                    else plec = "mezczyzna";
                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            wojewodztwo = lista.get(position);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                    participant = new Participant(fname,lname,zainteresowania,plec,wojewodztwo);

                } else {
                    participant = new Participant(fname,lname,zainteresowania);
                }




                builder.setMessage(participant.toString()).setTitle("Dodaj uczestnika")
                        .setCancelable(false)
                        .setPositiveButton("Tak", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(getApplicationContext(),"Dodano", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Nie", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"Nie dodano",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });

                AlertDialog alert = builder.create();
                alert.setTitle("Dodaj uczestnika");
                alert.show();




            }
        });




    }
}