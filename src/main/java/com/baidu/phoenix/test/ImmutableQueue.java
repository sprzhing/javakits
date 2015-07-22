package com.baidu.phoenix.test;

public interface ImmutableQueue<E> {

    public ImmutableQueue<E> enqueue(E e);

    public ImmutableQueue<E> dequeue();

    public E peek();

    public int size();

}

