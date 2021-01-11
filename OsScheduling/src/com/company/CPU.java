package com.company;

import java.util.Queue;

public class CPU {

    Performance perf;

    public CPU(){
        perf=new Performance();
    }



    Queue<Process> simulate(Queue<Process> readyQueue, int time, int quantum) {
        if (readyQueue.isEmpty()){
//            System.out.printf("EMPTY !");
            return readyQueue;
        }
//        else{
//            System.out.println("Not empty !");
//        }
        Process processing;
//        int waste;
        processing = readyQueue.poll();
        processing.setServiceTime(processing.getServiceTime() - quantum);
        if (processing.getServiceTime() > 0) {
            processing.setSwitchCount(processing.getSwitchCount() + 1);
            readyQueue.add(processing);
            processing.handleOnOffTimes(time, time+quantum);
        }
        else{
//            waste=quantum
//            processing.handleOnOffTimes(time, time+);
//            System.out.println("***************************************************");
            perf.addOnCompletion(processing, time+processing.getServiceTime(), 0- processing.getServiceTime());
        }

        return readyQueue;
    }
}
