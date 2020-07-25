package com.example.nabuint;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tab1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private static final String FORM_RESPONSES_FILE = "form_responses.txt";
    private static final String PERSONAL_FORM_RESPONSES_FILE = "personal_form_responses.txt";
    ArrayList<double[]> interactions;
    private double [] personal;
    private double [] prev_int;
    private double [] environmental;
    RiskScore riskScore;
    private int NABUScore;

    public Tab1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab1.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab1 newInstance(String param1, String param2) {
        Tab1 fragment = new Tab1();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);


        convertInteractionEntrytoPercent();
        getDoubleValues();

        riskScore = new RiskScore(personal, prev_int, environmental, interactions);

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PersonalForm1.class);
                startActivity(intent);
            }
        });

        NABUScore = riskScore.getNABUscore();

        // Print NABUScore to screen
        TextView riskScoreStr = (TextView) view.findViewById((R.id.riskScoreTxt));
        riskScoreStr.setText(Integer.toString(NABUScore));

        // Refresh button on risk score tab
        Button button3 = (Button) view.findViewById(R.id.riskScoreRefresh);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getActivity().finish();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void convertInteractionEntrytoPercent() {
        interactions = new ArrayList<>();
        FileInputStream fis = null;
        Activity activity = getActivity();

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
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        double[] temp;
        for (int i = 0; i < resp_DATE.size(); i++) {
            temp = new double[5];
            if (resp_SANT.get(i).equals("Yes")){
                temp[0] = 0.0;
            } else temp[0] = 1.0;

            if (resp_SD.get(i).equals("Yes")){
                temp[1] = 0.0;
            } else temp[1] = 1.0;

            if (resp_PPL.get(i).equals("Fewer than 5")){
                temp[2] = 0.2;
            } else if (resp_PPL.get(i).equals("5-10")) {
                temp[2] = 0.4;
            } else if (resp_PPL.get(i).equals("10-20")) {
                temp[2] = 0.6;
            } else if (resp_PPL.get(i).equals("20-100")) {
                temp[2] = 0.8;
            } else if (resp_PPL.get(i).equals("100+")) {
                temp[2] = 1.0;
            }

            if (resp_TIME.get(i).equals("Less than an hour")){
                temp[3] = 0.2;
            } else if (resp_TIME.get(i).equals("Between 1 and 3 hours")) {
                temp[3] = 0.4;
            } else if (resp_TIME.get(i).equals("Between 3 and 5 hours")) {
                temp[3] = 0.6;
            } else if (resp_TIME.get(i).equals("Between 5 and 8 hours")) {
                temp[3] = 0.8;
            } else if (resp_TIME.get(i).equals("More than 8 hours")) {
                temp[3] = 1.0;
            }

            if (resp_LOC.get(i).equals("Indoors")){
                temp[4] = 0.5;
            } else temp[4] = 1.0;

            interactions.add(temp);

        }

    }

    private void getDoubleValues() {

        Activity activity = getActivity();

        personal = new double[7];
        prev_int = new double[4];
        environmental = new double[3];
        String personal_set = "";
        String prev_int_set = "";
        String env_set = "";

        String[] personal_arr = null;
        String[] prev_int_arr = null;
        String[] env_arr = null;

        FileInputStream fis = null;

        try{
            fis = activity.openFileInput(PERSONAL_FORM_RESPONSES_FILE);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            personal_set = br.readLine();
            prev_int_set = br.readLine();
            env_set = br.readLine();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        personal_arr = personal_set.split("\t");
        prev_int_arr = prev_int_set.split("\t");
        env_arr = env_set.split("\t");
        if (personal_arr.length > 1) {
            for (int i = 0; i < personal_arr.length; i++) {
                personal[i] = Double.parseDouble(personal_arr[i]);
            }
            for (int i = 0; i < prev_int_arr.length; i++) {
                prev_int[i] = Double.parseDouble(prev_int_arr[i]);
            }
            for (int i = 0; i < env_arr.length; i++) {
                environmental[i] = Double.parseDouble(env_arr[i]);
            }
        }

    }
}

