package com.example.nabuint;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RiskScore {
    private double [] personal;
    private double [] prev_int;
    private double [] environmental;
    private ArrayList<double[]> interactions;
    private double [] personal_weights;
    private double [] prev_int_weights;
    private double [] environmental_weights;

    private static final String FORM_RESPONSES_FILE = "form_responses.txt";

    /**
     * Note - options in each question should be converted to a double between 0 and 1 to represent
     * the value of each answer, and it should match the orientation of the weights
     * @param personal - double array of values ranging from 0 to 1 for personal factors.
     * @param prev_int - double array of values ranging from 0 to 1 for prev-interactions factors.
     * @param environmental - double array of values ranging from 0 to 1 for environmental factors.
     */
    public RiskScore(double[] personal, double[] prev_int, double[] environmental){
        this.personal = personal;
        this.prev_int = prev_int;
        this.environmental = environmental;

        personal_weights = new double[]{0.25, 0.2, 0.2, 0.1, 0.1, 0.1, 0.05};
        prev_int_weights = new double[]{0.35, 0.35, 0.2, 0.1};
        environmental_weights = new double[]{0.60, 0.20, 0.10, 0.10};
        this.interactions = new ArrayList<>();
    }

    /**
     * calculates NABU score using weights
     * @return NABU(risk) score
     */
    public int getNABUscore(){
        double personal_score = 0;
        double prev_int_score = 0;
        double environmental_score = 0;
        final int NABU_SCORE_MAX = 100;

        for (int i = 0; i < personal.length; i++){
            personal_score += personal_weights[i] * personal[i];
        }
        for (int i = 0; i < prev_int.length; i++){
            prev_int_score += prev_int_weights[i] * prev_int[i];
        }
        for (int i = 0; i < environmental.length; i++){
            environmental_score += environmental_weights[i] * environmental[i];
        }
        // initial form responses percent value
        double nabu_score_percent = (environmental_score*0.2 + prev_int_score*0.4 + personal_score*0.4);

        // ongoing interaction forms calculation
        double ong_interactions_score = 0;
        double ong_interactions_percent = 0;
        double [] ong_interaction_weights = new double[]{0.30, 0.30, 0.25, 0.1, 0.05};
        for (double[] d: this.interactions){
            for (int i = 0; i < d.length; i++){
                ong_interactions_percent = ong_interaction_weights[i] * d[i];
            }
            ong_interactions_score = ong_interactions_percent * 3;
            // using 3 as the max amount of points you can get from one interaction entry
        }


        //final nabu score
        double nabu_score = ((double)NABU_SCORE_MAX * nabu_score_percent) + ong_interactions_score;


        return (int)nabu_score;
    }

    private void convertInteractionEntrytoPercent(){
        interactions = new ArrayList<>();

        ArrayList<String> resp_DATE = new ArrayList<>();
        ArrayList<String> resp_SANT = new ArrayList<>();
        ArrayList<String> resp_SD = new ArrayList<>();
        ArrayList<String> resp_PPL = new ArrayList<>();
        ArrayList<String> resp_TIME = new ArrayList<>();
        ArrayList<String> resp_LOC = new ArrayList<>();

        FileInputStream fis = null;

        try{
            BufferedReader br = new BufferedReader(new FileReader(FORM_RESPONSES_FILE));
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

        double[] temp;
        for (int i = 0; i < resp_DATE.size(); i++) {
            temp = new double[5];
            if (resp_SANT.get(i).equals("Yes")){
                temp[0] = 0.0;
            } else temp[0] = 1.0;

            if (resp_SD.get(i).equals("Yes")){
                temp[1] = 0.0;
            } else temp[0] = 1.0;

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
            } else temp[0] = 1.0;

            interactions.add(temp);

        }

    }


}
