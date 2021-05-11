package com.hdc.lsy.cirleQueue;

import java.util.Scanner;

public class CircleQueue {
    public static void main(String[] args) {
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        circle circle = new circle(5);
        boolean i = true;
        while (i) {
            System.out.println("s:显示");
            System.out.println("e:退出");
            System.out.println("a:添加");
            System.out.println("g:取出");
            System.out.println("h:显示头");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    try {
                        circle.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    System.out.println("退出程序");
                    scanner.close();
                    i = false;
                    break;
                case 'a':
                    try {
                        int l = scanner.nextInt();
                        circle.addint(l);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int getint = circle.getint();
                        System.out.println(getint);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        circle.hasint();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    circle.showQueue();
                    break;
            }
        }
//        System.out.println(arr.length);
    }

    static class circle {
        private int rear;
        private int front;
        private int[] queue;
        private int maxsize;


        public circle(int maxsizeQueue) {
            maxsize = maxsizeQueue;
            queue = new int[maxsize];
        }

        public boolean isFull() {
            return (rear + 1) % maxsize == front;
        }

        public boolean isNull() {
            return rear == front;
        }

        public void addint(int shu) {
            if (isFull()) {
                throw new RuntimeException("队列满不能添加");
            }
            queue[rear] = shu;
            rear = (rear + 1) % maxsize;
        }

        public int getint() {
            if (isNull()) {
                throw new RuntimeException("队列空不能取出数据！");
            }
            int value = queue[front];
            front = (front + 1) % maxsize;
            return value;
        }

        //        遍历数组数据
        public void showQueue() {
            if (isNull()) {
                throw new RuntimeException("队列空不能取出数据！");
            }
            for (int i = front; i < front + size(); i++) {
                System.out.printf("queue[%d] = %d\n", i % maxsize, queue[i % maxsize]);
            }
        }
        public int size() {
            return (rear + maxsize - front) % maxsize;
        }

        public int hasint() {
            if (isNull()) {
                throw new RuntimeException("队列空不能取出数据！");
            }
            return queue[front + 1];
        }
    }
}
