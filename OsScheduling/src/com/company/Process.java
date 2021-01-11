package com.company;

import java.util.Comparator;
import java.util.StringTokenizer;

class MyComparator implements Comparator<Process> {

    public int compare(Process a, Process b) {
        return (a.getArrivalTime()-b.getArrivalTime());
    }
}

public class Process {
    String pId;
    int arrivalTime, serviceTime,
        offTime,
        switchCount, wait;

    public  Process(String line){
        StringTokenizer toks=new StringTokenizer(line, ",");

        this.pId=toks.nextToken();
        this.arrivalTime= Integer.parseInt(toks.nextToken());
        this.serviceTime=Integer.parseInt(toks.nextToken());
        this.switchCount=0;

        offTime=wait=0;
//        while (toks.hasMoreTokens()){
//            System.out.println("found:"+(toks.nextToken().toString()));
//        }

    }

    public Process(String pId, int arrivalTime, int serviceTime, int switchCount) {
        this.pId = pId;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.switchCount = 0;
    }

    void handleOnOffTimes(int on, int off){

        if (offTime==0){
            wait+=(on-arrivalTime);
            offTime=off;
            return;
        }

        wait+=(on-offTime);
        offTime=off;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getSwitchCount() {
        return switchCount;
    }

    public void setSwitchCount(int switchCount) {
        this.switchCount = switchCount;
    }

    public void print(){
        System.out.println("==========================================");
        System.out.println("Process \t\t\t\t\t\t"+pId);
        System.out.println("Arrival: \t\t\t\t\t\t"+Integer.toString(arrivalTime));
        if (serviceTime<0)
            System.out.println("Remaining Burst Time: \t\t\t"+ Integer.toString(0));
        else
            System.out.println("Remaining Burst Time: \t\t\t"+ Integer.toString(serviceTime));
        System.out.println("Switch Count:\t\t\t\t\t"+ Integer.toString(switchCount));
        System.out.println("Total Waiting Duration: \t\t"+wait);
    }
}
