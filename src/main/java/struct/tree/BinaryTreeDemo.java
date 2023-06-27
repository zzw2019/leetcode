package struct.tree;

import entity.BinaryTree;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.Map;

/**
 * @author zengzw
 * @version 1.0
 * @description BinaryTreeDemo
 * @since 2023/6/21 10:20
 */

public class BinaryTreeDemo {

    private BinaryTree generateGetTreeWight(){
        BinaryTree eight=BinaryTree.builder().value(8).leftSon(null).rightSon(null).build();
        BinaryTree seven=BinaryTree.builder().value(7).leftSon(null).rightSon(null).build();
        BinaryTree six=BinaryTree.builder().value(6).leftSon(null).rightSon(eight).build();
        BinaryTree five=BinaryTree.builder().value(5).leftSon(seven).rightSon(null).build();
        BinaryTree four=BinaryTree.builder().value(4).leftSon(null).rightSon(null).build();
        BinaryTree three=BinaryTree.builder().value(3).leftSon(six).rightSon(null).build();
        BinaryTree two=BinaryTree.builder().value(2).leftSon(four).rightSon(five).build();
        BinaryTree one=BinaryTree.builder().value(1).leftSon(two).rightSon(three).build();
        return one;
    }

    /**
     * 创建搜索二叉树
     *                    8
     *            3                10
     *      1        6       null      14
     *            4     7           13  null
     * */
    private BinaryTree generateSearchBinaryTree(){
        BinaryTree twelve=BinaryTree.builder().value(12).leftSon(null).rightSon(null).build();
        BinaryTree thirteen=BinaryTree.builder().value(13).leftSon(twelve).rightSon(null).build();
        BinaryTree four=BinaryTree.builder().value(4).leftSon(null).rightSon(null).build();
        BinaryTree elven=BinaryTree.builder().value(7).leftSon(null).rightSon(null).build();
        BinaryTree fourteen=BinaryTree.builder().value(14).leftSon(thirteen).rightSon(null).build();
        BinaryTree six=BinaryTree.builder().value(6).leftSon(four).rightSon(elven).build();
        BinaryTree one=BinaryTree.builder().value(1).leftSon(null).rightSon(null).build();
        BinaryTree ten=BinaryTree.builder().value(10).leftSon(null).rightSon(fourteen).build();
        BinaryTree three=BinaryTree.builder().value(3).leftSon(one).rightSon(six).build();
        BinaryTree eight=BinaryTree.builder().value(8).leftSon(three).rightSon(ten).build();
        return eight;
    }

    /**
     * 创建满二叉树
     * */
    private BinaryTree generateFullBinaryTree(){
        BinaryTree seven=BinaryTree.builder().value(7).leftSon(null).rightSon(null).build();
        BinaryTree six=BinaryTree.builder().value(6).leftSon(null).rightSon(null).build();
        BinaryTree five=BinaryTree.builder().value(5).leftSon(null).rightSon(null).build();
        BinaryTree four=BinaryTree.builder().value(4).leftSon(null).rightSon(null).build();
        BinaryTree three=BinaryTree.builder().value(3).leftSon(six).rightSon(seven).build();
        BinaryTree two=BinaryTree.builder().value(2).leftSon(four).rightSon(five).build();
        BinaryTree one=BinaryTree.builder().value(1).leftSon(two).rightSon(three).build();
        return one;
    }

    /**
     * 创建完全二叉树
     * */
    private BinaryTree generateCompleteBinaryTree(){
        BinaryTree six=BinaryTree.builder().value(6).leftSon(null).rightSon(null).build();
        BinaryTree five=BinaryTree.builder().value(5).leftSon(null).rightSon(null).build();
        BinaryTree four=BinaryTree.builder().value(4).leftSon(null).rightSon(null).build();
        BinaryTree three=BinaryTree.builder().value(3).leftSon(six).rightSon(null).build();
        BinaryTree two=BinaryTree.builder().value(2).leftSon(four).rightSon(five).build();
        BinaryTree one=BinaryTree.builder().value(1).leftSon(two).rightSon(three).build();
        return one;
    }

    /**
     * 创建平衡二叉树
     * */
    private BinaryTree generateEBinaryTree(){
        BinaryTree four=BinaryTree.builder().value(4).leftSon(null).rightSon(null).build();
        BinaryTree eight=BinaryTree.builder().value(8).leftSon(null).rightSon(null).build();
        BinaryTree seven=BinaryTree.builder().value(7).leftSon(four).rightSon(null).build();
        BinaryTree fourteen=BinaryTree.builder().value(14).leftSon(null).rightSon(null).build();
        BinaryTree twentyFive=BinaryTree.builder().value(25).leftSon(four).rightSon(null).build();
        BinaryTree fourth=BinaryTree.builder().value(40).leftSon(null).rightSon(eight).build();
        BinaryTree ten=BinaryTree.builder().value(10).leftSon(seven).rightSon(fourteen).build();
        BinaryTree thirty=BinaryTree.builder().value(30).leftSon(twentyFive).rightSon(fourth).build();
        BinaryTree twenty=BinaryTree.builder().value(20).leftSon(ten).rightSon(thirty).build();
        return twenty;
    }


    /**
     * 题目1：如何完成二叉树的宽度优先遍历
     * 举例
     *                  1
     *               2        3
     *            4    5    6  null
     *          nu nu 7 nu nu 8
     * 宽度优先遍历就是一行一行的打印， 1 2 3 4 5 6 7 8
     * */
    @Test
    public void getTreeWight(){
        //获取到根节点
        BinaryTree binaryTree = generateGetTreeWight();
        //要实现一个个的打印，就需要借助队列
        Queue<BinaryTree> queue=new LinkedBlockingDeque<>();
        //先给队列填充一个头结点
        queue.offer(binaryTree);
        while (!queue.isEmpty()){
            BinaryTree poll = queue.poll();
            System.out.println(poll.getValue()+",");
            if(poll.getLeftSon()!=null){
                queue.offer(poll.getLeftSon());
            }
            if(poll.getRightSon()!=null){
                queue.offer(poll.getRightSon());
            }
        }
    }


    /**
     * 题目2：统计树的最大宽度
     * 比如说题目一中的树的最大宽度就是 4 5 6 ，所以是3
     * */
    @Test
    public void analysisMaxWight(){
        //获取到根节点
        BinaryTree binaryTree = generateGetTreeWight();
        //要实现一个个的打印，就需要借助队列
        Queue<BinaryTree> queue=new LinkedBlockingDeque<>();
        //先给队列填充一个头结点
        queue.offer(binaryTree);
        //key=第几层 value=每层有几个
        Map<Integer,Integer> levelCount=new HashMap<>();
        levelCount.put(1,1);
        //还需要一个map来维护当前node是第几层
        Map<BinaryTree,Integer> nodeLevel=new HashMap<>();
        nodeLevel.put(binaryTree,1);
        while (!queue.isEmpty()){
            BinaryTree poll = queue.poll();
            //获取当前节点的层数
            Integer currentLevel = nodeLevel.get(poll);
            if(poll.getLeftSon()!=null){
                queue.offer(poll.getLeftSon());
                //设置子节点和子节点的层数
                nodeLevel.putIfAbsent(poll.getLeftSon(),currentLevel+1);
                levelCount.put(currentLevel+1,(levelCount.getOrDefault(currentLevel+1,0)+1));
            }
            if(poll.getRightSon()!=null){
                queue.offer(poll.getRightSon());
                //设置子节点和子节点的层数
                nodeLevel.putIfAbsent(poll.getRightSon(),currentLevel+1);
                levelCount.put(currentLevel+1,(levelCount.getOrDefault(currentLevel+1,0)+1));
            }
        }
        System.out.println(levelCount.values().stream().max(Integer::compareTo).get());
    }

    /**
     * 二叉树的相关概念及其实现判断
     * 如何判断一颗二叉树是否是搜索二叉树?
     * 如何判断一颗二叉树是完全二叉树?
     * 如何判断一颗二叉树是否是满二叉树?
     * 如何判断一颗二叉树是否是平衡二叉树?(二叉树题目套路)
     */
    @Test
    public void te(){
        System.out.println("================开始判断搜索二叉树==========================");
        BinaryTree searchBinaryTree=generateSearchBinaryTree();
        System.out.println(isSearchBinaryTree(searchBinaryTree));
        System.out.println("================开始判断完全二叉树==========================");
        BinaryTree completeBinaryTree = generateCompleteBinaryTree();
        System.out.println(isCompleteBinaryTree(completeBinaryTree));
        System.out.println("================开始判断满二叉树==========================");
        BinaryTree fullBinaryTree = generateFullBinaryTree();
        System.out.println(isFullBinaryTree(fullBinaryTree));
        System.out.println("================开始判断平衡二叉树==========================");
        BinaryTree eBinaryTree = generateEBinaryTree();
        System.out.println(isEvaBinaryTree(eBinaryTree));
        //非平衡二叉树的判定
        System.out.println(isEvaBinaryTree(searchBinaryTree));
    }

    /**
     * 是否是搜索二叉树（搜索二叉树：左<头<右）
     * */
    public boolean isSearchBinaryTree(BinaryTree binaryTree){
        boolean isSearchBinaryTree=true;
        //要实现一个个的打印，就需要借助队列
        Queue<BinaryTree> queue=new LinkedBlockingDeque<>();
        //先给队列填充一个头结点
        queue.offer(binaryTree);
        while (!queue.isEmpty()){
            BinaryTree poll = queue.poll();
            if(poll.getLeftSon()!=null){
                if(poll.getLeftSon().getValue()>poll.getValue()){
                    isSearchBinaryTree=false;
                    System.out.println("节点==="+poll.getLeftSon().getValue()+"==不符合搜索二叉树的结构");
                    break;
                }
                queue.offer(poll.getLeftSon());
            }
            if(poll.getRightSon()!=null){
                if(poll.getRightSon().getValue()<poll.getValue()){
                    isSearchBinaryTree=false;
                    System.out.println("节点==="+poll.getRightSon().getValue()+"==不符合搜索二叉树的结构");
                    break;
                }
                queue.offer(poll.getRightSon());
            }
        }
        return isSearchBinaryTree;
    }


    /**
     * 是否是完全二叉树
     * 【特征】节点从左至右填充至子节点
     * 【判断方式】
     * 1.如果一个节点既有左节点又有右节点 跳过
     * 2.如果说一个节点只有右节点，直接返回false
     * 3.如果一个节点只有左节点，修改标记，之后的节点都要是没有子节点
     * */
    public boolean isCompleteBinaryTree(BinaryTree binaryTree){
        boolean isCompleteBinaryTree=true;
        //要实现一个个的打印，就需要借助队列
        Queue<BinaryTree> queue=new LinkedBlockingDeque<>();
        //先给队列填充一个头结点
        queue.offer(binaryTree);
        //标记位，代表识别到只有一个左子节点的节点，之后的节点的子节点必须都是null
        boolean afterNodeSonNeedNull=false;
        while (!queue.isEmpty()){
            BinaryTree poll = queue.poll();
            BinaryTree leftSon = poll.getLeftSon();
            BinaryTree rightSon = poll.getRightSon();
            //1如果标记位为true以后，左子节点或者右子节点不为null，就判定为失败
            if(afterNodeSonNeedNull && (leftSon!=null || rightSon!=null)){
                isCompleteBinaryTree=false;
            }
            //2.如果子节点个数不等于2且只有右孩子，跳出
            if(leftSon==null && rightSon!=null){
                isCompleteBinaryTree=false;
                break;
            }else if(leftSon!=null && rightSon==null){
                //3.如果只有左孩子，修改标记位
                afterNodeSonNeedNull=true;
            }
            if(poll.getLeftSon()!=null){
                queue.offer(poll.getLeftSon());
            }
            if(poll.getRightSon()!=null){
                queue.offer(poll.getRightSon());
            }
        }
        return isCompleteBinaryTree;
    }

    /**
     * 是否是满二叉树
     * 【概念】满二叉树就是节点必须要有左右子节点，要么都为空
     * 满二叉树满足 深度l 和节点数N的关系  N=2^l-1
     * 所以就需要知道深度和高度
     * */
    public boolean isFullBinaryTree(BinaryTree binaryTree){
        Node f = f(binaryTree);
        return f.getNodeCount()==(1<<f.getDeep())-1;
    }
    /**
     * 将树的问题分解为左树和右树
     * */
    private Node f(BinaryTree binaryTree){
        if(binaryTree==null){
            return new Node(0,0);
        }
        Node leftSon = f(binaryTree.getLeftSon());
        Node rightSon=f(binaryTree.getRightSon());
        //当前树的深度是 Max(左，右)+1(自己)
        int deep=Math.max(leftSon.getDeep(),rightSon.getDeep())+1;
        //当前树的节点个数是 左+右+1(自己)
        int count=leftSon.getNodeCount()+rightSon.getNodeCount()+1;
        return new Node(count,deep);
    }

    @Data
    class Node{
        /**
         * 节点的数量
         * */
        private Integer nodeCount;
        /**
         * 树的深度
         * */
        private Integer deep;

        public Node(Integer nodeCount, Integer deep) {
            this.nodeCount = nodeCount;
            this.deep = deep;
        }
    }

    /**
     * 是否是平衡二叉树
     * 【概念】左右子树的高度差<=1
     * 【思路】拆分成左右子树，判断左子树高度和右子树的高度
     * */
    public boolean isEvaBinaryTree(BinaryTree binaryTree){
        ENode e = e(binaryTree);
        return e.isE;
    }

    /**
     * 将问题拆分成左右子树，然后判断是否是平衡二叉树
     * */
    private ENode e(BinaryTree binaryTree){
        if(binaryTree==null){
            return new ENode(0,true);
        }
        ENode leftSon = e(binaryTree.getLeftSon());
        ENode rightSon=e(binaryTree.getRightSon());
        //如果左或右树是false,直接返回false
        if(!leftSon.isE || !rightSon.isE){
            return new ENode(0,false);
        }
        //如果|左树深度-右树深度|>1 返回false
        if(Math.abs(leftSon.getDeep()-rightSon.getDeep())>1){
            return new ENode(0,false);
        }
        return new ENode(Math.max(leftSon.getDeep(),rightSon.getDeep())+1,true);
    }

    @Data
    class ENode{
        /**
         * 树的深度
         * */
        private Integer deep;

        private Boolean isE;

        public ENode(Integer deep, Boolean isE) {
            this.deep = deep;
            this.isE = isE;
        }
    }
}
