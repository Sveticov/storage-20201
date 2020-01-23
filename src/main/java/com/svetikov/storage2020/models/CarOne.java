package com.svetikov.storage2020.models;

import lombok.Data;

@Data
public class CarOne extends Car{

    private int positionY;

    public CarOne( int positionY) {

        this.positionY = positionY;
    }
}
