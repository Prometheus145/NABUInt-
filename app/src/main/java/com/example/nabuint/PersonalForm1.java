package com.example.nabuint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

public class PersonalForm1 extends AppCompatActivity {

    private int numCases;
    private int population;

    private String ageRange = "";
    private String majDisease = "";
    private String symptoms = "";
    private String sanitation = "";
    private String minDisease = "";
    private String job = "";
    private String pastDisease = "";
    private String prevIntSan = "";
    private String partNum = "";
    private String inOut = "";
    private String SD = "";
    private String air = "";
    private String temp = "";
    private String humid = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_form1);

        // Link to symptoms
        TextView text = (TextView) findViewById(R.id.symptomsLink);
        text.setMovementMethod(LinkMovementMethod.getInstance());

        // Link to the number of cases in an area
        TextView text2 = (TextView) findViewById(R.id.numCasesLink);
        text2.setMovementMethod(LinkMovementMethod.getInstance());


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

        // Occupation question
        Spinner jobSpinner = findViewById(R.id.jobSpinner);
        ArrayAdapter<CharSequence> jobAdapter = ArrayAdapter.createFromResource(this, R.array.jobSpinner,
                android.R.layout.simple_spinner_item);
        jobAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jobSpinner.setAdapter(jobAdapter);
        jobSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                job = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(adapterView.getContext(), "Please complete every question.", Toast.LENGTH_SHORT).show();
            }
        });

        // Past disease question
        Spinner pastDiseaseSpinner = findViewById(R.id.pastDiseaseSpinner);
        ArrayAdapter<CharSequence> pastDiseaseAdapter = ArrayAdapter.createFromResource(this, R.array.pastDiseaseSpinner,
                android.R.layout.simple_spinner_item);
        pastDiseaseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pastDiseaseSpinner.setAdapter(pastDiseaseAdapter);
        pastDiseaseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pastDisease = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(adapterView.getContext(), "Please complete every question.", Toast.LENGTH_SHORT).show();
            }
        });

        // Previous interactions sanitation question
        Spinner prevIntSanSpinner = findViewById(R.id.prevIntSanSpinner);
        ArrayAdapter<CharSequence> prevIntSanAdapter = ArrayAdapter.createFromResource(this, R.array.prevIntSanSpinner,
                android.R.layout.simple_spinner_item);
        prevIntSanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        prevIntSanSpinner.setAdapter(prevIntSanAdapter);
        prevIntSanSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                prevIntSan = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(adapterView.getContext(), "Please complete every question.", Toast.LENGTH_SHORT).show();
            }
        });

        // Number of participants question
        Spinner partNumSpinner = findViewById(R.id.partNumSpinner);
        ArrayAdapter<CharSequence> partNumAdapter = ArrayAdapter.createFromResource(this, R.array.partNumSpinner,
                android.R.layout.simple_spinner_item);
        partNumAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        partNumSpinner.setAdapter(partNumAdapter);
        partNumSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                partNum = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(adapterView.getContext(), "Please complete every question.", Toast.LENGTH_SHORT).show();
            }
        });

        // Indoors or Outdoors question
        Spinner inOutSpinner = findViewById(R.id.inOutSpinner);
        ArrayAdapter<CharSequence> inOutAdapter = ArrayAdapter.createFromResource(this, R.array.inOutSpinner,
                android.R.layout.simple_spinner_item);
        inOutAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inOutSpinner.setAdapter(inOutAdapter);
        inOutSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                inOut = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(adapterView.getContext(), "Please complete every question.", Toast.LENGTH_SHORT).show();
            }
        });

        // Social Distancing question
        Spinner SDSpinner = findViewById(R.id.SDSpinner);
        ArrayAdapter<CharSequence> SDAdapter = ArrayAdapter.createFromResource(this, R.array.SDSpinner,
                android.R.layout.simple_spinner_item);
        SDAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SDSpinner.setAdapter(SDAdapter);
        SDSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SD = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(adapterView.getContext(), "Please complete every question.", Toast.LENGTH_SHORT).show();
            }
        });

        // Air quality question
        Spinner airSpinner = findViewById(R.id.airSpinner);
        ArrayAdapter<CharSequence> airAdapter = ArrayAdapter.createFromResource(this, R.array.airSpinner,
                android.R.layout.simple_spinner_item);
        airAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        airSpinner.setAdapter(airAdapter);
        airSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                air = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(adapterView.getContext(), "Please complete every question.", Toast.LENGTH_SHORT).show();
            }
        });

        // Temperature question
        Spinner tempSpinner = findViewById(R.id.tempSpinner);
        ArrayAdapter<CharSequence> tempAdapter = ArrayAdapter.createFromResource(this, R.array.tempSpinner,
                android.R.layout.simple_spinner_item);
        tempAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tempSpinner.setAdapter(tempAdapter);
        tempSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                temp = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(adapterView.getContext(), "Please complete every question.", Toast.LENGTH_SHORT).show();
            }
        });

        // Humidity question
        Spinner humidSpinner = findViewById(R.id.humidSpinner);
        ArrayAdapter<CharSequence> humidAdapter = ArrayAdapter.createFromResource(this, R.array.humidSpinner,
                android.R.layout.simple_spinner_item);
        humidAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        humidSpinner.setAdapter(humidAdapter);
        humidSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                humid = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(adapterView.getContext(), "Please complete every question.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void submit(View view)
    {
        EditText editText1 = findViewById(R.id.numCasesInput);
        numCases = Integer.valueOf(editText1.getText().toString());

        EditText editText2 = findViewById(R.id.populationInput);
        population = Integer.valueOf(editText2.getText().toString());


    }
}
