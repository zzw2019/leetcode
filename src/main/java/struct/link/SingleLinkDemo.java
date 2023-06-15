package struct.link;

import data.ArrayData;
import entity.SingleNode;
import org.junit.Test;
import utils.SingleLinkUtils;

import java.util.Stack;

/**
 * @ClassName SingleLinkDemo
 * @Author Zengzhw
 * @Date 2023/6/13 21:26
 * @Description SingleLinkDemo
 * @Version 1.0
 */
public class SingleLinkDemo {

    private static SingleNode data;

    static {
        data= SingleLinkUtils.generateSingleNodeByArray(ArrayData.ARR);
    }


    /**
     * 反转单链表
     * */
    @Test
    public void reverseSingleLink(){
        SingleLinkUtils.printSingleNode(data);
        System.out.println();
        System.out.println("==========反转之后==============");
        //这里使用两种方法来实现单链表的反转
//        SingleNode head=reverse_02(data);
        SingleNode head=reverse_03(data);
        SingleLinkUtils.printSingleNode(head);
    }

    /**
     * 第一种方式实现反转  30分钟未做出来
     * */
    public SingleNode reverse_01(SingleNode head){
        //申请临时变量a和b
        SingleNode a,b;
        a=null;
        b=head.getNext();
        while (b!=null){
            head.setNext(a);
            a=head;
            head=b;
            b=head.getNext();
        }
        SingleNode newHead = SingleNode.builder().value(null).next(head).build();
        return newHead;
    }

    /**
     * 第二种方式：使用栈来辅助， 可以实现
     * */
    public SingleNode reverse_02(SingleNode head) {
        Stack<SingleNode> stack=new Stack();
        head=head.getNext();
        while (head!=null){
            stack.push(head);
            head=head.getNext();
        }
        SingleNode newHead = SingleNode.builder().value(null).next(head).build();
        SingleNode temp=newHead;
        while (stack.size()!=0){
            SingleNode pop = stack.pop();
            temp.setNext(pop);
            temp=pop;
        }
        temp.setNext(null);
        return newHead;
    }


    /**
     * 第三种方式：使用递归函数
     * */
    public SingleNode reverse_03(SingleNode originPreNode){
        if(originPreNode.getNext()==null){
            return originPreNode;
        }
        SingleNode originAfterNode=reverse_03(originPreNode.getNext());
        originPreNode.getNext().setNext(originPreNode);
        originPreNode.setNext(null);
        return originAfterNode;
//        if(originPreNode.getNext()==null){
//            return originPreNode;
//        }
//        SingleNode originAfterNode=reverse_03(originPreNode.getNext());
//        originAfterNode.setNext(originPreNode);
//        return originPreNode;
    }

    /**
     * 打印两个有序链表的公共部分
     * 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分[要求] 如果两个链表的长度之和为N，时间复杂度要求为0(N)，额外空间复
     * 杂度要求为0(1)
     *
     * 取两个链表a,b
     * 如果a<b a=a.next
     * 如果a>b b=b.next
     * 如果a=b 打印并a=a.next，b=b.next
     * */
    @Test
    public void printSame(){
        int [] arr1={10,20,60,23,45,75};
        int [] arr2={10,60,75};
        SingleNode data2= SingleLinkUtils.generateSingleNodeByArray(arr1);
        SingleNode data3= SingleLinkUtils.generateSingleNodeByArray(arr2);
        data2=data2.getNext();
        data3=data3.getNext();
        while (data2!=null || data3!=null){
            if(data2.getValue()<data3.getValue()){
                data2=data2.getNext();
            }else if(data3.getValue()<data2.getValue()){
                data3=data3.getNext();
            }else if(data2.getValue()==data3.getValue()){
                System.out.print(data2.getValue()+",");
                data2=data2.getNext();
                data3=data3.getNext();
            }
        }
    }

    /**
     * 题目4：判断一个链表是否为回文结构
     * [题目]给定一个单链表的头节点head，请判断该链表是否为回文结构。[例子]1->2->1，返回true; 1->2->2->1，返回true; 15->6->15，返回true;1->2->3，返回false。
     * [例子]如果链表长度为N，时间复杂度达到0(N)，额外空间复杂度达到0(1)。
     * */
    public void isHuiwen(){

    }


    /**
     * 题目5
     * 将单向链表按某值划分成左边小、中间相等、右边大的形式
     * [题目]给定一个单链表的头节点head，节点的值类型是整型，再给定一个整数pivot。实现一个调整链表的函数，将链表调整为左部分都是值小于pivot的节点，中间部分都是值等于pivot的节点，右部分都是值大于pivot的节点。
     * [进阶]在实现原问题功能的基础上增加如下的要求
     * [要求]调整后所有小于pivot的节点之间的相对顺序和调整前一样[要求]调整后所有等于pivot的节点之间的相对顺序和调整前[要求]调整后所有大于pivot的节点之间的相对顺序和调整前[要求]时间复杂度请达到0(N)，额外空间复杂度请达到0(1)。
     * */



    /**
     * 题目6：复制含有随机指针节点的链表
     * [题目]一种特殊的单链表节点类描述如下class Node
     * int value;
     * Node next;
     * Node rand;
     * Node(int val) [
     * value = val;
     * rand指针是单链表节点结构中新增的指针，rand可能指向链表中的任意一个节点，也可能指向null。给定一个由Node节点类型组成的无环单链表的头节点head，请实现一个函数完成这个链表的复制，并返回复制的新链表的头节点
     * [要求]时间复杂度0(N)，额外空间复杂度0(1)
     * */
}
