package com.akka.Persistance;

import java.io.Serializable;

public class Evt implements Serializable{
    private static final long serialVersionUID = 1L;
    private final String data;
 
    public Evt(String data) {
        this.data = data;
    }
 
    public String getData() {
        return data;
    }
}
