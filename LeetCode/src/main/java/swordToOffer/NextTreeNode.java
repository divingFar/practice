package swordToOffer;


public class NextTreeNode {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        /**
         * 分2种情况
         *
         */
        //情况1该接节点有右子树
        if (pNode.next != null) {
            pNode = pNode.right;
            while (pNode.left != null && pNode.right != null) {
                if (pNode.left != null) {
                    pNode = pNode.left;
                } else {
                    pNode = pNode.right;
                }
            }
            return pNode;
            //有return的if语句不用else，因为if成立了就不会执行下面的了
        } else {
            if (pNode.next != null) {
                return pNode.next;
            } else {
                while (pNode.next != pNode.next.next) {
                    pNode = pNode.next;
                }
                if (pNode != null) {
                    return pNode;
                }
                return null;
            }
        }
    }
}