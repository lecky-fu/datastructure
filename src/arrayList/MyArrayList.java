package arrayList;

import java.util.Arrays;

public class MyArrayList<E> extends MyAbstractList<E> {
	public static final int INITIAL_CAPACITY = 10;
	private E[] data= (E[]) new  Object[INITIAL_CAPACITY];
	
	public MyArrayList() {
	}

	public MyArrayList(E[] list) {
		for(int i=0;i<list.length;i++)
			add(list[i]);
	}
	
	@Override
	public void add(int index, E e) {
		ensureCapacity();
		for(int i=size-1;i>=index;i--)
			data[i+1]=data[i];
		data[index]=e;
		size++;
	}

	private void ensureCapacity() {
		if(size>=data.length){
			E[] newdata= (E[]) new Object[size<<1];
			for(int i=0;i<data.length;i++)
				newdata[i] = data[i];
			data= newdata;
		}
	}

	@Override
	public void clear() {
		E[] newdata = (E[]) new Object[INITIAL_CAPACITY];
		data=newdata;
		size=0;
	}

	@Override
	public boolean contain(E e) {
		for(int i = 0;i<size;i++){
			if(data[i].equals(e))
				return true;
		}
		return false;
	}

	@Override
	public E get(int index) {
		return data[index];
	}

	@Override
	public int indexOf(E e) {
		for(int i=0;i<size;i++){
			if(data[i].equals(e))
				return i;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(E e) {
		for(int i=size-1;i>=0;i--){
			if(data[i].equals(e))
				return i;
		}
		return -1;
	}

	@Override
	public E remove(int index) {
		E result=data[index];
		for(int i=index;i<size-1;i++)
			data[i]=data[i+1];
		data[size-1]=null;
		return result;
	}

	@Override
	public E set(int index, E e) {
		E result = data[index];
		data[index]=e;
		return result;
	}
	
	public void trimToSize(){
		if(size!=data.length){
			E[] newdata=(E[]) new Object[size];
			for(int i=0;i<size;i++)
				newdata[i]=data[i];
			data=newdata;
		}
	}

	@Override
	public String toString() {
		return "MyArrayList [data=" + Arrays.toString(data) + "]";
	}
	
}
