package org.eclipse.swt.snippets;

/**
 * <p>
 * Toto: Classe mutable dont on a redéfinit le hashcode
 * <p>
 * Created on 24 juin 2015
 * 
 * @author glaizett
 */
public class Toto {
    private int ageToto = 0;

    public Toto() {
    }

    public Toto(int age) {
        this.ageToto = age;
    }

    public int getAgeToto() {
        return ageToto;
    }

    public void setAgeToto(int ageToto) {
        this.ageToto = ageToto;
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
        result = prime * result + ageToto;
        return result;
    }

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
        Toto other = (Toto) obj;

        if (ageToto != other.ageToto) {
            return false;
        }

        return true;
    }
}
