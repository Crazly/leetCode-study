package leetedCode;

/**
 * 70. 爬楼梯
 */
public class ClimbStairs {
    // f(n) = f(n-1)+f(n-2)
    public static int climbStairs(int n) {
        int first=1, second = 2,result=0;
        if (n==1) {
            return first;
        }
        if (n==2) {
            return second;
        }
        for (int i = 3; i <= n; i++) {
            result=first+second;
            first=second;
            second=result;
        }

        return result;
    }


    public static void main(String[] args) {

        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(6));
        System.out.println(climbStairs(7));

    }



}
