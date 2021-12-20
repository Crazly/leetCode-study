package leetedCode;

/**
 * 213 打家劫舍2
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 *
 * 设：共有n个房间，前n个房间总金额dp[n],sum[n]第n个房间的金额,增加一个房间
 *      两种情况：偷第n+1间房间，总金额为 dp[n+1]=dp[n-1]+sum[n+1]
 *               不偷第n+1间房间，总金额为 dp[n+1]=dp[n]
 *      综合公式：dp[n+1] = max(dp[n],dp[n-1]+sum[n+1])
 *
 *
 *
 */
public class RobLeve2 {

    public static int rob(int[] nums) {
        if (null==nums||nums.length==0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i+1] = Math.max(dp[i-1]+nums[i+1],dp[i]);
        }
       return dp[dp.length-1];
    }

    public static void main(String[] args) {

        int[] nums = new int[]{2,3,2};

        System.out.println(rob(nums));

    }


}
