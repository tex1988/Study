package com.home;

public class MatrixTask {


    public static int getRectangleCount(byte[][] a) {
        int count=0;
        for (int i=0; i<a.length; i++) {
            for (int k=0; k<a.length; k++) {
                if (a[i][k]==1) {
                    if (i==0 && k==0) {
                        count++;
                    }
                    else if (i==0 && k>0) {
                        if (a[i][k-1]==0) {
                            count++;
                        }
                    }
                    else if (i>0 && k==0) {
                        if (a[i-1][k]==0) {
                            count++;
                        }
                    }
                    else if (i>0 && k>0) {
                        if (a[i-1][k]==0 && a[i][k-1]==0 && a[i-1][k-1]==0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        System.out.println(getRectangleCount(a));
    }
}
