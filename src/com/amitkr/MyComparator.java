package com.amitkr;

import java.util.Comparator;

public class MyComparator implements Comparator<Student> {
    int temp;
    @Override
    public int compare(Student o1, Student o2) {
        if (checkCgpa(o1, o2) == 0 && checkName(o1, o2)) {  //when both name and cgpa are equal
            temp = checkToken(o1, o2);
            if (temp == -1) {
                return -1;
            } else if (temp == 1) {
                return 1;
            }
        } else if (checkCgpa(o1, o2) == 0) {
            String a = o1.getName();
            String b = o2.getName();

            temp = a.compareTo(b);

            if (temp < 0) {
                //a is smaller
                return -1;
            }
            else if (temp > 0) {
                //a is larger
                return 1;
            }
        } else {
            temp = checkCgpa(o1, o2);
            if (temp == -1) {
                return -1;
            } else if (temp == 1) {
                return 1;
            }
        }
        return 0;
    }

    /*
        if same cgpa and name, server according to token
        else if same cgpa, serve according to name
        else server according to cgpa
     */

    //a helper method to check if both students have same name
    public boolean checkName(Student a, Student b) {
        return a.getName().equals(b.getName());
    }

    /*
        A helper method to check if both students have same CGPA
        Parameters:
            Student a, b
        Returns:
            1, if a has higher CGPA
            -1, if b has higher CGPA
            0, if both are equal
     */
    public int checkCgpa(Student a, Student b) {
        if (a.getCGPA() > b.getCGPA()) {
            return -1;
        } else if (b.getCGPA() > a.getCGPA()) {
            return 1;
        } else {
            return 0;
        }
    }

    //helper method to compare token numbers
    public int checkToken(Student a, Student b) {
        // The student with a smaller value of token should be served first
        if (a.getToken() < b.getToken()) {
            return -1;
        } else if (b.getToken() < a.getToken()) {
            return 1;
        }
        return 0;
    }

    // helper method to check lexicographical ordering of the names
    public int checkStringLexico (Student x, Student y) {
        String a = x.getName();
        String b = y.getName();

        int compare = a.compareTo(b);

        if (compare < 0) {
            //a is smaller
            return -1;
        }
        else if (compare > 0) {
            //a is larger
            return 1;
        }

        return 0;
    }
}
