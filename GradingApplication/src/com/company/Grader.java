package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class Grader implements FileOperations, ResultCalculation {
    File file, file1, f;
    FileWriter fr;
    String dirPath = "src/com/company/";
    String[] ansKey;
    ArrayList<Student> students;
    ArrayList<String> resultData;
    ArrayList<String> keyData;
    int sz;

    public void displayKey(){
        System.out.println("<<======== KEY FILE =========>>");

        for (String r:keyData
        ) {
            System.out.println(r);
        }
        System.out.println("<--------------------->");
    }

    public void displayResult(){
        System.out.println("<<======== RESULT FILE =========>>");

        for (String r:resultData
             ) {
            System.out.println(r);
        }
        System.out.println("<--------------------->");
    }

    public Grader() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void gradeCalculation() {
        // TODO Auto-generated method stub
        int scr;
        for (Student s : students
        ) {
            scr = 0;
            for (int i = 0; i < sz; i++) {
                if (s.getAnswers()[i].equals(ansKey[i]))
                    scr += 10;
            }

            s.setMarks(scr);

            try {
                if (scr >= 90)
                    s.setGrade("A+");
                else if (scr >= 80)
                    s.setGrade("A");
                else if (scr >= 70)
                    s.setGrade("B");
                else if (scr >= 60)
                    s.setGrade("C");
                else if (scr >= 50)
                    s.setGrade("D");
                else {
                    s.setGrade("F");
                    throw new FailException(s.getName() + " (" + s.getRegNo() + ") has less than 50 marks; Fail exception invoked!");
                }
            } catch (FailException f) {
                System.out.println(f.getMessage());
            }
        }


//        for (Student s : students
//        ) {
//            System.out.println(s.toString());
//        }
    }


    public void gradeCalculation(boolean verbose) {
        // TODO Auto-generated method stub
        int scr;
        for (Student s : students
        ) {
            scr = 0;
            for (int i = 0; i < sz; i++) {
                if (s.getAnswers()[i].equals(ansKey[i]))
                    scr += 10;
            }

            s.setMarks(scr);

            try {
                if (scr >= 90)
                    s.setGrade("A+");
                else if (scr >= 80)
                    s.setGrade("A");
                else if (scr >= 70)
                    s.setGrade("B");
                else if (scr >= 60)
                    s.setGrade("C");
                else if (scr >= 50)
                    s.setGrade("D");
                else {
                    s.setGrade("F");
                    throw new FailException(s.getName() + " (" + s.getRegNo() + ") has less than 50 marks; Fail exception invoked!");
                }
            } catch (FailException f) {
                System.out.println(f.getMessage());
            }
        }


        for (Student s : students
        ) {
            System.out.println(s.toString());
        }
    }

    @Override
    public void OpenFile() {
        // TODO Auto-generated method stub
        file = new File(dirPath + "key.txt");
        try {
            Scanner input1 = new Scanner(file);
//			System.out.println("Success opening key");

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error opening key");
        }
        file1 = new File(
                dirPath + "result.txt");
        try {
            Scanner input2 = new Scanner(file1);
//			System.out.println("Success opening result");

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error opening result");

        }
    }

    @Override
    public void readResultFile() {
        // TODO Auto-generated method stub
        Scanner s = null;
        try {
            s = new Scanner(file1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Scanner loading result failed");
        }

        students = new ArrayList<>();

        String n, reg, holder;
        ArrayList<String> ans = new ArrayList<>();
        resultData=new ArrayList<>();

        StringTokenizer tokenizer;

        String data;
        while (s.hasNextLine()) {
            data=s.nextLine();
            resultData.add(data);

            tokenizer = new StringTokenizer(data);
            n = tokenizer.nextToken();
            reg = tokenizer.nextToken();

            holder = tokenizer.nextToken();
            while (!holder.equals("")) {
//				if (holder.equals('\n') | holder.equals("\r\n") | holder.equals('\r'))
//					System.out.println("Horror***********");
//				else
                ans.add(holder);
                if (tokenizer.hasMoreTokens())
                    holder = tokenizer.nextToken();
                else
                    break;
            }

            students.add(new Student(n, reg, ans));
            ans.clear();
        }

//		for (Student std: stds
//			 ) {
//
//			System.out.println(std.toString());
//
//		}


//		File file1 = new File(
//				dirPath+"result.txt");
//		Student student[] = new Student[2];
//		student[0] = new Student();
//		student[1] = new Student();
//
//		try {
//			Scanner input2 = new Scanner(file1);
//			int count = 0;
//			while (input2.hasNextLine()) {
//				String word = input2.nextLine();
//				String[] words = word.split("[ ']");
//				for (int i = 0; i < words.length; i++) {
//					student[count].setName(words[i]);
//				}
//				count += 1;
//
//			}
//
//			System.out.println("count" + count);
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }

    @Override
    public void readKeyFile() {
        // TODO Auto-generated method stub
        Scanner s = null;
        try {
            s = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Scanner loading key failed");
        }

        keyData=new ArrayList<>();

        sz = (s.nextInt());
        keyData.add(String.format("%d", sz));
        ansKey = new String[sz];
        int i = 0;
        while (s.hasNextLine()) {
            ansKey[i] = s.next();
            keyData.add(ansKey[i++]);
        }

//		System.out.println("ok sooooooo************"+ Arrays.toString(ansKey));

//		String holder;
//		ArrayList<String> ans=new ArrayList<>();
//
//		StringTokenizer tokenizer;
//
//		while (s.hasNextLine()){
//			tokenizer=new StringTokenizer(s.nextLine());
//			n=tokenizer.nextToken();
//			reg=tokenizer.nextToken();
//
//			holder=tokenizer.nextToken();
//			while (!holder.equals("")){
////				if (holder.equals('\n') | holder.equals("\r\n") | holder.equals('\r'))
////					System.out.println("Horror***********");
////				else
//				ans.add(holder);
//				if (tokenizer.hasMoreTokens())
//					holder=tokenizer.nextToken();
//				else
//					break;
//			}
//
//			stds.add(new Student(n, reg, ans));
//			ans.clear();
//		}

    }

    @Override
    public void writeResultFile() {
        // TODO Auto-generated method stub

        f=new File(dirPath+"output.txt");
        f.setWritable(true);

        fr=null;
        try {
            fr = new FileWriter(f);
        } catch (Exception e){
            System.out.println("Error in file writing");
        }

//        System.out.println("***********hehre**************");

        for (Student s:students
             ) {
            try {
                fr.write(s.getName()+" "+s.getRegNo()+" "+s.getMarks()+" "+s.getGrade()+"\n");
//                System.out.println("Worte: "+s.getName()+" "+s.getRegNo()+" "+s.getMarks()+" "+s.getGrade()+"\n");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Output entry not made for "+s.getRegNo());
            }
        }

        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occured while trying to write to the file while closing file writer");
        }
    }

    @Override
    public void closeFile() {
        // TODO Auto-generated method stub
        if (fr!=null) {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fr=null;
        }


    }

    public static void main(String[] args) {
        Grader d = new Grader();
        d.readResultFile();
    }

    public void displayStudent() {
        for (Student s : students
        ) {
            System.out.println(s.toString());
        }
    }
}
