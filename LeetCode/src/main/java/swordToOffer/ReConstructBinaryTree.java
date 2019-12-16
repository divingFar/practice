package swordToOffer;

import java.util.Arrays;

/**
 * 总结二叉树分类讨论要点：
 * 1.是否为叶子节点
 * 2.为左节点还是右节点
 * 3.父节点为左节点还是右节点还是根节点7
 *
 * @author hzk
 */


public class ReConstructBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 由于
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                /**构建左子树时：
                 *     在前序数组中：选中的节点的左侧一定是在选中节点的前面前序遍历的，所以所有这些节点一定可以作为递归左子树的前序数组
                 *     在中序数组中：选中的节点的左侧一定是在选中节点的前面中序遍历的，所以所有这些节点一定可以作为递归右子树的中序数组
                 */
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                /**
                 * 定性结论：前序数组元素的个数一定是等于中序的
                 * 构建右子树
                 *     前序数组:选中的节点是第i个，所以前序的第i+1个是前序数组的第i+1个
                 */
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }

}
