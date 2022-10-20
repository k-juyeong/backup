package com.kh.exam3;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        System.out.println(Objects.hashCode("씨앗"));
        System.out.println(Objects.hashCode("씨앗2"));
        System.out.println(Objects.hashCode("씨앗3"));
        System.out.println(Objects.hashCode("씨앗3"));

    }
}
