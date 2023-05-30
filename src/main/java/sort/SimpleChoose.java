package sort;

import data.ArrayData;
import org.junit.Test;

/**
 * @ClassName Simple_Choose
 * @Author Zengzhw
 * @Date 2023/5/27 16:06
 * @Description Simple_Choose
 * @Version 1.0
 *
 * 选择排序-简单选择
 */
public class SimpleChoose {
    @Test
    public void test(){
        int[] ints = mySimpleChoose(ArrayData.ARR);
        ArrayData.print(ints);
    }

    /**
     * 简单选择排序
     *
     * 每一次找出最小的index，然后和1,2,3,...所在的位置的数字交换
     * */
    public int[] mySimpleChoose(int [] arr){
        //i代表次数，一共需要找到n-1次，最后一次可以不用
        for (int i = 0; i < arr.length-1; i++) {
            //查找出最小的元素的位置
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            //每次找到最小的数字之后，交换两个数组
            ArrayData.swap(arr,i,minIndex);
        }
        return arr;
    }
}
