/*
 * Copyright (C) 2004-@year@ by IFP-GROUP.
 * All rights reserved.
 *
 * IFP Headquarters:
 * 1 & 4, avenue de Bois-Preau
 * 92852 Rueil-Malmaison Cedex - France
 */
package fr.dr.ass0;

/**
 * IFP-Group <br>
 * Infrastructure Project <br>
 * <p>
 * Exo0:
 * <p>
 * Created on 4 nov. 2014
 * 
 * @author glaizett
 */
public class Exo0 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "aoto";
        String s2 = "zptp";

        if (s1.length() != s2.length()) {
            System.out.println("No good");
        }
        else {
            int sum = 0;
            for (int i = 0; i < s1.length(); i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                sum += distance(c1, c2);
            }
            System.out.println("Return " + sum);
        }

    }

    /**
     * @param c1
     * @param c2
     * @return
     */
    private static int distance(char c1, char c2) {
        int pos1 = (c1 - 'a');
        int pos2 = (c2 - 'a');
        int pos1Copy = pos1;
        int pos2Copy = pos2;
        int path1 = 0;
        int path2 = 0;
        while (pos1Copy != pos2) {
            pos1Copy = (pos1Copy + 1) % 26;
            path1++;
        }
        while (pos2Copy != pos1) {
            pos2Copy = (pos2Copy + 1) % 26;
            path2++;
        }

        return Math.min(path1, path2);
    }

}
