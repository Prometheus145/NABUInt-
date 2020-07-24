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
    public RiskScore(double[] personal, double[] prev_int, double[] environmental, ArrayList<double[]> ong_int ){
        this.personal = personal;
        this.prev_int = prev_int;
        this.environmental = environmental;
        this.interactions = ong_int;

        personal_weights = new double[]{0.2, 0.25, 0.2, 0.1, 0.1, 0.1, 0.05};
        prev_int_weights = new double[]{0.35, 0.2, 0.1, 0.35};
        environmental_weights = new double[]{0.65, 0.25, 0.10};

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
                ong_interactions_percent += ong_interaction_weights[i] * d[i];
            }
            ong_interactions_score = ong_interactions_score + ong_interactions_percent * 2.0;
            ong_interactions_percent = 0.0;
            // using 2 as the max amount of points you can get from one interaction entry
        }

        //final nabu score
        double nabu_score = ((double)NABU_SCORE_MAX * nabu_score_percent) + ong_interactions_score;


        return (int)nabu_score;
    }


}
