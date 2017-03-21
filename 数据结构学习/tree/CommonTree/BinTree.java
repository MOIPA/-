package Tree;
import java.util.*;
public class BinTree {

	private TreeNode root = new TreeNode();
						
	public BinTree(Object obj) {
		root.element = obj;
		root.left = null;
		root.right = null;
	}

	public BinTree() {
		root = null;
	}

	private int do_depth(TreeNode node){
		if (node==null){
			return 0;
		}
		
		int dl=do_depth(node.left);
		int dr=do_depth(node.right);
		
		return Math.max(dl, dr)+1;
	}

	private TreeNode do_find(TreeNode node,Object obj){
		if(node!=null){
			if(node.element.equals(obj))
				return node;
			else{
				if(do_find(node.left,obj)==null)
					return do_find(node.right, obj);
				else return do_find(node.left, obj);
			}
		}
		return null;
	}

	private void do_preOrderTraverse(TreeNode node) {
		if (node != null) {
			access(node);
			do_preOrderTraverse(node.left);
			do_preOrderTraverse(node.right);
		}
	}

	private void do_afOrderTraverse(TreeNode node) {
		if (node != null) {
			
			do_preOrderTraverse(node.left);
			access(node);
			do_preOrderTraverse(node.right);
		}
	}
	
	private void do_inOrderTraverse(TreeNode node) {
		if (node != null) {
			do_inOrderTraverse(node.left);
			do_inOrderTraverse(node.right);
			access(node);
		}
	}

	private void access(TreeNode node) {
		System.out.print(node.element + " ");
	}

	public Object deleteNode() {
		return null;
	}
	
	

	public void clear() {
		root = null;
	}

	public boolean isEmpty() {
		return root==null;
	}

	public TreeNode root() {
		return root;
	}

	public TreeNode parenent(TreeNode node) {
		return node.parent;
	}

	public TreeNode leftSibing(TreeNode node) {
		if(node.parent.left==node)
			return null;
		else return node.parent.left;
	}

	public TreeNode rightSibing(TreeNode node) {
		TreeNode record = node.parent;
		if(record.right==node)
			return null;
		else return record.right;
	}

	public void insertroot(Object obj){
		root=new TreeNode(obj);
	}
	
	public TreeNode find(Object obj){
		return do_find(root, obj);
	}
	
	public TreeNode insertLeft(TreeNode node, Object obj) {
		if(node==null)
			throw new IllegalArgumentException("root is empty");
		TreeNode p = new TreeNode(obj);
		node.left = p;
		node.left.parent=node;
		return node.left;
	}

	public TreeNode insertRight(TreeNode node, Object obj) {
		if(node==null)
			throw new IllegalArgumentException("root is empty");
		TreeNode p = new TreeNode(obj);
		node.right = p;
		node.right.parent=node;
		return node.right;
	}

	public void preOrderTraverse() {
		do_preOrderTraverse(this.root);
	}
	
	public void afOrderTraverse() {
		do_afOrderTraverse(this.root);
	}

	public void inOrderTraverse() {
		do_inOrderTraverse(this.root);
	}
	public void levelTraverse(){
		if(isEmpty()) return ;
		Queue q = new LinkedList();
		q.add(root);
		while(!q.isEmpty()){
			TreeNode node = (TreeNode)q.remove();
			access(node);
			if(node.left!=null) q.add(node.left);
			if(node.right!=null) q.add(node.right);
		}
	}
	
	public int depth(){
		return do_depth(root);
	}
	
	
	public void delete(TreeNode node){
		TreeNode parent;
		parent = node.parent;
		
		if(node.left==null&&node.right!=null){
			node=node.right;
		}
		else if(node.left!=null&&node.right==null){
			node=node.left;
		}
		else if(node.left==null&&node.right==null)
			parent.left=parent.right=null;
	}
}
