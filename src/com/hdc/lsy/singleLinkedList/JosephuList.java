package com.hdc.lsy.singleLinkedList;

public class JosephuList {
    public static void main(String[] args) {
        JoseHreoNodeList list = new JoseHreoNodeList();
        list.addnode(5);
        list.list();
    }
}

class JoseHreoNodeList {
    public HreoNodeJ gethead() {
        return this.head;
    }

    HreoNodeJ head = null;
    HreoNodeJ first = null;

    public void addnode(int nums) {
        if (nums < 2) {
            System.out.println("nums值错误");
        }
        HreoNodeJ curboy = null;
        for (int i = 1; i <= nums; i++) {
            HreoNodeJ boy = new HreoNodeJ(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curboy = first;
            } else {
                curboy.setNext(boy);
                boy.setNext(first);
                curboy = boy;
            }
        }
    }
    public void list(){
        HreoNodeJ cur = first;
        while (true){
            System.out.println("编号为"+cur.no);
            if (cur.getNext() == first){
                break;
            }
            cur = cur.getNext();
        }
    }
}

class HreoNodeJ {
    public int no;
    public HreoNodeJ next;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public HreoNodeJ getNext() {
        return next;
    }

    public void setNext(HreoNodeJ next) {
        this.next = next;
    }

    public HreoNodeJ(int no) {
        this.no = no;
    }

    public HreoNodeJ() {
    }

    @Override
    public String toString() {
        return "HreoNode no=" + no;
    }
}
