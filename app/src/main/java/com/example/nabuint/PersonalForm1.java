package com.example.nabuint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class PersonalForm1 extends AppCompatActivity {

    private String ageRange = "";
    private String majDisease = "";
    private String symptoms = "";
    private String sanitation = "";
    private String minDisease = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_form1);

        // Link to symptoms
        TextView text = (TextView) findViewById(R.id.symptomsLink);
        text.setMovementMethod(LinkMovementMethod.getInstance());


        // Age question
        Spinner ageSpinner = findViewById(R.id.ageSpinner);
        ArrayAdapter<CharSequence> ageAdapter = ArrayAdapter.createFromResource(this, R.array.ageSpinner,
                android.R.layout.simple_spinner_item);
        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageSpinner.setAdapter(ageAdapter);
        ageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ageRange = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(adapterView.getContext(), "Please complete every question.", Toast.LENGTH_SHORT).show();
            }
        });

        // Major Disease Question
        Spinner majDiseaseSpinner = findViewById(R.id.majDiseaseSpinner);
        ArrayAdapter<CharSequence> majDiseaseAdapter = ArrayAdapter.createFromResource(this, R.array.majDiseaseSpinner,
                android.R.layout.simple_spinner_item);
        majDiseaseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        majDiseaseSpinner.setAdapter(majDiseaseAdapter);
        majDiseaseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                majDisease = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(adapterView.getContext(), "Please complete every question.", Toast.LENGTH_SHORT).show();
            }
        });

        // Symptoms Question
        Spinner symptomsSpinner = findViewById(R.id.symptomsSpinner);
        ArrayAdapter<CharSequence> symptomsAdapter = ArrayAdapter.createFromResource(this, R.array.symptomsSpinner,
                android.R.layout.simple_spinner_item);
        symptomsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        symptomsSpinner.setAdapter(symptomsAdapter);
        symptomsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                symptoms = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(adapterView.getContext(), "Please complete every question.", Toast.LENGTH_SHORT).show();
            }
        });

        // Sanitation question
        Spinner sanitationSpinner = findViewById(R.id.sanitationSpinner);
        ArrayAdapter<CharSequence> sanitationAdapter = ArrayAdapter.createFromResource(this, R.array.sanitationSpinner,
                android.R.layout.simple_spinner_item);
        sanitationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sanitationSpinner.setAdapter(sanitationAdapter);
        sanitationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sanitation = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(adapterView.getContext(), "Please complete every question.", Toast.LENGTH_SHORT).show();
            }
        });

        // Minor disease question
        Spinner minDiseaseSpinner = findViewById(R.id.minDiseaseSpinner);
        ArrayAdapter<CharSequence> minDiseaseAdapter = ArrayAdapter.createFromResource(this, R.array.minDiseaseSpinner,
                android.R.layout.simple_spinner_item);
        minDiseaseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        minDiseaseSpinner.setAdapter(minDiseaseAdapter);
        minDiseaseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                minDisease = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(adapterView.getContext(), "Please complete every question.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
