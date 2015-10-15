package queue;

import java.util.Iterator;


/*
 * ����ʵ�ֶ������ݽṹ������������Ӻͳ��Ӷ����ù˼ɶ��еĴ�С
 * ע����ӷ�����������Ϊ���ǳ��ӣ���ᱨ��ָ���쳣
 * ����Ҫ�����������ڵ㣬ֱ������ӷ����д���
 * ����ʵ�ֱ���������ʵ�ֵ�ʱ����Ҫ�ı������С�Ĳ���
 * 
 * ע����Ҫ������ʵ�ֶ��п���ʹ�õ�������foreach������Ҫʵ��Iterator�ӿ�
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
		//ע�� ������ӣ�������Ϊ��ʱ����Ҫɾ��lastNode�ڵ�
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
