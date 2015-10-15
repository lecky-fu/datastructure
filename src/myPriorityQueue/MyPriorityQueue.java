package myPriorityQueue;

public class MyPriorityQueue <E extends Comparable> {
	private Heap<E> heap=new Heap<E>(); 
	
	public void enqueue(E e){
		heap.heapAdd(e);
	}
	
	public E dequeue(){
		return heap.heapRemove();
	}
	
	public int getSize(){
		return heap.getSize();
	}
}
