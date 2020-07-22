package com.example.nabuint;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class InteractionEntryForm  extends AppCompatActivity {

    private String interactionsDATE_res = "HELLO";
    private String interactionsSANT_res = "";
    private String interactionsSD_res = "";
    private String interactionsPPL_res = "";
    private String interactionsTIME_res = "";
    private String interactionsLOC_res = "";
    private ArrayList<String> form_responses;
    EditText mEditText;

    private static final String FORM_RESPONSES_FILE = "form_responses.txt";
    // device file path: /data/data/com.example.nabuint/files/form_responses.txt

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interaction_entry_form);

        form_responses = new ArrayList<String>();

        // spinner 1 - Sanitation
        Spinner spinner1 = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.binaryanswer,
                android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                interactionsSANT_res = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(adapterView.getContext(), "Complete the form!", Toast.LENGTH_SHORT).show();
            }
        });

        // spinner 2 = social distancing
        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.binaryanswer,
                android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                interactionsSD_res = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(adapterView.getContext(), "Complete the form!", Toast.LENGTH_SHORT).show();
            }
        });

        // spinner 3 = number of people
        Spinner spinner3 = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.interactionspeople,
                android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                interactionsPPL_res = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(adapterView.getContext(), "Complete the form!", Toast.LENGTH_SHORT).show();
            }
        });

        // spinner 4 = time of interaction
        Spinner spinner4 = findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,
                R.array.interactionstime,
                android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                interactionsTIME_res = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(adapterView.getContext(), "Complete the form!", Toast.LENGTH_SHORT).show();
            }
        });

        // spinner 5 = indoors/outdoors
        Spinner spinner5 = findViewById(R.id.spinner5);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this,
                R.array.interactionsplace,
                android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter5);
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                interactionsLOC_res = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(adapterView.getContext(), "Complete the form!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void submit(View view) throws InterruptedException {

        // Edit Text - Date
        mEditText = (EditText) findViewById(R.id.date_entry);
        interactionsDATE_res = mEditText.getText().toString();

        form_responses.add(interactionsDATE_res);
        form_responses.add(interactionsSANT_res);
        form_responses.add(interactionsSD_res);
        form_responses.add(interactionsPPL_res);
        form_responses.add(interactionsTIME_res);
        form_responses.add(interactionsLOC_res);

        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FORM_RESPONSES_FILE, MODE_APPEND | MODE_PRIVATE);
            for (String s: form_responses) {
                fos.write((s + "\t").getBytes());
            }
            form_responses = null;
            fos.write(("\n").getBytes());
            Toast.makeText(this, "Saved your responses to " + getFilesDir() + "/" + FORM_RESPONSES_FILE, Toast.LENGTH_LONG).show();
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

    /*public void returnToMain(View v){
        //startActivity(new Intent(InteractionEntryForm.this, MainActivity.class));
        finish()
    }*/
}