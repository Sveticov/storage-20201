package com.svetikov.storage2020.models;


import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "plc")
public class PLCData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String adrIP;
    private int lengthRead;
    private int lengthWrite;
    private int dbRead;
    private int dbWrite;

//    @Transient
//    private double[] watchDog;
    private int rack;
    private int slot;
//    @Transient
//
//    private int areaRead = S7.S7AreaDB;
//    @Transient
//
//    private int areaWrite = S7.S7AreaDB;


    public PLCData() {
    }

    public PLCData(String adrIP, int lengthRead, int lengthWrite, int dbRead, int dbWrite, int rack, int slot) {
        this.adrIP = adrIP;
        this.lengthRead = lengthRead;
        this.lengthWrite = lengthWrite;
        this.dbRead = dbRead;
        this.dbWrite = dbWrite;
        this.rack = rack;
        this.slot = slot;
    }
}
