/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class KthLargestLevelSum {
    public long kthLargestLevelSum(TreeNode root, int k) {
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.offer(root);

        while(!bfsQueue.isEmpty()){
            long sum=0;
            int size = bfsQueue.size();
            for(int i=0;i<size;i++){
                TreeNode poppedNode = bfsQueue.poll();
                sum+=poppedNode.val;

                if(poppedNode.left!=null){
                    bfsQueue.offer(poppedNode.left);
                }
                if(poppedNode.right!=null){
                    bfsQueue.offer(poppedNode.right);
                }
            }
            pq.offer(sum);
            if(pq.size()>k){
                pq.poll();
            }
        }
        if(pq.size()<k){
            return -1;
        }
        return pq.peek();
    }
}
