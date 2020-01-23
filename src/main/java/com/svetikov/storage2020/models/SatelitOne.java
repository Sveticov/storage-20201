package com.svetikov.storage2020.models;

import lombok.Data;

@Data
public class SatelitOne extends Satelit {
    private int positionX;
    private int positionY;
    private boolean occupied;
    private BoardBox boardBox;

    public SatelitOne(int positionX, int positionY, boolean occupied, BoardBox boardBox) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.occupied = occupied;
        this.boardBox = boardBox;
    }
}
