package fr.ng.randomWalk;

import java.util.Random;

/**
 * Infrastructure Project <br>
 * <p>
 * RandomWalk:
 * <p>
 * Created on 21 mai 2015
 * 
 * @author glaizett
 */
public class RandomWalk {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int M = 1000; // outer loop
        int N = 1000; // inner loop

        double x = 0.1; // Any x / 0<x<1
        int outerCount = 0;
        for (int i = 0; i < M; i++) {
            int position = 0;
            int innerCount = 0;

            for (int j = 0; j < N; j++) {
                position += step();
                if (position > 0) {
                    innerCount++;
                }
            }

            if (innerCount / N < x) {
                outerCount++;
            }
        }
        System.out.println((double) outerCount / M);
        System.out.println(2 * Math.asin(Math.sqrt(x)) / Math.PI);
    }

    /**
     * @return
     */
    private static int step() {
        Random rand = new Random();
        if (rand.nextDouble() < 0.5) {
            return 1;
        }
        else {
            return -1;
        }
    }

}
