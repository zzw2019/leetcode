package sort;

import org.junit.Test;

/**
 * @ClassName QuicklySort
 * @Author Zengzhw
 * @Date 2023/1/6 21:34
 * @Description QuicklySort
 * @Version 1.0
 *
 * 快速排序
 * 要点
 * 1.右指针要先移
 * 2.每次不仅要用值和temp比较 还要 比较leftIndex和rightIndex
 */
public class QuicklySort {
    @Test
    public void test(){
        //6,1,2,7,9,8,4,5,10,8 试一下有重复元素的数组排序是否满足
        int arr[]={6,1,2,7,9,11,4,5,10,8};
        quicklySort(arr,0,arr.length-1);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            System.out.print(",");
        }
    }

    public void quicklySort(int [] arr,int beginIndex,int endIndex){
       if(beginIndex<endIndex){
           int leftIndex=beginIndex;
           int rightIndex=endIndex;
           int temp=arr[beginIndex];
           //每一次重复循环来将大于/小于temp的数分别放置到两边
           while (leftIndex<rightIndex){
               while (arr[rightIndex]>temp && leftIndex<rightIndex){
                   rightIndex--;
               }
               while(arr[leftIndex]<=temp && leftIndex<rightIndex){
                   leftIndex++;
               }
               swap(arr, leftIndex, rightIndex);
           }
           swap(arr,beginIndex,leftIndex);
           //依次向左右两个方向递归执行
           quicklySort(arr,beginIndex,leftIndex-1);
           quicklySort(arr,leftIndex+1,endIndex);
       }
    }

    private void swap(int[] arr, int endIndex, int rightIndex) {
        int temp= arr[rightIndex];
        arr[rightIndex]= arr[endIndex];
        arr[endIndex]=temp;
    }
}
