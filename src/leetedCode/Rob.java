package leetedCode;

/**
 * 198 打家劫舍
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 */
public class Rob {
    /*
        num（i）表示当前房间金额，sum（i）表示当前房间之前最大总金额
        分为两种情况：1。偷当前房间i，则不能偷前一个房间i-1，能偷到的总金额为 sum（i-2）+num（i）
                    2。不偷当前房间，则能偷到的总金额为sum（i-1）
        比较两个金额哪个比较大：max（sum（i-2）+num（i），sum（i-1））
     */
    public static int rob(int[] nums) {

        if (nums.length==1) {
            return nums[0];
        }
        if(nums.length<=2) {
            return (nums.length==2) ? Math.max(nums[0],nums[1]) : nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];

    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,1};

        System.out.println(rob(nums));

    }

}
