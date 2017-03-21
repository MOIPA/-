//主题：集合的并
//数据结构作业 2015020800117-唐锐

package com.r.t;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {

		ChainedList chainedlist = new ChainedList(); // 初始化两个链表
		// chainedlist.insert("a", 1); //测试用数据
		// chainedlist.insert("b", 2);
		// chainedlist.insert("c", 3);
		// chainedlist.insert("d", 4);

		ArrayList arraylist = new ArrayList(100);
		// arraylist.insert('c', 1);
		// arraylist.insert('d', 2);
		// arraylist.insert('e', 3);
		// arraylist.insert('f', 4);

		/*
		 * input
		 */
		int n = 1; // 初始化输入
		String MyString;
		Scanner reader = new Scanner(System.in);
		do {
			// 防止用户输入不正确的数字
			System.out.println("请输入顺序链表的大小：");
			n = reader.nextInt();
		} while (n <= 0);
		System.out.println("请输入链表内容");

		// MyString = reader.next();
		// 是否是缓存区有换行导致下一个读入为换行？？？

		for (int i = 1; i <= n + 1; i++) {
			// 解决方法： 将输入+1 第一个永远为换行 其余为用户输入数据
			MyString = reader.nextLine();
			arraylist.insert(MyString, i);
		}
		do {
			System.out.println("请输入链式链表的大小：");
			n = reader.nextInt();
		} while (n <= 0);
		System.out.println("请输入链式链表的内容");
		// MyString = reader.next();
		for (int i = 1; i <= n + 1; i++) {
			MyString = reader.nextLine();
			chainedlist.insert(MyString, i);
		}
		// while(!MyString.isEmpty()){
		// 疑问：读入的数据和字符串
		// int i=1;
		// chainedlist.insert(MyString, i);
		// i++;
		// }

		/*
		 * output
		 */
		System.out.println("ArrayList");
		// 输出Array List的内容
		for (int i = 1; i <= arraylist.length(); i++) {
			System.out.print(arraylist.get(i) + "  ");
		}
		System.out.println("**************************");

		System.out.println("Chainedlist");
		// 输出Chained List的内容
		for (int i = 1; i <= chainedlist.length(); i++) {
			System.out.print(chainedlist.get(i) + "  ");
		}
		System.out.println("**************************");

		/*
		 * merge code
		 */

		int flag = 0; // 立一个flag
		int len = chainedlist.length() + 1;
		for (int i = 1; i <= arraylist.length(); i++) {

			flag = 0;
			for (int j = 1; j <= chainedlist.length(); j++) {
				if (arraylist.get(i).equals(chainedlist.get(j)))
					// 如果顺序链表里的元素与每一个链式链表的都不一样

					// 那么就把顺序链表里不一样的哪个数加入链式链表
					flag = 1; // flag为1 说明这个数与每一个链式链表里的元素都不一样
			}
			// System.out.println("****");
			System.out.print(flag + " ");
			// 查看flag的情况
			if (flag == 0) {
				chainedlist.insert(arraylist.get(i), len);
				// 实现插入
				len++;
			}

		}

		/*
		 * show merged list
		 */
		System.out.println(" ");
		System.out.println("MergedList:两个集合的并为：");
		for (int i = 1; i <= chainedlist.length(); i++) {
			System.out.print(chainedlist.get(i) + "  ");
		}
		System.out.println("**************************");

	}
}
