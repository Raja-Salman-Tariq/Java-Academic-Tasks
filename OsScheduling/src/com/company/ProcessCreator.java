package com.company;

import java.util.*;

public class ProcessCreator {
    PriorityQueue<Process> waitingQ;

    public ProcessCreator(PriorityQueue<Process> waitingQ) {
        this.waitingQ = waitingQ;
    }

    List<Process> toAdd(int time, int qua){

        List<Process> procs=new ArrayList<>();

        if (isDone())
            return procs;

//        PriorityQueue<Process> d=waitingQ;
//        while (!d.isEmpty()){
//            d.poll().print();
//        }

        while (true) {
            Process p = waitingQ.poll();
            if (p==null) {
                return procs;
            }
            if (p.getArrivalTime() <= time+qua) {
                procs.add(p);
            } else {
//                System.out.println("**********************\n***************\n******************");
                waitingQ.add(p);
//                Scanner sca=new Scanner(System.in);
//                System.out.println("Time: "+Integer.toString(time)+", while ATime: "+Integer.toString(p.getArrivalTime())+", Waiting Q is done ?" +
//                        waitingQ.isEmpty()+", and has length: "+waitingQ.size());
//                p.print();
//                sca.nextLine();
                break;
            }

        }
        return procs;
    }

    boolean isDone(){
        return waitingQ.isEmpty();
    }

    void showWaiting(){
        System.out.println("\t//\t\tWaiting Q");
        Queue<Process> d=new LinkedList<>();
        PriorityQueue<Process> x=new PriorityQueue<>(1, new MyComparator());

        d=waitingQ;
        Process p;
        while (!d.isEmpty()){
            p=d.poll();
            System.out.println("Proc: "+p.pId+", w remaining: "+p.getServiceTime());
            x.add(p);
        }
        waitingQ=x;
    }
}
