package com.future.message.algorithm;

import com.future.message.algorithm.bean.TreeNode;
import com.future.message.util.ShowLogUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/3/5 13:01
 * Description:
 */
public class SolutionTreeNode {
    // 前序遍历
    // 递归
    // 时间复杂度O(n)
    // 空间复杂度O(n)
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public static void preorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    // 中序遍历
    // 迭代
    // 时间复杂度O(n)
    // 空间复杂度O(n)
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    // 后序遍历
    // 迭代
    // 时间复杂度O(n)
    // 空间复杂度O(n)
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public static void postorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    // 层序遍历
    // 时间复杂度O()
    // 空间复杂度O()
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            List<Integer> tempList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                tempList.add(t.val);
                if (t.left != null)
                    queue.offer(t.left);
                if (t.right != null)
                    queue.offer(t.right);
            }
            if (level % 2 == 1) {
                int length = tempList.size();
                for (int i = 0; i < length / 2; i++) {
                    int temp = tempList.get(i);
                    tempList.set(i, tempList.get(length - 1 - i));
                    tempList.set(length - 1 - i, temp);
                }
            }
            res.add(tempList);
        }
        return res;

//        if (root == null) {
//            return new ArrayList<List<Integer>>();
//        }
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
//        //将根节点放入队列中，然后不断遍历队列
//        queue.add(root);
//        while (queue.size() > 0) {
//            //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
//            int size = queue.size();
//            ShowLogUtil.info("size=" + size);
//            ArrayList<Integer> tmp = new ArrayList<Integer>();
//            //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
//            //如果节点的左/右子树不为空，也放入队列中
//            for (int i = 0; i < size; ++i) {
//                TreeNode t = queue.remove();
//                tmp.add(t.val);
//                if (t.left != null) {
//                    queue.add(t.left);
//                }
//                if (t.right != null) {
//                    queue.add(t.right);
//                }
//            }
//            //将临时list加入最终返回结果中
//            res.add(tmp);
//        }
//        return res;
    }


    // 二叉树最大深度
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }


    // 验证二叉搜索树
    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        // 左树的值小于根节点，右树的值大于根节点
        if (isValidBST(root.left) && isValidBST(root.right)
                && (root.left.val < root.val) && (root.right.val > root.val)) return true;
        return false;
    }

//    // 二叉树的层序遍历
//    public static List<List<Integer>> levelOrder(TreeNode root) {
//        if (root == null) return null;
//        List<List<Integer>> parent = new ArrayList<>();
//        List<Integer> child1 = new ArrayList<>();
//        if (root != null) {
//            child1.add(root.val);
//        }
//        parent.add(child1);
//
//        List<Integer> child2 = new ArrayList<>();
//        if (root.left != null) {
//            child2.add(root.left.val);
//        }
//        if (root.right != null) {
//            child2.add(root.right.val);
//        }
//        parent.add(child2);
//
//        List<Integer> child3 = new ArrayList<>();
//        if (root.right.left != null) {
//            child3.add(root.right.left.val);
//        }
//        if (root.right.right != null) {
//            child3.add(root.right.right.val);
//        }
//        parent.add(child3);
//        return parent;
//    }

//    public static boolean ergodic(TreeNode root) {
//    }
}
