package data;


/**
 * @ClassName ArrayData
 * @Author Zengzhw
 * @Date 2023/5/27 16:07
 * @Description ArrayData
 * @Version 1.0
 */
public class ArrayData {
    public static final int ARR[]={4,25,6,34,25,75,12,354,57,25,25,32};

    /**
     * 交换两个数字的位置
     * */
    public static void swap(int arr[],int firstIndex,int secondIndex){
        int temp=arr[firstIndex];
        arr[firstIndex]=arr[secondIndex];
        arr[secondIndex]=temp;
    }

    /**
     * 输出数组
     * */
    public static void print(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    }
}
