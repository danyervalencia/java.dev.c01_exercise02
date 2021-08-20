package com.java.dev01.exercise02.pojos;

import java.io.Serializable;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

//@AllArgsConstructor
//@Builder Curso.Builder().atributo(valor)....build()
@Getter @Setter
@ToString (exclude = {"cursCredits"})
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    private String cursCode;
    private String cursName;
    private Integer cursCredits;

    /*
    @Override
    public String toString() {
        return "Curso [cursCode=" + cursCode + ", nombre=" + cursName + ", creditos=" + cursCredits + "]";
    }*/
}