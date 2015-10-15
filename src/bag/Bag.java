package bag;

import java.util.Iterator;

/*
 * 背包数据结构，链表实现
 */
public class Bag<Item>implements Iterable<Item> {
	private class node{
		Item item;
		node next;
	}
	private node firstNode;
	private int N;
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	//直接在链表的最前面添加节点元素
	public void add(Item item){
		node oldFirst=firstNode;
		firstNode=new node();
		firstNode.item=item;
		firstNode.next=oldFirst;
	}
	@Override
	public Iterator<Item> iterator() {
		return new BagIterator();
	}
	private class BagIterator implements Iterator<Item> {
		private node index=firstNode;
		@Override
		public boolean hasNext() {
			return index!=null;
		}
		@Override
		public Item next() {
			Item item = index.item;
			index=index.next;
			return item;
		}
		@Override
		public void remove() {
			// TODO Auto-generated method stub
		}
	}
}
