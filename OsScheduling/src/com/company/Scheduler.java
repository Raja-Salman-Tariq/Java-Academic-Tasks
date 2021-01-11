package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Scheduler {

    int quantum;
    ProcessCreator proCrtr;
    Queue<Process> readyQueue;
    Clock clock;
    CPU cpu;
//    LinkedList<>

    public Scheduler(PriorityQueue<Process> procList, int q){
        proCrtr=new ProcessCreator(procList);
        readyQueue= new LinkedList<Process>();
        quantum=q;
        clock=new Clock(0, quantum);
        cpu=new CPU();
    }

    void execute(){
//        Process processing;
        while (!proCrtr.isDone() || !readyQueue.isEmpty()){
            System.out.println("At Time "+clock.getTime());
            proCrtr.showWaiting();
            showReady();
            readyQueue.addAll(proCrtr.toAdd(clock.getTime(), quantum));

//            if (proCrtr.isDone())
//                System.out.printf("proCrtr done !");
//            if (readyQueue.isEmpty())
//                System.out.printf("readyQ done !");
//            processing=readyQueue.poll();
//            processing.setServiceTime(processing.getServiceTime()-quantum);
//            if (processing.getServiceTime()>0){
//                processing.setSwitchCount(processing.getSwitchCount()+1);
//                readyQueue.add(processing);

            readyQueue=cpu.simulate(readyQueue, clock.getTime(), quantum);
//            }
            clock.tick();

            System.out.println("**************************************");
        }
    }

    void showReady(){
        System.out.println("\t//\t\tReady Q");
        Queue<Process> d=readyQueue;
        Queue<Process> x=new LinkedList<Process>();
        Process p;
        while (!d.isEmpty()){
            p=d.poll();
            System.out.println("Proc: "+p.pId+", w remaining: "+p.getServiceTime());
            x.add(p);
        }
        readyQueue=x;
    }
}
