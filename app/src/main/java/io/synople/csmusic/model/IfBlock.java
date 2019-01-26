package io.synople.csmusic.model;

import java.util.ArrayList;
import java.util.List;

public class IfBlock extends Block {
    // TODO: Make this selectable enum (e.g. previous note was high. etc.)
    String[] expression = {"CHORD", "MODULATION"};
    String expr;

    public List<NoteBlock> list;

    public IfBlock() {
        list = new ArrayList<>();
    }

    public IfBlock(List<NoteBlock> listIn) {
        // if statement followed by a chord
        if (list.size() == 3) {
            list = listIn;
            expr = expression[0];
        }

        // if statement followed by a rando
        if (list.size() == 1) {
            list = listIn;
            if (list.get(0).isRandom) {
                expr = expression[1];

            }
        }
    }

    public String getExpr() {
        return expr;
    }
}
