package com.r.t;

public interface List {

	void clear();

	boolean isEmpty();

	int length();

	int locate(Object obj);

	Object get(int index);

	Object pre(Object obj);

	Object aft(Object obj);

	void insert(Object obj, int index);

	Object delete(int index);

	public void travel();

}