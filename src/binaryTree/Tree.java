package binaryTree;

import java.util.Iterator;

public interface Tree<E extends Comparable> {
	/**
	 *����Ԫ��
	 * @param e
	 * @return
	 */
	boolean search(E e);
	
	/**
	 * ����Ԫ��
	 * @param e
	 * @return
	 */
	boolean insert(E e);
	
	/**
	 * ɾ��Ԫ��
	 * @param e
	 * @return
	 */
	boolean delete(E e);
	
	/**
	 * �������Ԫ��
	 * @return
	 */
	E findMax();
	
	/**
	 * ������СԪ��
	 * @return
	 */
	E findMin();
	
	/**
	 * �����
	 */
	void clear();
	
	/**
	 * ������Ĵ�С
	 * @return
	 */
	int getSize();
	
	/**
	 * �ж����Ƿ�Ϊ��
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 * �ж����Ƿ�Ϊ��ȫ������
	 * @return
	 */
	boolean isCompleteBinaryTree();
	
	boolean isFullBinaryTree();
	
	/**
	 * ����һ��ǰ�������
	 * ʹ�õ��������Ե����������е�Ԫ�أ���ʹ��inorder()����ֻ�ܴ�ӡ����Ԫ��ֵ
	 * @return
	 */
	Iterator<E> iterator();
	
	/*�������������*/
	void inorder();
	
	/*�������������*/
	void preorder();
	
	/*��������������*/
	void postorder();
	
	/*��ȱ���������*/
	void levelorder();
	
}
