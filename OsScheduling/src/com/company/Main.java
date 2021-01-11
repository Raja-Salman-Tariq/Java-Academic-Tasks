package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (args.length<2) {
            System.out.println("Nine !");
            return;
        }


//        else {
//            for (String s : args) {
//                System.out.println(s);
//            }
//        }
        String path=args[0];
        int quantum=Integer.parseInt(args[1]);


        File f= new File(path);
        String line;
        Comparator<Process> comp=new MyComparator();
        PriorityQueue<Process> procList= new PriorityQueue<>(1, comp);
        try {
            Scanner s=new Scanner(f);
            while (s.hasNextLine()){
                line=s.nextLine();
                Process p=new Process(line);
                procList.add(p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error ! File not found !");
            return;
        }

//        while (!procList.isEmpty()){
//            procList.poll().print();
//        }

        Scheduler s=new Scheduler(procList, quantum);
        s.execute();
        s.cpu.perf.displayPerf(s.clock.getTime(), quantum);
//        System.out.println(quantum);
    }
}
