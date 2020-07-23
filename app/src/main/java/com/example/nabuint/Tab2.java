package com.example.nabuint;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tab2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String FORM_RESPONSES_FILE = "form_responses.txt";
    // device file path: /data/data/com.example.nabuint/files/form_responses.txt

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Tab2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab2.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab2 newInstance(String param1, String param2) {
        Tab2 fragment = new Tab2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab2, container, false);

        Button button1 = (Button) view.findViewById(R.id.interaction_entry_form_button);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), InteractionEntryForm.class);
                startActivity(intent);
            }
        });

        Button button2 = (Button) view.findViewById(R.id.clear_entries);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FileOutputStream fos = null;

                Activity activity = getActivity();

                try {
                    fos = activity.openFileOutput(FORM_RESPONSES_FILE, activity.MODE_PRIVATE);
                    fos.write(("").getBytes());
                    Toast.makeText(getActivity(), "Cleared all responses in " + activity.getFilesDir() + "/" + FORM_RESPONSES_FILE, Toast.LENGTH_LONG).show();
                    TimeUnit.SECONDS.sleep(1);
                     // temp solution, it refreshes the app
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
            }
        });

        Button button3 = (Button) view.findViewById(R.id.refresh);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getActivity().finish();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        populateTable(view);

        return view;
    }

    public void populateTable(View view){
        // get file values lol
        Activity activity = getActivity();

        TableLayout tbl = (TableLayout) view.findViewById(R.id.interaction_entries);
        TableRow tableRow;

        FileInputStream fis = null;

        ArrayList<String> resp_DATE = new ArrayList<>();
        ArrayList<String> resp_SANT = new ArrayList<>();
        ArrayList<String> resp_SD = new ArrayList<>();
        ArrayList<String> resp_PPL = new ArrayList<>();
        ArrayList<String> resp_TIME = new ArrayList<>();
        ArrayList<String> resp_LOC = new ArrayList<>();

        try{
            fis = activity.openFileInput(FORM_RESPONSES_FILE);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = null;

            while((line = br.readLine()) != null){
                String[] tmp = line.split("\t");
                resp_DATE.add(tmp[0]);
                resp_SANT.add(tmp[1]);
                resp_SD.add(tmp[2]);
                resp_PPL.add(tmp[3]);
                resp_TIME.add(tmp[4]);
                resp_LOC.add(tmp[5]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int count = 0;

        //First Border
        tableRow = new TableRow(activity);
        tableRow.setBackgroundColor(Color.BLACK);
        tableRow.setPadding(0, 0, 0, 2);
        tbl.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));

        for (int i = 0; i < resp_DATE.size(); i++){
            count++;

            tableRow = new TableRow(activity);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));

            TextView val1 = new TextView(activity);
            val1.setText(resp_DATE.get(i));
            val1.setTextSize(10);
            val1.setPadding(5, 5, 5, 5);
            tableRow.addView(val1);

            TextView val2 = new TextView(activity);
            val2.setTextSize(10);
            val2.setPadding(5, 5, 5, 5);
            val2.setText(resp_SANT.get(i));
            tableRow.addView(val2);

            TextView val3 = new TextView(activity);
            val3.setTextSize(10);
            val3.setPadding(5, 5, 5, 5);
            val3.setText(resp_SD.get(i));
            tableRow.addView(val3);

            TextView val4 = new TextView(activity);
            val4.setTextSize(10);
            val4.setPadding(5, 5, 5, 5);
            val4.setText(resp_PPL.get(i));
            tableRow.addView(val4);

            TextView val5 = new TextView(activity);
            val5.setTextSize(10);
            val5.setPadding(5, 5, 5, 5);
            val5.setText(resp_TIME.get(i));
            tableRow.addView(val5);

            TextView val6 = new TextView(activity);
            val6.setTextSize(10);
            val6.setPadding(5, 5, 5, 5);
            val6.setText(resp_LOC.get(i));
            tableRow.addView(val6);

            tbl.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));

            // Borders
            tableRow = new TableRow(activity);
            tableRow.setBackgroundColor(Color.BLACK);
            tableRow.setPadding(0, 0, 0, 2);
            tbl.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }
        // Toast.makeText(activity, "TEXT:" + count, Toast.LENGTH_LONG).show();
    }


}