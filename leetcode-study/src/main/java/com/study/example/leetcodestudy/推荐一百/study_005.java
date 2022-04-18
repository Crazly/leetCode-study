package com.study.example.leetcodestudy.推荐一百;

import java.util.ArrayList;
import java.util.List;

public class study_005 {

    /**
     * 94. 二叉树的中序遍历
     * 中序遍历：左根右
     * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
     *
     * 示例 1：
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
     * 示例 2：
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     * 输入：root = [1]
     * 输出：[1]
     * 示例 4：
     * 输入：root = [1,2]
     * 输出：[2,1]
     * 示例 5：
     * 输入：root = [1,null,2]
     * 输出：[1,2]
     *
     * 提示：
     * 树中节点数目在范围 [0, 100] 内
     * -100 <= Node.val <= 100
     *
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     */


    public static List<Integer> recursion(TreeNode treeNode){

        List<Integer> result = new ArrayList<>();
        check(result,treeNode);
        return result;
    }

    private static void check(List<Integer> result, TreeNode treeNode) {

        if (treeNode==null) {
            return;
        }
        check(result,treeNode.left);
        result.add(treeNode.val);
        check(result,treeNode.right);

    }


    /**
     * 递归测试学习 阶乘
     */
    public static long mu(int n){
        if (n==1) {
            return 1;
        }
        return n*mu(n-1);
    }



    public static void main(String[] args) {
//        System.out.println(mu(5));
    }


      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

}
