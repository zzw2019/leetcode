package utils;

import entity.SingleNode;

/**
 * @ClassName SingleLinkUtils
 * @Author Zengzhw
 * @Date 2023/6/13 21:20
 * @Description SingleLinkUtils
 * @Version 1.0
 */
public class SingleLinkUtils {

    public static SingleNode generateSingleNodeByArray(int [] arr){
        SingleNode theNext=null;
        //先将arr倒序生成
        for(int i=arr.length-1;i>=0;i--){
            SingleNode one=SingleNode.builder().value(arr[i]).build();
            one.setNext(theNext);
            theNext=one;
        }
        SingleNode head = SingleNode.builder().value(null).next(theNext).build();
        return head;
    }

    public static void printSingleNode(SingleNode head){
        while (head.getNext()!=null){
            if(head.getValue()!=null){
                System.out.print(head.getValue()+",");
            }
            head=head.getNext();
        }
        System.out.print(head.getValue());
    }
}
