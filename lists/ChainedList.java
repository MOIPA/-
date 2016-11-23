package com.r.t;

public class ChainedList implements List {

	private Node head;

	public ChainedList() {
		this.head = null;
	}

	public void clear() {
		this.head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int length() {
		Node p = this.head;
		int count = 0;
		while (p != null) {
			count++;
			p = p.next;
		}
		return count;
	}

	public int locate(Object obj) {
		if (obj == null)
			throw new IllegalAccessError("参数为空");

		Node p = head;
		int count = 0;
		while (p != null) {
			count++;
			// p = p.next;
			if (obj.equals(p.elements)) {
				return count;
			}
			p = p.next;
		}
		return -1;
	}

	public Object get(int index) {
		if (index < 1 || index > length()) {
			throw new IllegalArgumentException("错误参数");
		}
		Node p = this.head;
		int count = 0;
		while (p != null) {
			count++;

			if (count == index) {
				return p.elements;
			}
			p = p.next;
		}
		return null;
	}

	public Object pre(Object obj) {
		if (obj == null)
			throw new IllegalArgumentException("参数错误");
		int j = locate(obj) - 1;
		return get(j);
	}

	public Object aft(Object obj) {
		if (obj == null)
			throw new IllegalArgumentException("参数错误");
		int j = locate(obj) + 1;
		return get(j);
	}

	public void insert(Object obj, int index) {
		if (obj == null)
			throw new IllegalArgumentException("参数错误");

		if (index == 1) {
			Node node = new Node();
			node.elements = obj;
			node.next = this.head;
			this.head = node;
			// System.out.println("*****"+head.equals(node));
		} else {
			Node p = this.head;
			int count = 0;
			while (p != null) {
				count++;
				if (count == index - 1)
					break;
				p = p.next;
			}

			Node node = new Node();
			node.elements = obj;
			node.next = p.next;
			p.next = node;
		}
	}

	public Object delete(int index) {
		if (index < 1 || index > length())
			throw new IllegalArgumentException("参数错误");

		if (index == 1) {
			Node temp = this.head;
			this.head = temp.next;
		} else {
			Node p = this.head;
			int count = 0;
			while (p != null) {
				count++;
				if (count == index - 1)
					break;
			}
			Node temp = p.next;
			temp.next = null;
			return temp.elements;
		}
		return null;
	}

	public void travel() {
		Node p = this.head;
		while (p != null) {
			System.out.println(p.elements);
			p = p.next;
		}
	}

}
