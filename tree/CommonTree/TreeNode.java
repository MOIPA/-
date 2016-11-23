package Tree;

public class TreeNode {
	
	public Object element;
	
	public TreeNode left;
	
	public TreeNode right;
	
	public TreeNode parent;

	public TreeNode(Object data){
		element = data;
	}
	
	public TreeNode(){
		element = null;
	}
	
}
