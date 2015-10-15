package myPriorityQueue;

import java.util.ArrayList;
import java.util.List;

class Heap<E extends Comparable> {
	/*��������Ϊ������Ѵ��Ԫ������*/
	List<E> heapList=new  ArrayList<E>();
	
	public int getSize(){
		return heapList.size();
	}
	
	/*��Ҫ�ڲ�����������array�е�Ԫ��*/
	public void heapSort(E[] array){
		for(E temp:array){
			heapAdd(temp);
		}
		for(int i=array.length-1;i>=0;i--){
			array[i]=heapRemove();
		}
	}
	
	/*�������е�Ԫ��һ��һ����ӵ����������
	 *1�����Ƚ�Ԫ��e��ӵ��������
	 *2��Ȼ��Ƚϸ�Ԫ�����丸Ԫ�صĴ�С����С�ڸ��ڵ㣬��Ϊ����ѣ����򽻻���Ԫ��
	 *3������Ԫ�ؽ���֮�����ѽṹ���ܻᱻ�ƻ��������Ҫ��ԭ���ڵ㴦��Ԫ�������丸�ڵ���бȽϣ��ظ��ڶ���
	 */
	@SuppressWarnings("unchecked")
	public void heapAdd(E e) {
		heapList.add(e);
		int currentIndex=heapList.size()-1;
		while(currentIndex>0){
			int parentIndex= (currentIndex-1)<<1;
			if(heapList.get(currentIndex).compareTo(heapList.get(parentIndex))>0){
				E temp=heapList.get(parentIndex);
				heapList.set(parentIndex, heapList.get(currentIndex));
				heapList.set(currentIndex, temp);
			}else
				break;
			currentIndex=parentIndex;
		}
	}

	@SuppressWarnings("unchecked")
	public E heapRemove(){
		if(heapList.size()==0)
			return null;
		
		int currentIndex = 0;
		E result = heapList.get(currentIndex);
		heapList.set(currentIndex, heapList.get(heapList.size()-1));
		heapList.remove(heapList.size()-1);
		
		int leftChild;
		int rightChild;
		int maxIndex;
		while(currentIndex<heapList.size()){
			leftChild=(currentIndex<<1)+1;
			rightChild=leftChild+1;
			
			if(leftChild>=heapList.size())
				break;
			maxIndex=leftChild;
			if (rightChild<heapList.size()) {
				if(heapList.get(leftChild).compareTo(heapList.get(rightChild))<0)
					maxIndex=rightChild;
			}
			
			if (heapList.get(currentIndex).compareTo(heapList.get(maxIndex))<0) {
				E temp=heapList.get(currentIndex);
				heapList.set(currentIndex, heapList.get(maxIndex));
				heapList.set(maxIndex, temp);
				currentIndex=maxIndex;
			}else
				break;
		}
		return result;
	}

	
}