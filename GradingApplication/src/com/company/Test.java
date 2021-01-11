package com.company;

public class Test {

	public static void main(String[] args) {
		// write your code here


		Grader result=new Grader();
		result.OpenFile();
		result.readResultFile();
		result.readKeyFile();
		result.gradeCalculation();
		result.displayStudent();
		result.writeResultFile();
		result.closeFile();
//		Grader g=new Grader();
//		g.OpenFile();
//
////        ArrayList<Student> s;
//
//		g.readResultFile();
//		g.readKeyFile();
//
//		g.gradeCalculation();
//
//		g.writeResultFile();
//
////        g.displayResult();
//
//		g.displayKey();
	}

	public Test() {
		// TODO Auto-generated constructor stub
	}

}
