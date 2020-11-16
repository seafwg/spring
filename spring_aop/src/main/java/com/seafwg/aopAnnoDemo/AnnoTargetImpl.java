package com.seafwg.aopAnnoDemo;

import org.springframework.stereotype.Component;

@Component("target")
public class AnnoTargetImpl implements AannoTarget{
    public void run() {
        System.out.println("AnnoTargetImpl Running...");
    }
}
