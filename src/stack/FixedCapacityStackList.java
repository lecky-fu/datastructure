package stack;

import java.util.Iterator;

/*
 * 定容栈的链表实现方法，
 * 该方法避免的数组实现的缺点：push和pop方法需要改变数组的大小，其操作所需的时间与数组的大小成正比
 * 使用私有内部类实现节点的使用
 * 数据域：
 * 1，首节点firstNode
 * 2，栈大小N
 * 1，判断栈是否为空的方法isEmpty
 * 2，返回栈的大小size()
 * 3，入栈方法push()
 * 4，出栈方法pop
 */
public class FixedCapacityStackList<Item> {
	private class node{
		Item item;
		node next;
	}
	private node firstNode;
	private int N;
	public FixedCapacityStackList(){
		this.firstNode=new node();
	}
	public FixedCapacityStackList(Item item){
		this.firstNode=new node();
		firstNode.item=item;
	}
	public int size(){
		return N;
	}
	public boolean isEmpty(){
		return firstNode==null;
	}
	public void push(Item item){
		if(isEmpty())
			firstNode.item=item;
		else{
			node oldNode=firstNode;
			firstNode.item=item;
			firstNode.next=oldNode;
			N++;
		}
	}
	public Item pop(){
		if(!isEmpty()){
			Item item=firstNode.item;
			firstNode=firstNode.next;
			N--;
			return item;
		}else
			return null;
	}
	public Iterator<Item>stackIterator(){
		return  new stackIterator();
	}
	private class stackIterator implements Iterator<Item>{
		node currentNode=firstNode;
		@Override
		public boolean hasNext() {
			if(currentNode!=null)
				return true;
			return false;
		}

		@Override
		public Item next() {
			Item it=currentNode.item;
			currentNode=currentNode.next;
			return it;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
