public class FlipEquivalent {
	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        boolean Withoutflip=false;
        boolean Withflip=false;
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        if(root1.val==root2.val){
    Withoutflip=flipEquiv(root1.left,root2.left) && flipEquiv(root1.right,root2.right);
    Withflip=flipEquiv(root1.right,root2.left) && flipEquiv(root1.left,root2.right);
        }
            return Withoutflip||Withflip;
    }
}
