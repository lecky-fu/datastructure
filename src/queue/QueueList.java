package queue;

import java.util.Iterator;


/*
 * 链表实现队列数据结构，可以随意入队和出队而不用顾忌队列的大小
 * 注意出队方法，若队列为空是出队，则会报空指针异常
 * 不需要构造器创建节点，直接在入队方法中创建
 * 链表实现避免了数组实现的时候需要改变数组大小的操作
 * 
 * 注意若要该链表实现队列可以使用迭代方法foreach，则需要实现Iterator接口
 */
public class QueueList<Item>implements Iterable<Item> {
	private class node{
		Item item;
		node next;
	}
	private node firstNode;
	private node lastNode;
	private int N;
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public void enqueue(Item item){
		node oldLast = lastNode;
		lastNode = new node();
		lastNode.item = item;
		lastNode.next=null;
		if(isEmpty())
			firstNode=lastNode;
		else
			oldLast.next = lastNode;
		N++;
	}
	public Item dequeue(){
		Item item =firstNode.item;
		firstNode=firstNode.next;
		N--;
		//注意 后期添加，当队列为空时，需要删除lastNode节点
		if(isEmpty())
			lastNode=firstNode;
		return item;
	}
	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator() ;
	}
	private class QueueIterator implements Iterator<Item> {
		private node index=firstNode;
		@Override
		public boolean hasNext() {
			return index!=null;
		}
		@Override
		public Item next() {
			Item item =index.item;
			index=index.next;
			return item;
		}
		@Override
		public void remove() {
			//TODO
		}
	}
}
