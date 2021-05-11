package com.hdc.lsy.singleLinkedList;

import com.sun.xml.internal.ws.api.pipe.NextAction;

public class SingLinkedListDome {

    public static void main(String[] args) {
        HreoNode hreo1 = new HreoNode(1, "宋江", "及时雨");
        HreoNode hreo2 = new HreoNode(2, "卢俊义", "玉麒麟");
        HreoNode hreo3 = new HreoNode(3, "吴用", "智多星");
        HreoNode hreo4 = new HreoNode(4, "公孙", "111");
        singLinkedList linkedList = new singLinkedList();
        linkedList.addnode(hreo1);
        linkedList.addnode(hreo4);
        linkedList.addnode(hreo2);
        linkedList.addnode(hreo3);
        linkedList.list();
        System.out.println(sumlist(linkedList.getHead()));
        System.out.println(getindex(linkedList.getHead(),2));
        reserve(linkedList.getHead());
        System.out.println("反转后链表");
        linkedList.list();
//        System.out.println(linkedList.getHead());
    }
//    链表反转

    public static void reserve(HreoNode head){
//        判断链表是否为空或者是否只有一个元素
        if (head.next == null||head.next.next==null){
            return;
        }
        HreoNode next = null;
        HreoNode reservenode = new HreoNode(0,"","");
        HreoNode cur = head.next;

        while (cur!= null){
            next = cur.next;
            cur.next = reservenode.next;
            reservenode.next = cur;
            cur = next;
        }
        head.next = reservenode.next;
    }
    //    获取链表的倒数第index个值
    public static HreoNode getindex(HreoNode head,int index){
        if (head.next == null ){
            System.out.println("链表为空");
            return null;
        }
        int sumlist = sumlist(head);
        if (index>sumlist||index<=0){
            System.out.println("index");
            return null;
        }
        HreoNode cur = head.next;
        for (int i = 0; i < sumlist-index; i++) {
            cur = cur.next;
        }
        return cur;
    }
    //    查看当前列表中的有效个数
    public static int sumlist(HreoNode hreoNode) {
        if (hreoNode.next == null) {
            return 0;
        }
        int length = 0;
        HreoNode cur = hreoNode.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
}

class singLinkedList {
    public HreoNode getHead() {
        return head;
    }

    HreoNode head = new HreoNode(0, "", "");

    public void knode(int k) {
        int le = 0;
        HreoNode hreok = head.next;
        if (head.next == null) {
            System.out.printf("链表为空长度达不到%d", k);
            return;
        }
        HreoNode hreoNode = head.next;
        while (true) {
            if (hreoNode.next != null) {
                le++;
                if (le == k) {
                    hreok = hreok.next;
                }
                hreoNode = hreoNode.next;
            }
        }
    }

    public void addnode(HreoNode hreoNode1) {
        HreoNode temp = head;
        boolean flag = false;
        while (true) {
//                如果链表中没数据
            if (temp.next == null) {
                break;
            }
//                如果想要插入的数据编号比下一个指向的编号小，代表应该在当前数据后面插入
            if (temp.next.no > hreoNode1.no) {
                break;
            } else if (temp.next.no == hreoNode1.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("当前编号%d已经被占用~~~\n", hreoNode1.no);
            return;
        } else {
            hreoNode1.next = temp.next;
            temp.next = hreoNode1;
        }
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HreoNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HreoNode {
    public int no;
    public String name;
    public String nickname;
    public HreoNode next;

    public HreoNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public HreoNode() {
    }

    @Override
    public String toString() {
        return "HreoNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname +
                '}';
    }
}
