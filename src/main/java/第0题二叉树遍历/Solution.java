package 第0题二叉树遍历;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/4/1
 */

public class Solution {

    public static void recursivePre(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        recursivePre(treeNode.left);
        recursivePre(treeNode.right);
    }

    public static void recursiveIn(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        recursiveIn(treeNode.left);
        System.out.println(treeNode.val);
        recursiveIn(treeNode.right);
    }

    public static void recursivePost(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        recursivePost(treeNode.left);
        recursivePost(treeNode.right);
        System.out.println(treeNode.val);
    }

    public static void iteratorPre(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = treeNode;
        while (!stack.isEmpty() || temp != null) {
            while (temp != null) {
                System.out.println(temp.val);
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            temp = temp.right;
        }
    }

    public static void iteratorPre2(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = treeNode;
        stack.push(temp);

        while (!stack.isEmpty()) {
            temp = stack.pop();
            System.out.println(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    public static void iteratorIn(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode temp = treeNode;

        while (!stack.isEmpty() || temp != null) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            System.out.println(temp.val);
            temp = temp.right;
        }
    }

    public static void iteratorPost(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        TreeNode temp = treeNode;
        TreeNode lastVisit = treeNode;
        Stack<TreeNode> stack = new Stack<>();

        while (temp != null || !stack.isEmpty()) {

            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }

            temp = stack.peek();

            if (temp.right == null || temp.right == lastVisit) {
                System.out.println(temp.val);
                stack.pop();
                lastVisit = temp;
                temp = null;
            } else {
                temp = temp.right;
            }
        }
    }
    
    public static void iteratorLevel(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addLast(treeNode);
        while (!linkedList.isEmpty()) {
            treeNode = linkedList.removeFirst();
            System.out.println(treeNode.val);
            if (treeNode.left != null) {
                linkedList.addLast(treeNode.left);
            }
            if (treeNode.right != null) {
                linkedList.addLast(treeNode.right);
            }
        }
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
}
