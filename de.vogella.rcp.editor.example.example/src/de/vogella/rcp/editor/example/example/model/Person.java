/*
 * Copyright (C) 2004-@year@ by IFP-GROUP.
 * All rights reserved.
 *
 * IFP Headquarters:
 * 1 & 4, avenue de Bois-Preau
 * 92852 Rueil-Malmaison Cedex - France
 */
package de.vogella.rcp.editor.example.example.model;

/**
 * IFP-Group <br>
 * Infrastructure Project <br>
 * <p>
 * Person:
 * <p>
 * Created on 5 sept. 2014
 * 
 * @author glaizett
 */
public class Person {
    private static int counter = 0;

    private int id;

    private String firstName;

    private String lastName;

    public Person(String firstName, String lastName) {
        id = counter++;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*
     * Overridden method (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    /*
     * Overridden method (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }

    /*
     * Overridden method (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Person other = (Person) obj;
        if (firstName == null) {
            if (other.firstName != null) {
                return false;
            }
        }
        else if (!firstName.equals(other.firstName)) {
            return false;
        }
        if (lastName == null) {
            if (other.lastName != null) {
                return false;
            }
        }
        else if (!lastName.equals(other.lastName)) {
            return false;
        }
        return true;
    }
}
