package BinaryTree;

public class BinarySortTree {

	private TreeNode root;

	public BinarySortTree() {
		this.root = null;
	}

	private boolean isleaf(TreeNode p) {
		return p.left == null && p.right == null;
	}

	private Student do_searchRecurse(TreeNode node, int key) {
		Student temp = node.ele;
		if (temp == null) {
			return null;
		}
		if (temp.ID == key)
			return temp;
		else if (temp.ID < key)
			return do_searchRecurse(node.right, key);
		else
			return do_searchRecurse(node.left, key);

	}

	public Student searchRecurse(int key) {
		return do_searchRecurse(this.root, key);
	}

	private TreeNode searchNonRecurse4Node(int key) {
		TreeNode p = this.root;
		while (p != null) {
			Student temp = p.ele;
			if (temp.ID == key)
				return p;
			if (temp.ID > key)
				p = p.left;
			if (temp.ID < key)
				p = p.right;
		}
		return null;
	}

	public Student removeNonRecurse(int key) {//****************老师写错了  需要重写INSERT函数将parent实现否则指针悬空
		TreeNode node = searchNonRecurse4Node(key);
		//System.out.println(node.ele.ID+"****************");
		if (node == null)
			return null;
		if (!isleaf(node))
			return null;
		TreeNode parent = node.parent;
		if (parent.left == node)
			parent.left = null;
		else if (parent.right == node)
			parent.right = null;
		return node.ele;
	}

	public Student removeRecurse(int key) {
		Student temp = searchRecurse(key);
		root = do_removeRecurese(root, key);
		return temp;
	}

	private TreeNode do_removeRecurese(TreeNode node, int key) {
		if (node == null) {
			return null;
		}
		if (node.ele.ID == key) {
			if (!isleaf(node)) {
				//System.out.println("**************");
				return node;
			} else
				//System.out.println("**************");
				return null;
		} else if (node.ele.ID > key) {
			node.left = do_removeRecurese(node.left, key);
			return node;
		} else {//**************************************************************需要好好读读代码
			node.right = do_removeRecurese(node.right, key);
			return node;
		}
	}

	public void insertRecurse(Student stu) {
		root = do_insertRecurse(root, stu);
	}

	private TreeNode do_insertRecurse(TreeNode node, Student stu) {
		if (node == null) {
			TreeNode temp = new TreeNode();
			temp.ele = stu;
			return temp;
		}
		if (node.ele.ID == stu.ID) {
		} else if (node.ele.ID > stu.ID) {
			node.left = do_insertRecurse(node.left, stu);
			do_insertRecurse(node.left, stu).parent = node.left;
		} else {
			node.right = do_insertRecurse(node.right, stu);
			do_insertRecurse(node.right, stu).parent = node.right;
		}
		return node;
	}

	private Student access(TreeNode node) {
		return node.ele;
	}

	private void do_preOrderTraverse(TreeNode node) {
		if (node != null) {
			System.out.println(access(node).ID + " " + access(node).name);
			do_preOrderTraverse(node.left);
			do_preOrderTraverse(node.right);
		}
	}

	public void preOrderTraverse() {

		do_preOrderTraverse(root);
	}

	private class TreeNode {
		Student ele;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
	}
}
