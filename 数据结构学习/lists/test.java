//���⣺���ϵĲ�
//���ݽṹ��ҵ 2015020800117-����

package com.r.t;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {

		ChainedList chainedlist = new ChainedList(); // ��ʼ����������
		// chainedlist.insert("a", 1); //����������
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
		int n = 1; // ��ʼ������
		String MyString;
		Scanner reader = new Scanner(System.in);
		do {
			// ��ֹ�û����벻��ȷ������
			System.out.println("������˳������Ĵ�С��");
			n = reader.nextInt();
		} while (n <= 0);
		System.out.println("��������������");

		// MyString = reader.next();
		// �Ƿ��ǻ������л��е�����һ������Ϊ���У�����

		for (int i = 1; i <= n + 1; i++) {
			// ��������� ������+1 ��һ����ԶΪ���� ����Ϊ�û���������
			MyString = reader.nextLine();
			arraylist.insert(MyString, i);
		}
		do {
			System.out.println("��������ʽ����Ĵ�С��");
			n = reader.nextInt();
		} while (n <= 0);
		System.out.println("��������ʽ���������");
		// MyString = reader.next();
		for (int i = 1; i <= n + 1; i++) {
			MyString = reader.nextLine();
			chainedlist.insert(MyString, i);
		}
		// while(!MyString.isEmpty()){
		// ���ʣ���������ݺ��ַ���
		// int i=1;
		// chainedlist.insert(MyString, i);
		// i++;
		// }

		/*
		 * output
		 */
		System.out.println("ArrayList");
		// ���Array List������
		for (int i = 1; i <= arraylist.length(); i++) {
			System.out.print(arraylist.get(i) + "  ");
		}
		System.out.println("**************************");

		System.out.println("Chainedlist");
		// ���Chained List������
		for (int i = 1; i <= chainedlist.length(); i++) {
			System.out.print(chainedlist.get(i) + "  ");
		}
		System.out.println("**************************");

		/*
		 * merge code
		 */

		int flag = 0; // ��һ��flag
		int len = chainedlist.length() + 1;
		for (int i = 1; i <= arraylist.length(); i++) {

			flag = 0;
			for (int j = 1; j <= chainedlist.length(); j++) {
				if (arraylist.get(i).equals(chainedlist.get(j)))
					// ���˳���������Ԫ����ÿһ����ʽ����Ķ���һ��

					// ��ô�Ͱ�˳�������ﲻһ�����ĸ���������ʽ����
					flag = 1; // flagΪ1 ˵���������ÿһ����ʽ�������Ԫ�ض���һ��
			}
			// System.out.println("****");
			System.out.print(flag + " ");
			// �鿴flag�����
			if (flag == 0) {
				chainedlist.insert(arraylist.get(i), len);
				// ʵ�ֲ���
				len++;
			}

		}

		/*
		 * show merged list
		 */
		System.out.println(" ");
		System.out.println("MergedList:�������ϵĲ�Ϊ��");
		for (int i = 1; i <= chainedlist.length(); i++) {
			System.out.print(chainedlist.get(i) + "  ");
		}
		System.out.println("**************************");

	}
}
