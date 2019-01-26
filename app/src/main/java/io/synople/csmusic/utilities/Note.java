package io.synople.csmusic.utilities;

import java.util.Random;

public class Note {

    //Key of C
    String[] keyC = {"C", "D", "E", "F", "G", "A", "B", "C"};

    //Key of D
    String[] keyD = {"D", "E", "F#", "G", "A", "B", "C#", "D"};

    //Key of G
    String[] keyG = {"G", "A", "B", "C", "D", "E", "F#", "G"};

    //all keys

    String[][] keys = {keyC, keyD, keyG};

    private int key, nameNum, oct, counts;
    private String fileName;
    private final String wav = ".wav";

    public Note() {
        Random rand = new Random();
        key = rand.nextInt(3);
        nameNum = rand.nextInt(8);
        oct = rand.nextInt(3);
        counts = rand.nextInt(4);
    }

    public Note(int keyIn, int nameNumIn, int octIn, int countsIn) {
        key = keyIn;
        nameNum = nameNumIn;
        oct = octIn;
        counts = countsIn;
    }

    @Override
    public String toString() {
        return nameNum + "";
    }
}
