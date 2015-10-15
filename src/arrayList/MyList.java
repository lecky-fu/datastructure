package arrayList;
/*
 * java编程语言进阶篇，线性表章节学习
 * 线性表的接口				
 */
public interface MyList<E> {
	/*将e添加到list最尾部*/
	void add(E e);
	
	/*获取list的大小*/
	int getSize();
	
	/*将e添加到指定index位置*/
	void add(int index,E e);
	
	/*删除list中的所有元素*/
	void clear();
	
	/*判断是否包含元素e*/
	boolean contain(E e);
	
	/*获取指定index位置的元素*/
	E get(int index);
	
	/*获取指定元素第一个出现的位置*/
	int indexOf(E e);
	
	/*获取指定元素最后出现的位置*/
	int lastIndexOf(E e);
	
	/*判断list是否为空*/
	boolean isEmpty();
	
	/*删除元素e*/
	boolean remove(E e);
	
	/*删除指定位置上的元素*/
	E remove(int index);
	
	/*将指定位置上的元素替换为新元素*/
	E set(int index,E e);

	void trimToSize();
}