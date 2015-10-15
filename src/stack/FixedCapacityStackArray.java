package stack;

import java.util.Iterator;

/*
 * ʵ�ֶ�����ѹջ���ݽṹ������ʵ��
 * ����ʵ�ֵ�ȱ�㣺push��pop������ʵ���п�����Ҫ�ı�����Ĵ�С�������ʱ��������Ĵ�С������
 * ���ݽṹ��Ҫʵ��������������
 * 1����Ҫʵ�ַ�������
 * 2����Ҫʵ�ֵ�������ʵ��java��Iteragor�ӿ�
 * ������
 * 1���������飬ʵ�ִ���κ���������
 * 2������N��������С
 * ������
 * ����
 * 1���ж�ջ�Ƿ�Ϊ��isEmpty(����)
 * 2������ջ�Ĵ�Сsize()
 * 3����ջ����push()
 * 4����ջ����pop
 */
public class FixedCapacityStackArray<Item> implements Iterable<Item> {
	private Item[] item;
	private int N=0;
	/*
	 * ������
	 */
	@SuppressWarnings("unchecked")
	public FixedCapacityStackArray(int cap){
		this.item=(Item[])new Object[cap];
	}
	/*
	 * �ı�ջ�Ĵ�С
	 */
	private void resize(int size){
		@SuppressWarnings("unchecked")
		Item[] temp=(Item[])new Object[size];
		for(int i=0;i<N;i++)
			temp[i]=item[i];
		item=temp;
	}
	/*
	 * �жϷǿշ���
	 */
	public boolean isEmpty(){
		return N==0;
	}
	/*
	 * ����ջ��С
	 */
	public int size(){
		return N;
	}
	/*
	 * �ж�ջ�Ƿ���
	 */
	public boolean isFull(){
		return N==item.length;
	}
	/*
	 * ��ջ����
	 */
	public boolean push(Item it){
		if(isFull())
			resize(item.length<<1);
		item[N++] = it;
		return true;
	}
	/*
	 * ��ջ����
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
