package com.hdc.lsy;

import java.util.HashMap;

//稀疏数组
public class SparseArray {
    public static void main(String[] args) {
        int[][] sparse = new int[11][11];
        sparse[1][2] = 1;
        sparse[2][3] = 2;
        System.out.println("原始数组");
        for (int[] row : sparse) {
            for (int row1 : row) {
                System.out.printf("%d\t", row1);
            }
            System.out.printf("\n");
        }

        //稀疏数组
        int sum = 0;
        for (int[] row : sparse) {
            for (int row1 : row) {
                if (row1 != 0) {
                    sum++;
                }
            }
        }
        System.out.println(sum);
        System.out.println(sparse[0].length);
        int[][] xishu = new int[sum + 1][3];
        xishu[0][0] = sparse.length;
        xishu[0][1] = sparse[0].length;
        xishu[0][2] = sum;

        int count = 0;
        for (int i = 0; i < sparse.length; i++) {
            for (int j = 0; j < sparse[0].length; j++) {
                if (sparse[i][j] != 0) {
                    count++;
                    xishu[count][0] = i;
                    xishu[count][1] = j;
                    xishu[count][2] = sparse[i][j];
                }
            }
        }

//        稀疏数组
        System.out.println("稀疏数组");
        for (int[] row : xishu) {
            for (int row1 : row) {
                System.out.printf("%d\t", row1);
            }
            final HashMap<Object, Object> hashMap = new HashMap<>();
            final int i = hashMap.hashCode();
            System.out.printf("\n");
        }
    }

}
