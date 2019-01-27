package io.synople.csmusic.model;

import java.util.ArrayList;
import java.util.List;

public class ForBlock extends Block {
    public int loops;
    public List<NoteBlock> noteBlocks;
    public MethodBlock method;

    public ForBlock() {
        loops = 2;
        noteBlocks = new ArrayList<>();
    }

    public ForBlock(int loops) {
        this(loops, new ArrayList<>());
    }

    public ForBlock(int loopsIn, List<NoteBlock> noteBlocksIn) {
        loops = loopsIn;
        noteBlocks = noteBlocksIn;
    }

    public ForBlock(int loopsIn, MethodBlock methodIn) {
        loops = loopsIn;
        method = methodIn;
    }

    public int getLoops() {
        return loops;
    }

    public void setLoops(int n) {
        loops = n;
    }

}
