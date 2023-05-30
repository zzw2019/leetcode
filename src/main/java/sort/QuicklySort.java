package sort;

import data.ArrayData;
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


    /**
     * 问题1-荷兰旗问题  在一个乱序数组中，给一个数组n，数组左边都比n小，数组右边都比n大
     * 要求是时间复杂度是On 空间复杂度是O1
     * */
    @Test
    public void test01(){
        //设置标准数为25
        int standard=25;
        splitArray(ArrayData.ARR,standard);
        ArrayData.print(ArrayData.ARR);
    }

    /**
     * 思路：
     * 需要把数组根据一个数来分割，左边的都比他小，右边的都比他大
     * 定义一两个下标，一个是minIndex，一个是maxIndex
     *  1 2 6 7 0 4  6 7  基准数是5
     *  初始状态下，minIndex是0的位置  maxIndex是size-1
     *  minIndex向左移，直到遇到大于5的， max向右移动，直到遇到小于5的，两者交换，然后重复这个操作
     * */
    public void splitArray(int[] arr,int standard){
        int leftIndex=0;
        int rightIndex=arr.length-1;
        while(leftIndex<rightIndex){
            while (arr[leftIndex]<=standard){
                leftIndex++;
            }
            while (arr[rightIndex]>standard){
                rightIndex--;
            }
            if(leftIndex<rightIndex){
                ArrayData.swap(arr,leftIndex,rightIndex);
            }
        }
    }


    /**
     * 问题2-荷兰旗问题  在一个乱序数组中，给一个数组n，数组左边都比n小，数组右边都比n大  中间都等于n
     * 要求是时间复杂度是On 空间复杂度是O1
     * */
    @Test
    public void test02(){
        //设置标准数为25
        int standard=25;
        splitArrayThree(ArrayData.ARR,standard);
        ArrayData.print(ArrayData.ARR);
    }

    /**
     * 思路：
     * 4,25,6,34,25,75,12,354,57,25,25,32
     *
     * 定义小于区域索引从开始  大于区域从arr.length开始
     * 如果arr[i]< standard.
     *      i和小于区域前一个数交换
     *      小于区域索引右移
     *      i++
     * 如果arr[i]==standard,i++
     * 如果arr[i]>standard,
     *      i和大于区域前一个数字交换
     *      大于区域前移一位
     *      i不变
     *
     * ① i=0 ，命中arr[i]< standard情况
     *      i和小于区域前一个数交换：）4,25,6,34,25,75,12,354,57,25,25,32（  standard=25
     *      小于区域索引右移 4,）25,6,34,25,75,12,354,57,25,25,32（  25
     *      i++  i=1
     *
     * ② i=1 命中arr[i]=standard情况
     *      i++,i=2
     * ③i=2 命中arr[i]< standard情况
     *      i=2 小于区域前一个数字为25，交换  4,）6,25,34,25,75,12,354,57,25,25,32（  standard=25
     *      4,6,）25,34,25,75,12,354,57,25,25,32（
     *      i++ i=3
     * ④i=3  命中arr[i]>standard情况
     *      i和大于区域前一个数字交换 : 4,6,）25,32,25,75,12,354,57,25,25,34（
     *      大于区域前移一位: 4,6,）25,32,25,75,12,354,57,25,25,（34
     *      i不变还是3
     * ⑤i=3  命中arr[i]>standard情况
     *      4,6,）25,25,25,75,12,354,57,25,32,（34
     *      4,6,）25,25,25,75,12,354,57,25,（32,34
     *      i不变 i=3 ...
     * */
    public void splitArrayThree(int[] arr,int standard){
       int leftIndex=-1;
       int rightIndex=arr.length;
       for(int i=0;i<rightIndex;){
           if(arr[i]<standard){
               //交换小于区域后一个与i位置
               ArrayData.swap(arr,leftIndex+1,i);
               //小于区域向右扩展
               leftIndex++;
               i++;
           }else if(arr[i]==standard){
               i++;
           }else if(arr[i]>standard){
               //大于区域前一个和i位置交换
               ArrayData.swap(arr,rightIndex-1,i);
               //大于区域向左扩展
               rightIndex--;
           }
       }
    }


    /**
     * 4,25,6,34,25,75,12,354,57,25,25,32
     * */
    @Test
    public void testQuicklySort(){
        quicklySort(ArrayData.ARR,0,ArrayData.ARR.length-1);
        ArrayData.print(ArrayData.ARR);
    }

    public void quicklySort(int [] arr,int beginIndex,int endIndex){
        if(beginIndex==endIndex){
            return;
        }
        int leftIndex=beginIndex;
        int rightIndex=endIndex;
        int standardValue=arr[leftIndex];
        while (leftIndex<rightIndex){
            while (arr[leftIndex]<standardValue){
                leftIndex++;
            }
            while (arr[rightIndex]>=standardValue){
                rightIndex--;
            }
            if(leftIndex<rightIndex){
                ArrayData.swap(arr,leftIndex,rightIndex);
            }
        }
        //我这里漏掉了
        ArrayData.swap(arr,leftIndex,beginIndex);
        //这里之后 就以standard为标准，左边都比其小，右边都比其大
        quicklySort(arr,beginIndex,leftIndex-1);
        quicklySort(arr,leftIndex,endIndex);
    }

}
