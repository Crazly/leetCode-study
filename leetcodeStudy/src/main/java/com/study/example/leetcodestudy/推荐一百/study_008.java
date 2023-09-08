package com.study.example.leetcodestudy.推荐一百;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class study_008 {


    public static void checkRoot(){
        TreeNode treeNode = new TreeNode();
        boolean flag = check(treeNode.left,treeNode.right);
    }

    /**
     * 递归方法
     * @param node1
     * @param node2
     * @return
     */
    private static boolean check(TreeNode node1, TreeNode node2) {
        //左右子节点为空，则是对称二叉树
        if (node1==null&&node2==null) {
            return true;
        }
        if (node1==null||node2==null||node1.val!=node2.val) {
            return false;
        }
        //如果左树的左孩子与右树的右孩子对称，左树的右孩子与右树的左孩子对称，那么这个左树和右树就对称。
        return check(node1.left,node2.right)&&check(node1.right,node2.left);
    }

    /**
     * 迭代方法
     * @return
     */
    private static boolean check2(TreeNode node) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(node.left);
        nodeQueue.offer(node.right);
        while (!nodeQueue.isEmpty()){
            TreeNode left1 = nodeQueue.poll();
            TreeNode right1 = nodeQueue.poll();
            if (left1==null&&right1==null) {
                return true;
            }
            if (left1==null||right1==null||left1.val!=right1.val) {
                return false;
            }
            nodeQueue.offer(left1.left);
            nodeQueue.offer(left1.right);
            nodeQueue.offer(right1.left);
            nodeQueue.offer(right1.right);
        }
        return false;

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
