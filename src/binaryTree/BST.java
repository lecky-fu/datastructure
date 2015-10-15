package binaryTree;

import java.util.Currency;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * BST满足：
 * 左子节点的值<根节点值<右子节点的值
 * 没有重复的元素出现
 * @author lecky
 *
 * @param <E>
 */
public class BST<E extends Comparable<E>> extends AbstractBinaryTree<E> {

	//树的根节点
	private TreeNode root ; 
	//树的大小
	private int size ; 
	
	public BST(){
		
	}
	
	public BST(E e){
		this.root = new TreeNode(e);
	}
	
	public BST(E[] obj){
		for(int i=0;i<obj.length;i++)
			this.insert(obj[i]);
	}
	
	/**
	 * 内部类，BST实现的数据结构
	 * @author lecky
	 *
	 */
	private class TreeNode{
		E element ; 
		TreeNode left ; 
		TreeNode right ;
		TreeNode(E e){
			this.element = e;
			this.left=null;
			this.right=null;
		}
	}
	
	/**
	 * 将根节点赋给当前节点，若
	 * 		为空树，返回false；
	 * 		小于当前节点，则当前节点= 其左子节点；
	 * 		大于当前节点，则当前节点= 其右子节点；
	 * 		等于当前节点，则找到；
	 */
	@Override
	public boolean search(E e) {
		if(0 == getSize())
			return false;
		TreeNode currentNode = root;
		while(null != currentNode){
			if(e.compareTo(currentNode.element)<0)
				currentNode = currentNode.left;
			else if(e.compareTo(currentNode.element)>0)
				currentNode = currentNode.right;
			else
				return true;
		}
		return false;
	}

	/**
	 * 将根节点赋给当前节点，若
	 * 		为空树，则创建根节点；
	 * 		小于当前节点，则当前节点=其左子节点；
	 * 		大于当前节点，则当前节点=其右子节点；
	 */
	@Override
	public boolean insert(E e) {
		if (0 == getSize()) {
			root = new TreeNode(e);
			size++;
			return true;
		}
		TreeNode currentNode = root ; 
		//这里需要使用一个节点定位新增节点的父节点，因为：父节点需要插入的子节点连接为空，不指向任何对象，
		//即currentNode = currentNode.left/right=null，当修改currentNode节点时，不会改变父节点的任何信息
		TreeNode parentNode = root ;
		while(null != currentNode){
			if(e.compareTo(currentNode.element)<0){
				parentNode = currentNode;
				currentNode = currentNode.left;
			}
			else if(e.compareTo(currentNode.element)>0){
				parentNode = currentNode;
				currentNode = currentNode.right;
			}
			else
				return false;
		}
		if(e.compareTo(parentNode.element)<0)
			parentNode.left = new TreeNode(e);
		else
			parentNode.right = new TreeNode(e);
		size++;
		return true;
	}

	/**
	 * 
	 */
	@Override
	public boolean delete(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 二叉树中右子节点为最大节点，故整个二叉树最大元素应在树的最右边
	 * 一定需要使用一个parrentNode节点变量来找出最后一个元素，currentNode指向的是最后一个元素的空引用
	 */
	@Override
	public E findMax() {
		if(0 == getSize())
			return null;
		TreeNode currentNode = root ;
		while(null != currentNode.right)
			currentNode = currentNode.right;
		return currentNode.element;
	}

	/**
	 * 二叉树中左边为最小节点，故整个二叉树最小元素应在树的最左边
	 * 一定需要使用一个parrentNode节点变量来找出最后一个元素，currentNode指向的是最后一个元素的空引用
	 */
	@Override
	public E findMin() {
		if(0 == getSize())
			return null;
		TreeNode currentNode = root ; 
		while(null != currentNode.left)
			currentNode = currentNode.left;
		return currentNode.element;
	}

	@Override
	public void clear() {
		size=0;
		root = null;
	}

	@Override
	public int getSize() {
		return size;
	}

	/**
	 * 判断是否为完全二叉树。
	 * 完全二叉树的要求为：第k-1层为满二叉树，第k层的叶子节点全部集中在左边，空节点在右边
	 * 实现方法：
	 * 使用广度优先搜索算法，入队时，要求节点若无左右子节点或者无右节点，后面所有节点均为叶子节点，否则不是完全二叉树
	 * 设置标志位boolean last=false；//是否是叶子节点
	 * 入队判断（队列若有元素），
	 * 若不是叶子节点
	 * 		左右子节点均存在，则入队
	 * 		左节点不存在，右节点存在，return false
	 * 		左节点存在，右节点不存在，标志位true叶子节点，入队
	 * 		左节点不存在，右节点不存在，标志位true叶子节点
	 * 	是叶子节点
	 * 		判断是否满足叶子节点的条件
	 */
	@Override
	public boolean isCompleteBinaryTree() {
		Queue<TreeNode>queue = new LinkedList<>();
		boolean last=false;
		TreeNode currentNode = null;
		queue.offer(root);
		while(!queue.isEmpty()){
			currentNode = queue.poll();
			if(!last){//非叶子节点
				if(null != currentNode.left && null != currentNode.right){
					queue.offer(currentNode.left);
					queue.offer(currentNode.right);
				}else if (null == currentNode.left && null != currentNode.right) {
					return false;
				}else if (null != currentNode.left && null == currentNode.right) {
					queue.offer(currentNode.left);
					last = true;
				}else 
					last = true;
			}else {//叶子节点，判断是否满足叶子节点的条件
				if (null != currentNode.left || null != currentNode.right) 
					return false;
			}
		}
		return true;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void inorder() {
		
	}

	/**
	 * 先序非递归方法：使用栈，将右子节点先进栈
	 */
	@Override
	public void preorder() {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode currentNode=null;
		while(!stack.isEmpty()){
			currentNode = stack.pop();
			System.out.print(currentNode.element+" ");
			if(null != currentNode.right)
				stack.push(currentNode.right);
			if(null != currentNode.left)
				stack.push(currentNode.left);
		}
	}

	@Override
	public void postorder() {
	
	}

	@Override
	public boolean isFullBinaryTree() {
		
		return false;
	}

	@Override
	public void levelorder() {
		Queue<TreeNode>queue = new LinkedList<>();
		Object[] obj= new Object[getSize()];
		TreeNode currentNode  ;
		queue.offer(root);
		while(!queue.isEmpty()){
			currentNode = queue.poll();
			System.out.print(currentNode.element+" ");
			if(null != currentNode.left)
				queue.offer(currentNode.left);
			if(null != currentNode.right)
				queue.offer(currentNode.right);
		}
	}

}
