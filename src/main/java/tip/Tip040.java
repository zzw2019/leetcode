package tip;

/**
 * @author zengzw
 * @version 1.0
 * @description Tip040
 * @since 2023/1/6 16:08
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Tip040 {
    public static int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length==0){
            return new int[]{};
        }
        //我的想法是先排序 后取数
        quicklySort(arr,0,arr.length-1);
        return getTailElement(arr,k);
    }

    /**
     * 取数组后几位
     * */
    public static int[] getTailElement(int arr[],int num){
        int [] newArr=new int[num];
        for(int i=0;i<num;i++){
            newArr[i]=arr[arr.length-i-1];
        }
        return newArr;
    }

    /**
     * quickly-sort
     * */
    public static void quicklySort(int [] arr,int beginIndex,int endIndex){
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

    private static void swap(int[] arr, int leftIndex, int rightIndex) {
        //swap element
        int tempV = arr[rightIndex];
        arr[rightIndex] = arr[leftIndex];
        arr[leftIndex] = tempV;
    }

    public static void main(String[] args) {
        int [] arr =new int []{3,2,1};
        int[] leastNumbers = getLeastNumbers(arr, 2);
        for (int i=0;i<leastNumbers.length;i++){
            System.out.print(arr[i]);
            System.out.print(",");
        }
    }
}
