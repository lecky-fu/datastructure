package binaryTree;

import java.util.Iterator;

public interface Tree<E extends Comparable> {
	/**
	 *查找元素
	 * @param e
	 * @return
	 */
	boolean search(E e);
	
	/**
	 * 插入元素
	 * @param e
	 * @return
	 */
	boolean insert(E e);
	
	/**
	 * 删除元素
	 * @param e
	 * @return
	 */
	boolean delete(E e);
	
	/**
	 * 查找最大元素
	 * @return
	 */
	E findMax();
	
	/**
	 * 查找最小元素
	 * @return
	 */
	E findMin();
	
	/**
	 * 清空树
	 */
	void clear();
	
	/**
	 * 获得树的大小
	 * @return
	 */
	int getSize();
	
	/**
	 * 判断树是否为空
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 * 判断树是否为完全二叉树
	 * @return
	 */
	boolean isCompleteBinaryTree();
	
	boolean isFullBinaryTree();
	
	/**
	 * 返回一个前序迭代器
	 * 使用迭代器可以迭代操作树中的元素，而使用inorder()函数只能打印树的元素值
	 * @return
	 */
	Iterator<E> iterator();
	
	/*中序遍历二叉树*/
	void inorder();
	
	/*先序遍历二叉树*/
	void preorder();
	
	/*后续遍历二叉树*/
	void postorder();
	
	/*广度遍历二叉树*/
	void levelorder();
	
}
