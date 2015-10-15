package binaryTree;

import java.util.Iterator;

public interface Tree<E extends Comparable> {
	/**
	 *
	 * @param e
	 * @return
	 */
	boolean search(E e);
	boolean insert(E e);
	boolean delete(E e);
	E findMax();
	E findMin();
	void clear();
	int getSize();
	boolean isEmpty();
	boolean isCompleteBinaryTree();
	Iterator<E> iterator();
	
	/*�������������*/
	void inorder();
	
	/*�������������*/
	void preorder();
	
	/*��������������*/
	void postorder();
	
}
