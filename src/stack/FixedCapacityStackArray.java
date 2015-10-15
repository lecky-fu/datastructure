package stack;

import java.util.Iterator;

/*
 * 实现定容下压栈数据结构，数组实现
 * 数组实现的缺点：push和pop方法的实现有可能需要改变数组的大小，其操作时间与数组的大小成正比
 * 数据结构需要实现下述两个特性
 * 1，需要实现泛型数据
 * 2，需要实现迭代，即实现java中Iteragor接口
 * 数据域
 * 1，泛型数组，实现存放任何数据类型
 * 2，整数N存放数组大小
 * 构造器
 * 方法
 * 1，判断栈是否为空isEmpty(方法)
 * 2，返回栈的大小size()
 * 3，入栈方法push()
 * 4，出栈方法pop
 */
public class FixedCapacityStackArray<Item> implements Iterable<Item> {
	private Item[] item;
	private int N=0;
	/*
	 * 构造器
	 */
	@SuppressWarnings("unchecked")
	public FixedCapacityStackArray(int cap){
		this.item=(Item[])new Object[cap];
	}
	/*
	 * 改变栈的大小
	 */
	private void resize(int size){
		@SuppressWarnings("unchecked")
		Item[] temp=(Item[])new Object[size];
		for(int i=0;i<N;i++)
			temp[i]=item[i];
		item=temp;
	}
	/*
	 * 判断非空方法
	 */
	public boolean isEmpty(){
		return N==0;
	}
	/*
	 * 返回栈大小
	 */
	public int size(){
		return N;
	}
	/*
	 * 判断栈是否满
	 */
	public boolean isFull(){
		return N==item.length;
	}
	/*
	 * 入栈方法
	 */
	public boolean push(Item it){
		if(isFull())
			resize(item.length<<1);
		item[N++] = it;
		return true;
	}
	/*
	 * 出栈方法
	 */
	public Item pop(){
		Item it = null;
		it = item[--N];
		item[N]=null;
		if(N==(item.length>>2))
			resize(item.length>>1);
		return it;
	}
	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	private class ReverseArrayIterator<Item> implements Iterator<Item>{
		int n=N;
		@Override
		public boolean hasNext() {
			return n>0;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Item next() {
			return (Item) item[--n];
		}

		@Override
		public void remove() {
			
		}
		
	}
}
