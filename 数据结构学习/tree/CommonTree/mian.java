package Tree;

public class mian {
	public static void main(String[] args) {
		BinTree test = new BinTree();
		//System.out.println(test.isEmpty());
		TreeNode record;
		test.insertroot("a");
		
		record = test.insertLeft(test.root(), "b");
		record = test.insertLeft(record, "d");
		//System.out.println("depth d:"+test.depth());
		record = test.insertRight(record, "e");
		//System.out.println("depth e:"+test.depth());
		record = test.insertRight(record, "f");
		
		record = test.insertRight(test.root(), "c");
		record = test.insertRight(record, "g");
		record = test.insertLeft(record, "h");

		test.preOrderTraverse();
		System.out.println("\n***************");
		test.inOrderTraverse();
		System.out.println("\n***************");
		test.levelTraverse();
		System.out.println("\n***************");
		test.afOrderTraverse();
		System.out.println("\n***************");
		record = test.find("e");
		record = test.insertLeft(record, "FindAndInsert");
		test.levelTraverse();
		System.out.println("\n***************");
		System.out.println("depth:"+test.depth());
		
		System.out.println(test.isEmpty());
		
		System.out.println(test.rightSibing(test.find("b")).element);
		
		System.out.println(test.leftSibing(test.find("c")).element);
		
	}
}
