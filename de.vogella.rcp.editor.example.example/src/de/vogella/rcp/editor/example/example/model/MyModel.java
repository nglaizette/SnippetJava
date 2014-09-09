/*
 * Copyright (C) 2004-@year@ by IFP-GROUP.
 * All rights reserved.
 *
 * IFP Headquarters:
 * 1 & 4, avenue de Bois-Preau
 * 92852 Rueil-Malmaison Cedex - France
 */
package de.vogella.rcp.editor.example.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * IFP-Group <br>
 * Infrastructure Project <br>
 * <p>
 * MyModel:
 * <p>
 * Created on 5 sept. 2014
 * 
 * @author glaizett
 */
public class MyModel {
    private static MyModel model;

    private List<Person> persons = new ArrayList<Person>();

    private MyModel() {
        Person person = new Person("Hans", "Nase");
        persons.add(person);
        person = new Person("James", "Knopf");
        persons.add(person);
    }

    public static MyModel getInstance() {
        if (model == null) {
            model = new MyModel();
        }
        return model;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public Person getPersonById(int id) {
        for (Person person : persons) {
            if (person.getId() == id) {
                System.out.println("returned :" + person.toString());
                return person;
            }
        }
        return null;
    }
}
