package data;

import java.util.Arrays;

public class Subscription {
    private String instrument;
    private int[] levels;
    private String tag;


    @Override
    public String toString() {
        return "Subscription{" +
                "instrument='" + instrument + '\'' +
                ", levels=" + Arrays.toString(levels) +
                ", tag='" + tag + '\'' +
                '}';
    }
}
