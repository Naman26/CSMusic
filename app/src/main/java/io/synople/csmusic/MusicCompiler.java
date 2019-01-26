package io.synople.csmusic;

import io.synople.csmusic.model.Block;
import io.synople.csmusic.model.MethodBlock;
import io.synople.csmusic.model.NoteBlock;

import java.util.ArrayList;
import java.util.List;

public class MusicCompiler {
    // TODO: Create a method that takes in the List<Block> and gives a string for Harnoor to play
    // This method should essentially be our compiler.
    List<Block> blocks;
    List<NoteBlock> notes;
    int totalCounts;

    public MusicCompiler(){
        blocks = new ArrayList<Block>();
    }

    //
    public MusicCompiler(List<Block> blocksIn){
       blocks = blocksIn;
    }

    public void addBlock(Block b){
        blocks.add(b);
    }

    public List<NoteBlock> compile() {
        for (int i = 0; i < blocks.size(); i++){
            Block b = blocks.get(i);
            if (b instanceof NoteBlock){
                notes.add((NoteBlock) b);
            }
        }
        return notes;
    }
}
