package com.r.t;

public class DoubleChainedList implements List {

	private DoubleNode head;

	public DoubleChainedList() {
		this.head = null;
	}

	public void clear() {
		this.head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int length() {
		DoubleNode p = this.head;
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

		DoubleNode p = head;
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
		DoubleNode p = this.head;
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

		DoubleNode p = this.head;
		int count = 0;
		while (p != null) {
			count++;
			if (count == index - 1)
				break;
			p = p.next;
		}
		DoubleNode node = null;
		node.elements = obj;
		node.next = p.next;
		node.prev = p;
		p.next.prev = node;

	}

	public Object delete(int index) {
		if (index < 1 || index > length())
			throw new IllegalArgumentException("参数错误");

		if (index == 1) {
			DoubleNode temp = this.head;
			this.head = temp.next;
		} else {
			DoubleNode p = this.head;
			int count = 0;
			while (p != null) {
				count++;
				if (count == index - 1)
					break;
			}
			DoubleNode temp = p.next;
			temp.next = null;
			return temp.elements;
		}
		return null;
	}

	public void travel() {
		DoubleNode p = this.head;
		while (p != null) {
			System.out.println(p.elements);
			p = p.next;
		}
	}

}
