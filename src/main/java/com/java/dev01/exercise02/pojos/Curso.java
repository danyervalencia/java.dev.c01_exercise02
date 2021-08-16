package com.java.dev01.exercise02.pojos;

import java.io.Serializable;

public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codigo;
    private String nombre;
    private Integer creditos;

    public Curso() {
        super();
    }

    public Curso(String codigo, String nombre, Integer creditos) {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return "Curso [codigo=" + codigo + ", nombre=" + nombre + ", creditos=" + creditos + "]";
    }
}