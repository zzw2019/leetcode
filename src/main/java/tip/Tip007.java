package tip;

/**
 * @ClassName Tip007
 * @Author Zengzhw
 * @Date 2023/1/9 20:28
 * @Description Tip007
 * @Version 1.0
 *
 *
 */
public class Tip007 {

    public static void main(String[] args) {
        //leetcode答案
//        System.out.println(reverse(1147483649));

        //2147483647
        System.out.println(Integer.MAX_VALUE);

        //-2147483648
        System.out.println(Integer.MAX_VALUE+1);

        //873912819
        System.out.println(reverse01(-1463847412));
    }

    /**
     * 思路：
     * 使用取余的方式，从末尾开始获取余数，然后判断余数组成的数字是否大于INTEGER.MAX
     * */
    public static int reverse01(int x){
        int afterReverse=0;
        while(x!=0){
            //temp存储每一轮的余数
            int temp=x%10;
            if(afterReverse>214748364 || (afterReverse==214748364 && temp>7)){
                return 0;
            }else if(afterReverse<-214748364 || (afterReverse==-214748364 && temp<-8)){
                return 0;
            }
            afterReverse=afterReverse*10+temp;
            x=x/10;
        }
        return afterReverse;
    }

    public static int reverse(int x) {
        int res = 0;
        while(x!=0) {
            //每次取末尾数字
            int tmp = x%10;
            //判断是否 大于 最大32位整数
            if (res>214748364 || (res==214748364 && tmp>7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res<-214748364 || (res==-214748364 && tmp<-8)) {
                return 0;
            }
            res = res*10 + tmp;
            x /= 10;
        }
        return res;
    }

}
