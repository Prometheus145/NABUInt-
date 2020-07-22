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

        // get file values lol
        Activity activity = getActivity();

        TableLayout tbl = (TableLayout) activity.findViewById(R.id.interaction_entries);
        TableRow tableRow = new TableRow(activity); // may change to getActivity()?

        TextView head1 = new TextView(activity);
        head1.setText("Date");
        head1.setTextColor(Color.BLACK);
        tableRow.addView(head1);

        TextView head2 = new TextView(activity);
        head2.setText("Sanitation Measures?");
        head2.setTextColor(Color.BLACK);
        tableRow.addView(head2);

        TextView head3 = new TextView(activity);
        head3.setText("Social Distancing?");
        head3.setTextColor(Color.BLACK);
        tableRow.addView(head3);

        TextView head4 = new TextView(activity);
        head4.setText("# of People");
        head4.setTextColor(Color.BLACK);
        tableRow.addView(head4);

        TextView head5 = new TextView(activity);
        head5.setText("Time");
        head5.setTextColor(Color.BLACK);
        tableRow.addView(head5);

        TextView head6 = new TextView(activity);
        head6.setText("Location");
        head6.setTextColor(Color.BLACK);
        tableRow.addView(head6);

        // tbl.addView(tableRow);
/*
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
                resp_LOC.add(tmp[4]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < resp_DATE.size(); i++){
            tableRow = new TableRow(getContext()); // may change to getActivity()?

            TextView val1 = new TextView(getContext());
            val1.setText("Date");
            val1.setTextColor(Color.BLACK);
            tableRow.addView(val1);

            TextView val2 = new TextView(getContext());
            val2.setText("Sanitation Measures?");
            val2.setTextColor(Color.BLACK);
            tableRow.addView(val2);

            TextView val3 = new TextView(getContext());
            val3.setText("Social Distancing?");
            val3.setTextColor(Color.BLACK);
            tableRow.addView(val3);

            TextView val4 = new TextView(getContext());
            val4.setText("# of People");
            val4.setTextColor(Color.BLACK);
            tableRow.addView(val4);

            TextView val5 = new TextView(getContext());
            val5.setText("Time?");
            val5.setTextColor(Color.BLACK);
            tableRow.addView(val5);

            TextView val6 = new TextView(getContext());
            val6.setText("Location?");
            val6.setTextColor(Color.BLACK);
            tableRow.addView(val6);

            tbl.addView(tableRow);
        }*/

        return view;
    }




}