/*
 * Copyright (C) 2004-@year@ by IFP-GROUP.
 * All rights reserved.
 *
 * IFP Headquarters:
 * 1 & 4, avenue de Bois-Preau
 * 92852 Rueil-Malmaison Cedex - France
 */
package ng.bestpractice.swttabletableviewer;

import java.util.ArrayList;
import java.util.List;

/**
 * IFP-Group <br>
 * Infrastructure Project <br>
 * <p>
 * DataModel:
 * <p>
 * Created on 15 oct. 2014
 * 
 * @author glaizett
 */
public class DataModel {
    private int samples;

    public DataModel(int samples) {
        this.samples = samples;
    }

    List<Person> getData() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < samples; i++) {
            persons.add(Person.createRandomPerson());
        }
        return persons;
    }
}
