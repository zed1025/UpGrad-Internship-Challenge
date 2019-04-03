package com.amitkr;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n;  //number of commands
        Student s = null;

        n = sc.nextInt();
        sc.nextLine();      //to consume any whitespace after int

        PriorityQueue<Student> pq = new PriorityQueue<Student>(n, new MyComparator());

        String name = null;
        double CGPA = 0;
        int token = 0;
        String command = null;
        while(n > 0) {
            n--;
            String lines = br.readLine();

            String[] strs = lines.trim().split("\\s+");

            for (int i = 0; i < 4; i++) {
                //a[i] = Integer.parseInt(strs[i]);
                if (strs.length == 1 ) {
                    command = strs[0];
                    break;
                } else {
                    command = strs[0];
                    name = strs[1];
                    CGPA = Double.parseDouble(strs[2]);
                    token = Integer.parseInt(strs[3]);
                }
            }
            s = new Student(name, CGPA, token);
            if (command.equals("ENTER")) {
                pq.add(s);
            } else {
                pq.poll();
            }
        }

        if (pq.peek() == null) {
            System.out.println("EMPTY");
        } else {
            while (!pq.isEmpty()) {
                System.out.println(pq.poll().getName());
            }
        }
//        System.out.println(command);
//        System.out.println(s.getName() + s.getToken() + s.getCGPA());
    }
}
