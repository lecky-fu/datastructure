package stack;

import java.util.Iterator;

/*
 * ����ջ������ʵ�ַ�����
 * �÷������������ʵ�ֵ�ȱ�㣺push��pop������Ҫ�ı�����Ĵ�С������������ʱ��������Ĵ�С������
 * ʹ��˽���ڲ���ʵ�ֽڵ��ʹ��
 * ������
 * 1���׽ڵ�firstNode
 * 2��ջ��СN
 * 1���ж�ջ�Ƿ�Ϊ�յķ���isEmpty
 * 2������ջ�Ĵ�Сsize()
 * 3����ջ����push()
 * 4����ջ����pop
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
