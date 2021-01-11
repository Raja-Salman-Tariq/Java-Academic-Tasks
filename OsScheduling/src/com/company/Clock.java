package com.company;

public class Clock {
    int time;
    final int quant;

    public Clock(int time, int q) {
        this.time = 0;
        quant=q;
    }

    public int getTime() {
        return time;
    }

    void tick(){
//        System.out.println("Adding quantum="+quant+" to time="+time);
        time+=quant;
//        System.out.println("Leading to time="+time);

    }
}
