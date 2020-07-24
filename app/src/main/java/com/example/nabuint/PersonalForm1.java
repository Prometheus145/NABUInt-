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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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

    private double[] personal = new double[7];
    private double[] prev_int = new double[4];
    private double[] environmental = new double[3];
    public int riskScore;
    private String RESPONSES_FILE = "personal_form_responses.txt";

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
    }

    // Submission button-------------------------------------------------------------
    public void submit(View view) {
        EditText editText1 = findViewById(R.id.numCasesInput);
        numCases = Integer.valueOf(editText1.getText().toString());

        EditText editText2 = findViewById(R.id.populationInput);
        population = Integer.valueOf(editText2.getText().toString());

        // Age range score calculation
        if (ageRange.equals("5-17")) {
            personal[0] = 1.0/12.0;
        } else if (ageRange.equals("0-4")) {
            personal[0] = 1.3/12.0;
        } else if (ageRange.equals("18-20")) {
            personal[0] = 2.0/12.0;
        } else if (ageRange.equals("30-39")) {
            personal[0] = 3.0/12.0;
        } else if (ageRange.equals("40-49")) {
            personal[0] = 4.0/12.0;
        } else if (ageRange.equals("50-64")) {
            personal[0] = 6.0/12.0;
        } else if (ageRange.equals("65-74")) {
            personal[0] = 8.0/12.0;
        } else if (ageRange.equals("75-84")) {
            personal[0] = 10.0/12.0;
        } else if (ageRange.equals("85+")) {
            personal[0] = 12.0/12.0;
        }

        // Major disease score
        if (majDisease.equals("I do not have any of the listed health conditions")) {
            personal[1] = 1.0/4.0;
        } else if (majDisease.equals("I have 1-2 of the listed health conditions")) {
            personal[1] = 2.0/4.0;
        } else {
            personal[1] = 4.0/4.0;
        }

        // Symptoms score
        if (symptoms.equals("No symptoms")) {
            personal[2] = 1.0/5.0;
        } else if (symptoms.equals("1 minor symptom")) {
            personal[2] = 1.5/5.0;
        } else if (symptoms.equals("2+ minor symptoms")) {
            personal[2] = 2.0/5.0;
        } else if (symptoms.equals("1 severe symptom")) {
            personal[2] = 3.0/5.0;
        } else if (symptoms.equals("1 severe and 2+ minor symptoms")) {
            personal[2] = 4.0/5.0;
        } else {
            personal[2] = 5.0/5.0;
        }

        // Access to sanitation score
        if (sanitation.equals("I have abundant/stable access to sanitation supplies")) {
            personal[3] = 1.0/4.0;
        } else if (sanitation.equals("I have minimal access to sanitation supplies")) {
            personal[3] = 2.0/4.0;
        } else {
            personal[3] = 4.0/4.0;
        }

        // Minor disease score
        if (minDisease.equals("I do not have any of the listed health conditions")) {
            personal[4] = 1.0/4.0;
        } else if (minDisease.equals("I have 1-2 of the listed health conditions")) {
            personal[4] = 2.0/4.0;
        } else {
            personal[4] = 4.0/4.0;
        }

        // Occupation score
        if (job.equals("I currently work from home")) {
            personal[5] = 1.0/3.0;
        } else if (job.equals("I rarely work face to face with others")) {
            personal[5] = 2.0/3.0;
        } else {
            personal[5] = 3.0/3.0;
        }

        // Past disease score
        if (pastDisease.equals("I have never had any of the listed health conditions")) {
            personal[6] = 1.0/3.0;
        } else if (pastDisease.equals("I have had 1-2 of the listed health conditions in the past")) {
            personal[6] = 2.0/3.0;
        } else {
            personal[6] = 3.0/3.0;
        }

        // Previous interactions sanitation score
        if (prevIntSan.equals("Most/every person took proper sanitation measures")) {
            prev_int[0] = 1.0/4.0;
        } else if (prevIntSan.equals("Some people took proper sanitation measures")) {
            prev_int[0] = 2.0/4.0;
        } else if (prevIntSan.equals("Only a few people took proper sanitation measures")) {
            prev_int[0] = 3.0/4.0;
        } else {
            prev_int[0] = 4.0/4.0;
        }

        // Number of participants score
        if (partNum.equals("Fewer than 5")) {
            prev_int[1] = 1.0/5.0;
        } else if (partNum.equals("5-10")) {
            prev_int[1] = 2.0/5.0;
        } else if (partNum.equals("10-20")) {
            prev_int[1] = 3.0/5.0;
        } else {
            prev_int[1] = 5.0/5.0;
        }

        // Indoors or outdoors score
        if (inOut.equals("Outside")) {
            prev_int[2] = 1.0/1.5;
        } else {
            prev_int[2] = 1.5/1.5;
        }

        // Social distancing past interactions score
        if (SD.equals("Always/often")) {
            prev_int[3] = 1.0/2.0;
        } else {
            prev_int[3] = 2.0/2.0;
        }

        // Number of cases in location score
        double infectionRate = Double.valueOf(numCases) / population;
        double casesPerOHT = infectionRate * 100000;
        if (casesPerOHT <= 500) {
            environmental[0] = 1.0/6.0;
        } else if (casesPerOHT <= 1000) {
            environmental[0] = 2.0/6.0;
        } else if (casesPerOHT <= 1500) {
            environmental[0] = 3.0/6.0;
        } else if (casesPerOHT <= 2000) {
            environmental[0] = 4.0/6.0;
        } else if (casesPerOHT <= 2500) {
            environmental[0] = 5.0/6.0;
        } else {
            environmental[0] = 6.0/6.0;
        }

        // Air quality score
        if (air.equals("Good")) {
            environmental[1] = 1.0/5.0;
        } else if (air.equals("Moderate")) {
            environmental[1] = 1.5/5.0;
        } else if (air.equals("Unhealthy for sensitve groups")) {
            environmental[1] = 2.0/5.0;
        } else if (air.equals("Unhealthy")) {
            environmental[1] = 3.0/5.0;
        } else if (air.equals("Very unhealthy")) {
            environmental[1] = 4.0/5.0;
        } else {
            environmental[1] = 5.0/5.0;
        }

        // Temperature score
        if (temp.equals("100+")) {
            environmental[2] = 2.0/2.0;
        }
        else if (temp.equals("90 - 100")) {
            environmental[2] = 1.5/2.0;
        } else if (temp.equals("70 - 90")) {
            environmental[2] = 1.0/2.0;
        } else if (temp.equals("50-70")) {
            environmental[2] = 1.0/2.0;
        } else if (temp.equals("32 - 50")) {
            environmental[2] = 1.5/2.0;
        } else {
            environmental[2] = 2.0/2.0;
        }

        //RiskScore riskEval = new RiskScore(personal,prev_int,environmental);
        //riskScore = riskEval.getNABUscore();

        // Toast.makeText(PersonalForm1.this,riskScore + "", Toast.LENGTH_SHORT).show();
        // finish();


        FileOutputStream fos = null;

        try {
            fos = openFileOutput(RESPONSES_FILE, MODE_PRIVATE);
            for (double d: personal) {
                fos.write((d + "\t").getBytes());
            }
            personal = null;
            fos.write(("\n").getBytes());
            for (double d: prev_int) {
                fos.write((d + "\t").getBytes());
            }
            prev_int = null;
            fos.write(("\n").getBytes());
            for (double d: environmental) {
                fos.write((d + "\t").getBytes());
            }
            environmental = null;
            fos.write(("\n").getBytes());
            Toast.makeText(this, "Saved your responses to " + getFilesDir() + "/" + RESPONSES_FILE, Toast.LENGTH_LONG).show();
            TimeUnit.SECONDS.sleep(1);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        finish();
    }
}

