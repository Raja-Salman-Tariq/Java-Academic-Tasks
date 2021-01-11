package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
	private String name;
	private String regNo;
	private String ans1;
	private String ans2;
	private String ans3;
	private String ans4;
	private String ans5;
	private String ans6;
	private String ans7;
	private String ans8;
	private String ans9;
	private String ans10;

	private String answers[];
	private String grade;
	private int marks;

	public String toString() {
		String myAns= Arrays.toString(answers);//answers.toString();
		return "<<===========STUDENT INFO===========>>\nStudent Name: "+name+"\nReg. No.: "+regNo+"\nAnswers: "+myAns+"\nMarks: "+marks+"\nGrade: "+grade+"\n<----------------------->";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getAns1() {
		setAns1(answers[0]);
		return ans1;
	}

	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}

	public String getAns2() {
		return ans2;
	}

	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}

	public String getAns3() {
		return ans3;
	}

	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}

	public String getAns4() {
		return ans4;
	}

	public void setAns4(String ans4) {
		this.ans4 = ans4;
	}

	public String getAns5() {
		return ans5;
	}

	public void setAns5(String ans5) {
		this.ans5 = ans5;
	}

	public String getAns6() {
		return ans6;
	}

	public void setAns6(String ans6) {
		this.ans6 = ans6;
	}

	public String getAns7() {
		return ans7;
	}

	public void setAns7(String ans7) {
		this.ans7 = ans7;
	}

	public String getAns8() {
		return ans8;
	}

	public void setAns8(String ans8) {
		this.ans8 = ans8;
	}

	public String getAns9() {
		return ans9;
	}

	public void setAns9(String ans9) {
		this.ans9 = ans9;
	}

	public String getAns10() {
		return ans10;
	}

	public void setAns10(String ans10) {
		this.ans10 = ans10;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}



	public Student(String name, String registration, ArrayList<String> ans){
		this.name=name;
		this.regNo=registration;

		ans1=ans.get(0);
		ans2=ans.get(1);
		ans3=ans.get(2);
		ans4=ans.get(3);
		ans5=ans.get(4);
		ans6=ans.get(5);
		ans7=ans.get(6);
		ans8=ans.get(7);
		ans9=ans.get(8);
		ans10=ans.get(9);

//		answers= (String[]) ans.toArray();

		int i=0;
		answers=new String[10];
//		System.out.println(ans);
		for (String answer:ans
			 ) {
			answers[i]=answer;
			i++;
		}
	}

}
