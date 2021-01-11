package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Performance {
    //this class will include a completed list, a remaining list (optional), through put, cpu usage, etc. etc.
    List<Process> doneProcs;
    List<Integer> doneTime;
    List<Integer> wastedQuants;
    List<Integer> turnAroundTime;


    public Performance(){
        doneProcs=new ArrayList<>();
        doneTime= new ArrayList<>();
        wastedQuants= new ArrayList<>();
        turnAroundTime=new ArrayList<>();
    }

    void addOnCompletion(Process p, int t, int w){
        doneProcs.add(p);
        doneTime.add(t);
        wastedQuants.add(w);
        turnAroundTime.add(t-p.getArrivalTime());
    }

    void displayPerf(int time, int qua){
//        int n=1;
        float avg1=0, avg2=0, avg3=3;

        System.out.println("\n\nThe scheduling completed as follows: \n");

        for (int i=0; i<doneProcs.size(); i++){
            doneProcs.get(i).print();
            System.out.println("Turn Around Time: \t\t\t\t"+turnAroundTime.get(i));
            avg1+=doneProcs.get(i).wait;
            avg2+=turnAroundTime.get(i);
            avg3+=wastedQuants.get(i);
        }

        System.out.println("==========================================");
        System.out.println("Average Waiting Time \t\t=\t "+avg1/doneProcs.size());
        System.out.println("Average Turn Around Time \t=\t " +avg2/doneProcs.size());
        System.out.println("Total Time Taken: \t\t\t=\t"+time);
        System.out.println("Average CPU Utilization:\t=\t"+((3-avg3/(time/qua))/3)*100+ "%");
    }
}
