package io.synople.csmusic.model;

import java.util.Random;

public class NoteBlock extends Block {

    //Key of C
    String[] keyC = {"c", "d", "e", "f", "g", "a", "b", "c"};

    //Key of D
    String[] keyD = {"d", "e", "f#", "g", "a", "b", "c#", "d"}; //c#, f#

    //Key of G
    String[] keyG = {"g", "a", "b", "c", "d", "e", "f#", "g"}; // f#

    //Rests
    String[] keyR = {"r"};

    //all keys
    String[][] keys = {keyC, keyD, keyG, keyR};

    //all octaves plus rest "" that cannot be accessed directly by random note gen
    String[] octStrings = {"3", "4", "5", "6", ""};

    //all lengths
    String[] countStrings = {"i", "q", "h", "w"};

    private int key, nameNum, oct, counts;

    // filename format is Name + Number + Count + .wav
    private String fileName;

    //create a random note
    public NoteBlock() {
        Random rand = new Random();

        key = rand.nextInt(4);

        // if a rest is selected at random nameNum = "r" and oct = ""
        if (key == 3) {
            nameNum = 0;
            oct = 4;
        }
        else {
            nameNum = rand.nextInt(8);
            oct = rand.nextInt(3);
            if (nameNum == 7) oct++;
        }

        counts = rand.nextInt(4);
        fileName = setFileName(key, nameNum, oct, counts);
    }


    // manually create a rest: @param keyIn must be 3
    // rest note wav files have no octaves
    public NoteBlock(int keyIn, int countsIn) {
        key = keyIn;
        nameNum = 0;
        oct = 4;
        counts = countsIn;
        fileName = setFileName(key, nameNum, oct, counts);
    }

    // manually create a played note: @ param keyIn must be in range 0-2 incl, @param nameNumIN must be in range 0-7 incl
    public NoteBlock(int keyIn, int nameNumIn, int octIn, int countsIn) {
        key = keyIn;
        nameNum = nameNumIn;
        oct = octIn;
        counts = countsIn;
        fileName = setFileName(key, nameNum, oct, counts);

    }

    // getter method for file name
    public String getFileName(){
        return fileName;
    }

    // helper method set file name for played note
    public String setFileName(int keyIn, int nameNumIn, int octIn, int countsIn) {
        return keys[keyIn][nameNumIn] + octStrings[octIn] + countStrings[countsIn];
    }

}
