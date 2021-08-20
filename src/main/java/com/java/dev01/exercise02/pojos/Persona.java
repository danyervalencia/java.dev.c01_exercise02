package com.java.dev01.exercise02.pojos;

import java.io.Serializable;
import lombok.*;

@Getter @Setter
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String paternal;
    private String maternal;
    private String name;

    public Persona() {
    }

    public Persona(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /*
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaternal() {
        return this.paternal;
    }

    public void setPaternal(String paternal) {
        this.paternal = paternal;
    }

    public String getMaternal() {
        return this.maternal;
    }

    public void setMaternal(String maternal) {
        this.maternal = maternal;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }*/
}