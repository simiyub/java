package data;

import java.util.ArrayList;

public interface Saveable {
    void valuesToBeStored(ArrayList<String> readValues);

    void showRecords();
}
