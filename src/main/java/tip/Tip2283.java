package tip;


import java.util.HashMap;

/**
 * @author zengzw
 * @version 1.0
 * @description Tip2283
 * @since 2023/1/11 16:21
 *
 * 2283. 判断一个数的数字计数是否等于数位的值
 * 给你一个下标从 0 开始长度为 n 的字符串 num ，它只包含数字。
 *
 * 如果对于 每个 0 <= i < n 的下标 i ，都满足数位 i 在 num 中出现了 num[i]次，那么请你返回 true ，否则返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = "1210"
 * 输出：true
 * 解释：
 * num[0] = '1' 。数字 0 在 num 中出现了一次。
 * num[1] = '2' 。数字 1 在 num 中出现了两次。
 * num[2] = '1' 。数字 2 在 num 中出现了一次。
 * num[3] = '0' 。数字 3 在 num 中出现了零次。
 * "1210" 满足题目要求条件，所以返回 true 。
 * 示例 2：
 *
 * 输入：num = "030"
 * 输出：false
 * 解释：
 * num[0] = '0' 。数字 0 应该出现 0 次，但是在 num 中出现了一次。
 * num[1] = '3' 。数字 1 应该出现 3 次，但是在 num 中出现了零次。
 * num[2] = '0' 。数字 2 在 num 中出现了 0 次。
 * 下标 0 和 1 都违反了题目要求，所以返回 false 。
 *
 *
 * 在hashMap没有数字的时候不希望取出null而是其他数字 可以使用getOrDefault
 */

public class Tip2283 {

    public static void main(String[] args) {
//        System.out.println(digitCount("1"));
        System.out.println(digitCount2("1210"));
    }

    /**
     * 【思路】-自己都感觉麻烦 一旦涉及遍历所有
     * 统计各个数字的个数，Map<数字，个数>
     * 再遍历位数，一个个的比对
     *
     * */
    public static boolean digitCount(String num) {
        HashMap<Integer, Integer> tongji = tongji(num);
        for(int i=0;i<num.length();i++){
            int key = Integer.parseInt(String.valueOf(num.charAt(i)));
            //if (key!=tongji.get(i)){
            if (key!=tongji.getOrDefault(i,0)){
                return false;
            };
        }
        return true;
    }

    public static HashMap<Integer, Integer> tongji(String num){
        HashMap<Integer, Integer> hashMap=new HashMap();
        for(int i=0;i<num.length();i++){
            int key = Integer.parseInt(String.valueOf(num.charAt(i)));
            if(hashMap.containsKey(key)){
                hashMap.put(key,hashMap.get(key)+1);
            }else {
                hashMap.put(key,1);
            }

        }
        return hashMap;
    }


    /**
     * 官方答案
     * */
    public static boolean digitCount2(String num) {
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        int n = num.length();
        for (int i = 0; i < n; i++) {
            int digit = num.charAt(i) - '0';
            h.put(digit, h.getOrDefault(digit, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int v = num.charAt(i) - '0';
            if (h.getOrDefault(i, 0) != v) {
                return false;
            }
        }
        return true;
    }
}
