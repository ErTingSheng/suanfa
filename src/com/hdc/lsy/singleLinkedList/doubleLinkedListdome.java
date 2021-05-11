package com.hdc.lsy.singleLinkedList;

public class doubleLinkedListdome {
    public static void main(String[] args) {
        HreoNode2 hreo1 = new HreoNode2(1, "宋江", "及时雨");
        HreoNode2 hreo2 = new HreoNode2(2, "卢俊义", "玉麒麟");
        HreoNode2 hreo3 = new HreoNode2(3, "吴用", "智多星");
        HreoNode2 hreo4 = new HreoNode2(4, "公孙", "111");
        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.add(hreo1);
        linkedList.add(hreo4);
        linkedList.add(hreo2);
        linkedList.add(hreo3);
        linkedList.list();
        linkedList.del(1);
        System.out.println("***********************");
        linkedList.list();
    }
}

    class DoubleLinkedList {
        public HreoNode2 getHead() {
            return head;
        }

        HreoNode2 head = new HreoNode2(0, "", "");

        public void knode(int k) {
            int le = 0;
            HreoNode2 hreok = head.next;
            if (head.next == null) {
                System.out.printf("链表为空长度达不到%d", k);
                return;
            }
            HreoNode2 hreoNode = head.next;
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
//        删除指定编号节点

        /**
         * 判断链表是否为空
         * 遍历查找节点如果找到flag置位true
         * 删除节点temp.pre.next = temp.next;
         *                 if (temp!= null){
         *                     temp.next.pre = temp.pre;
         *                 }
         * @param no
         */
        public void del(int no) {
            if (head.next == null){
                System.out.println("链表为空");
            }
            HreoNode2 temp = head.next;
            boolean flag = false;
            while (true){
                if (temp == null){
                    break;
                }
                if (temp.no == no){
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (!flag){
                System.out.printf("未找到编号为%d的节点",no);
            }else {
                temp.pre.next = temp.next;
                if (temp.next != null){
                    temp.next.pre = temp.pre;
                }
            }
        }

        public void addnode(HreoNode2 hreoNode1) {
            HreoNode2 temp = head;
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

        public void add(HreoNode2 hreoNode1) {
            HreoNode2 temp = head;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
            temp.next = hreoNode1;
            hreoNode1.pre = temp;
        }

        //遍历
        public void list() {
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }
            HreoNode2 temp = head.next;
            while (true) {
                if (temp == null) {
                    break;
                }
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }

    class HreoNode2 {
        public int no;
        public String name;
        public String nickname;
        public HreoNode2 next;
        public HreoNode2 pre;

        public HreoNode2(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }

        public HreoNode2() {
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
