package myPriorityQueue;

import java.util.ArrayList;
import java.util.List;

class Heap<E extends Comparable> {
	/*创建数组为最大二叉堆存放元素容器*/
	List<E> heapList=new  ArrayList<E>();
	
	public int getSize(){
		return heapList.size();
	}
	
	/*需要内部额外数组存放array中的元素*/
	public void heapSort(E[] array){
		for(E temp:array){
			heapAdd(temp);
		}
		for(int i=array.length-1;i>=0;i--){
			array[i]=heapRemove();
		}
	}
	
	/*将数组中的元素一个一个添加到最大二叉堆中
	 *1，首先将元素e添加到数组最后
	 *2，然后比较该元素与其父元素的大小，若小于父节点，则为二叉堆，否则交换两元素
	 *3，两个元素交换之后二叉堆结构可能会被破坏，因此需要对原父节点处的元素再与其父节点进行比较，重复第二步
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