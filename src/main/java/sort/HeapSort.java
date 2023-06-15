package sort;

import data.ArrayData;
import org.junit.Test;

/**
 * @ClassName HeapSort
 * @Author Zengzhw
 * @Date 2023/6/12 21:01
 * @Description HeapSort
 * @Version 1.0
 *
 * 堆排序
 */
public class HeapSort {

    /**
     * 小根堆测试
     * */
    @Test
    public void smallRootHeap(){
        ArrayData.print(ArrayData.ARR);
        System.out.println();
        System.out.println("=================堆化之后===================");
        for(int i=0;i<ArrayData.ARR.length;i++){
            heapify(ArrayData.ARR,i);
        }
        ArrayData.print(ArrayData.ARR);
        System.out.println();
        System.out.println("==============开始进行堆排序===============");
        for(int i=0;i<ArrayData.ARR.length;i++){
            //取出数组的第一个元素,并和数组的最后一个元素进行交换
            ArrayData.swap(ArrayData.ARR,0,ArrayData.ARR.length-1-i);
            keepHeapify(ArrayData.ARR,0,ArrayData.ARR.length-i);
            ArrayData.print(ArrayData.ARR);
            System.out.println();
            System.out.println("----------------");
        }

    }

    /**
     * 堆化
     * 1.新元素和自己的父类比较，如果说父类的值比该元素小的话就交换位置
     * */
    public void heapify(int [] arr,int currentIndex){
        //如果当前节点是0就不需要找父节点去比较
        if(currentIndex==0){
            return;
        }
        //获取到当前节点的父节点位置 (index-1)/2
        int parentIndex=(currentIndex-1)/2;
        //如果说当前节点小于父节点,就交换两个元素
        if(arr[currentIndex]<arr[parentIndex]){
            ArrayData.swap(arr,currentIndex,parentIndex);
        }
        //继续轮训直到结束比较
        heapify(arr,parentIndex);
    }


    /**
     * 继续保持堆化
     * */
    public void keepHeapify(int [] arr,int currentIndex,int biggestIndex){
        //获取到子元素
        int leftSon=currentIndex*2+1;
        int rightSon=currentIndex*2+2;
        --biggestIndex;
        if(leftSon<biggestIndex && arr[leftSon]<arr[currentIndex]){
            ArrayData.swap(arr,leftSon,currentIndex);
            keepHeapify(arr,leftSon,biggestIndex);
        }
        if(rightSon<biggestIndex && arr[rightSon]<arr[currentIndex]){
            ArrayData.swap(arr,rightSon,currentIndex);
            keepHeapify(arr,rightSon,biggestIndex);
        }
    }
}
