package com.seafwg.domain.aopDemo;

public class Target implements TargetImpl {
    public void run() {
        System.out.println("target Running...");
    }
}
