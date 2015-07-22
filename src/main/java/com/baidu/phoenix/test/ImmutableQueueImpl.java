package com.baidu.phoenix.test;

import java.util.ArrayList;
import java.util.List;

public class ImmutableQueueImpl<E> implements ImmutableQueue<E> {
	private List<E> list;

	public ImmutableQueueImpl(List<E> list) {
		this.list = list;
	}
	public ImmutableQueue<E> enqueue(E e) {
		list = new ArrayList<E>();
		list.add(e);
		return new ImmutableQueueImpl<E>(list);
	}

	public ImmutableQueue<E> dequeue() {
		if (!list.isEmpty()) {
			list.remove(0);
		}
		return new ImmutableQueueImpl<E>(list);
	}

	public E peek() {
		if (!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public int size() {
		return list.size();
	}

}
