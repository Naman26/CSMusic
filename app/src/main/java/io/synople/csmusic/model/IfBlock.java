package io.synople.csmusic.model;

public class IfBlock extends Block {
    public String expression; // TODO: Make this selectable enum (e.g. previous note was high. etc.)
    public MethodBlock taskA; // method A
    public MethodBlock taskB; // method B
}
