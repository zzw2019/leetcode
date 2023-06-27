package utils;

import java.util.Map;

import data.ArrayData;
import entity.BinaryTree;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author zengzw
 * @version 1.0
 * @description BinaryTreeUtils
 * @since 2023/6/20 15:41
 *
 * 二叉树工具类
 */

public class BinaryTreeUtils {

    /**
     * 根据数组生成完全二叉树
     * */
    public static BinaryTree generateTree(int [] arr){
        Map<Integer,BinaryTree> positionNodeMap=new HashMap<>();
        //根据数组生成所有的节点
        for(int i=0;i<arr.length;i++){
            BinaryTree binaryTree= BinaryTree.builder().value(arr[i]).build();
            positionNodeMap.put(i,binaryTree);
        }
        //开始填充孩子
        for(int i=0;i<arr.length;i++){
            BinaryTree parentNode = positionNodeMap.get(i);
            //获取到左孩子和右孩子
            BinaryTree leftSon = positionNodeMap.get(2*i+1);
            BinaryTree rightSon = positionNodeMap.get(2*i+2);
            if(leftSon!=null){
                parentNode.setLeftSon(leftSon);
            }
            if(rightSon!=null){
                parentNode.setRightSon(rightSon);
            }
        }
        return positionNodeMap.get(0);
    }

    /**
     * 使用递归的方式打印前序、中序、后序节点
     * */
    @Test
    public void testGenerateTree(){
        BinaryTree binaryTree = generateTree(ArrayData.ARR);
        System.out.println("==========前序打印====================");
        qianxuPrint(binaryTree);
        System.out.println();
        System.out.println("==========中序打印====================");
        zhongxuPrint(binaryTree);
        System.out.println();
        System.out.println("==========后序打印====================");
        houxuPrint(binaryTree);
    }

    /**
     * 前序打印
     * 所谓的前序是 第一个输出根节点(根左右)
     * */
    public static void qianxuPrint(BinaryTree binaryTree){
        if(binaryTree==null){
            return;
        }
        System.out.print(binaryTree.getValue()+",");
        //打印左节点
        qianxuPrint(binaryTree.getLeftSon());
        //打印右节点
        qianxuPrint(binaryTree.getRightSon());
    }

    /**
     * 中序打印
     * 所谓的中序是 第二个输出根节点(左根右)
     * */
    public static void zhongxuPrint(BinaryTree binaryTree){
        if(binaryTree==null){
            return;
        }
        //只要有左孩子存在，就到下一层
        if(binaryTree.getLeftSon()!=null){
            zhongxuPrint(binaryTree.getLeftSon());
        }
        //打印当前节点的value
        System.out.print(binaryTree.getValue()+",");
        //打印右节点
        zhongxuPrint(binaryTree.getRightSon());
    }

    /**
     * 后序打印
     * 所谓的后序是 第三个输出根节点(左右根)
     * */
    public static void houxuPrint(BinaryTree binaryTree){
        if(binaryTree==null){
            return;
        }
        //只要有左孩子存在，就到下一层
        if(binaryTree.getLeftSon()!=null){
            houxuPrint(binaryTree.getLeftSon());
        }
        //打印右节点
        houxuPrint(binaryTree.getRightSon());
        System.out.print(binaryTree.getValue()+",");
    }

    /**
     * 非递归方式打印前序节点
     *
     * */
    public static void qianxuPirnt02(){

    }
}
