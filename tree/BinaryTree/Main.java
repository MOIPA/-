package BinaryTree;

public class Main {
	public static void main(String[] args) {
		BinarySortTree test = new BinarySortTree();
		Student[] stu = new Student[10];
		stu[0] = new Student("1",1);
		stu[1] = new Student("2",2);
		stu[2] = new Student("3",3);
		stu[3] = new Student("4",4);
		stu[4] = new Student("5",5);
		stu[5] = new Student("6",6);
		stu[6] = new Student("7",7);
		test.insertRecurse(stu[2]);
		test.insertRecurse(stu[0]);
		test.insertRecurse(stu[1]);
		test.insertRecurse(stu[3]);
		
		System.out.println(test.searchRecurse(2).ID);
		
		System.out.println(test.removeNonRecurse(4).ID);
		
		test.preOrderTraverse();
	}
}	
