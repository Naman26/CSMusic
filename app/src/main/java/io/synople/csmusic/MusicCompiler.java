package io.synople.csmusic;

import io.synople.csmusic.model.*;

import java.util.ArrayList;
import java.util.List;

public class MusicCompiler {
    // TODO: Create a method that takes in the List<Block> and gives a string for Harnoor to play
    // This method should essentially be our compiler.
    List<Block> blocks;
    List<List<NoteBlock>> notes;
    int totalCounts;

    public MusicCompiler() {
        this(new ArrayList<>());
    }

    //
    public MusicCompiler(List<Block> blocksIn) {
        blocks = blocksIn;
        notes = new ArrayList<>();
    }

    public void addBlock(Block b) {
        blocks.add(b);
    }

    public List<List<NoteBlock>>  compile() {
        for (int i = 0; i < blocks.size(); i++) {
            Block b = blocks.get(i);
        }
        return notes;
    }

    public void blockToNote(Block bIn){
        Block b = bIn;
        if (b instanceof NoteBlock) {
            addNoteBlockToNotes((NoteBlock) b);
        }

        if (b instanceof IfBlock) {
            addIfBlockToNotes((IfBlock) b);
        }

        if (b instanceof ForBlock) {
            addForBlocktoNotes((ForBlock) b);
        }

        if (b instanceof MethodBlock) {
            addMethodBlocktoNotes((MethodBlock) b);
        }
    }

    public void addNoteBlockToNotes(NoteBlock bIn){
        ArrayList<NoteBlock> arr = new ArrayList<>();
        arr.add((NoteBlock) bIn);
        notes.add(arr);
    }

    public void addIfBlockToNotes(IfBlock blockIn) {
        if (blockIn.getExpr().equals("CHORD") || blockIn.getExpr().equals("RANDOM")) {
            notes.add(blockIn.getNoteBlocks());
        }
    }

    public void addMethodBlocktoNotes(MethodBlock blockIn) {
        List<Block> list = blockIn.getList();
        for (int i = 0; i < list.size(); i++) {
            blockToNote(list.get(i));
        }
    }

    public void addForBlocktoNotes(ForBlock blockIn) {
        int loops = blockIn.getLoops();
        if (blockIn.hasMethod) {
            MethodBlock method = blockIn.getMethod();
            for (int i = 0; i < loops; i++) {
                addMethodBlocktoNotes(method);
            }
        }
        else
            {
                for (int i = 0; i < loops; i++) {
                   notes.addAll(blockIn.getNotes());
             }
            }

    }

}
