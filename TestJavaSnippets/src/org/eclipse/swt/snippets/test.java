/*
 * Copyright (C) 2004-@year@ by IFP-GROUP.
 * All rights reserved.
 *
 * IFP Headquarters:
 * 1 & 4, avenue de Bois-Preau
 * 92852 Rueil-Malmaison Cedex - France
 */
package org.eclipse.swt.snippets;

public class test {
    public static void main(String[] args) {
        // try {
        // System.out.print("A");
        // int value = Integer.parseInt("8A");
        // System.out.print("B");
        // }
        // catch (NumberFormatException exception) {
        // System.out.print("C");
        // return;
        // }
        // finally {
        // System.out.print("D");
        // }
        // System.out.print("E");

        int x = 5;
        double y = 3.5;
        if (x > 5 && y > x || x + 3 < y + 1) {
            System.out.println("A");
        }
        else if (x < y + 1 && x + y <= 12) {
            System.out.println("B");
        }
        else {
            System.out.println("C");
        }
        // for (;;) {
        // }

        Exception ddd;
    }

}
