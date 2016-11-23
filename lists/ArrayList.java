package com.r.t;

public class ArrayList implements List {

	private int len;
	private Object[] data;
	private int capacity;

	public ArrayList() {
		this.capacity = 1024;
		this.data = new Object[this.capacity];
	}

	public ArrayList(int capacity) {
		this.capacity = capacity;
		this.data = new Object[this.capacity];

	}

	public void clear() {
		this.len = 0;

	}

	public boolean isEmpty() {
		return this.len == 0;
	}

	public int length() {
		return this.len;
	}

	public Object get(int index) {// get the data[i]

		if (index < 1 || index > length()) {
			throw new IllegalArgumentException("参数错误");
		}

		return data[index - 1];
	}

	public int locate(Object obj) {// locate the data[i]
		int ret = -1;
		if (obj == null)
			throw new IllegalArgumentException("参数错误");
		for (int i = 0; i <= length() - 1; i++) {
			if (obj == data[i]) {
				ret = i + 1;
				break;
			}
		}
		return ret;
	}

	public Object pre(Object obj) {// qian yi ge
		if (obj == null || locate(obj) <= 1)
			throw new IllegalArgumentException("参数错误");
		int i = locate(obj) - 1;

		return get(i);

	}

	public Object aft(Object obj) {// hou yi ge
		if (obj == null || locate(obj) <= 1)
			throw new IllegalArgumentException("参数错误");
		int i = locate(obj) + 1;

		return get(i);
	}

	public void insert(Object obj, int index) {

		if (index < 1 || index > length() + 1 || obj == null) {
			throw new IllegalArgumentException("参数错误");
		}

		int j = index - 1;
		for (int i = length() - 1; i >= j; i--) {// ****************************************************i++
													// i--
			this.data[i + 1] = this.data[i];
		}
		this.data[j] = obj;
		this.len++;
	}

	public Object delete(int index) {
		if (index < 1 || index > length())
			throw new IllegalArgumentException("参数错误");
		int pos = index - 1;
		for (int i = pos + 1; i < length(); i++) {
			this.data[i - 1] = this.data[i];
		}
		Object o = this.data[pos];
		return o;
	}

	public void travel() {
		for (int i = 0; i < length(); i++) {
			System.out.println(this.data[i].toString() + "");
		}

	}

}
