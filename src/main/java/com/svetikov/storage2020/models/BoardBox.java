package com.svetikov.storage2020.models;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "boards_box")
public class BoardBox implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idBox;
    private int positionXBox;
    private int positionYBox;
    private int quantityBox;
    private int lengthBox;
    private int withBox;


    public BoardBox(int positionX,int positionY,int quantity,int length,int with) {
        this.positionXBox=positionX;
        this.positionYBox=positionY;
        this.quantityBox=quantity;
        this.lengthBox=length;
        this.withBox=with;
    }


    public BoardBox() {
    }
}
