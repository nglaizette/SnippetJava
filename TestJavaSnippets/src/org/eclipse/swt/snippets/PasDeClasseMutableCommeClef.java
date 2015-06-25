package org.eclipse.swt.snippets;

import java.util.HashMap;

/**
 * <p>
 * PasDeClasseMutableCommeClef: Classe qui demontre pourquoi il faut eviter l'utilisation d'une
 * classe mutable comme clef d'une HashMap
 * <p>
 * Created on 24 juin 2015
 * 
 * @author glaizett
 */
public class PasDeClasseMutableCommeClef {

    public static void main(String[] args) {
        Toto myToto = new Toto();
        HashMap<Toto, Integer> myHash = new HashMap<Toto, Integer>();
        myHash.put(myToto, new Integer(1));

        displayIfMyKeyIsInDaHash(myToto, myHash);
        myToto.setAgeToto(21);
        displayIfMyKeyIsInDaHash(myToto, myHash);

        Toto myTutu = new Toto(21);
        myHash.put(myTutu, new Integer(42));
        displayIfMyKeyIsInDaHash(myToto, myHash);
    }

    /**
     * Affiche si toto est dans myHash
     * 
     * @param toto
     * @param myHash
     */
    private static void displayIfMyKeyIsInDaHash(Toto toto, HashMap<Toto, Integer> hash) {
        if (hash.containsKey(toto)) {
            System.out.println("Super myToto est dans ma hash #" + hash.get(toto));
        }
        else {
            System.out.println("Ben ou qu'il est myToto?");
        }
    }

}
