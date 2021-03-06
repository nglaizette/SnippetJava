
package ng.bestpractice.swttabletableviewer;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * DataModel:
 * <p>
 * Created on 15 oct. 2014
 * 
 * @author ng
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
