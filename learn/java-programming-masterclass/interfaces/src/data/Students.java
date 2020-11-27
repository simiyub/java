package data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Students implements Saveable {
    List<String> students;

    @Override
    public void valuesToBeStored(ArrayList<String> readValues) {
        students=readValues;
    }

    @Override
    public void showRecords() {
        System.out.println(students.toString());
    }
}
