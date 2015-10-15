package binaryTree;

import java.util.Currency;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * BST���㣺
 * ���ӽڵ��ֵ<���ڵ�ֵ<���ӽڵ��ֵ
 * û���ظ���Ԫ�س���
 * @author lecky
 *
 * @param <E>
 */
public class BST<E extends Comparable<E>> extends AbstractBinaryTree<E> {

	//���ĸ��ڵ�
	private TreeNode root ; 
	//���Ĵ�С
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
	 * �ڲ��࣬BSTʵ�ֵ����ݽṹ
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
	 * �����ڵ㸳����ǰ�ڵ㣬��
	 * 		Ϊ����������false��
	 * 		С�ڵ�ǰ�ڵ㣬��ǰ�ڵ�= �����ӽڵ㣻
	 * 		���ڵ�ǰ�ڵ㣬��ǰ�ڵ�= �����ӽڵ㣻
	 * 		���ڵ�ǰ�ڵ㣬���ҵ���
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
	 * �����ڵ㸳����ǰ�ڵ㣬��
	 * 		Ϊ�������򴴽����ڵ㣻
	 * 		С�ڵ�ǰ�ڵ㣬��ǰ�ڵ�=�����ӽڵ㣻
	 * 		���ڵ�ǰ�ڵ㣬��ǰ�ڵ�=�����ӽڵ㣻
	 */
	@Override
	public boolean insert(E e) {
		if (0 == getSize()) {
			root = new TreeNode(e);
			size++;
			return true;
		}
		TreeNode currentNode = root ; 
		//������Ҫʹ��һ���ڵ㶨λ�����ڵ�ĸ��ڵ㣬��Ϊ�����ڵ���Ҫ������ӽڵ�����Ϊ�գ���ָ���κζ���
		//��currentNode = currentNode.left/right=null�����޸�currentNode�ڵ�ʱ������ı丸�ڵ���κ���Ϣ
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
	 * �����������ӽڵ�Ϊ���ڵ㣬���������������Ԫ��Ӧ���������ұ�
	 * һ����Ҫʹ��һ��parrentNode�ڵ�������ҳ����һ��Ԫ�أ�currentNodeָ��������һ��Ԫ�صĿ�����
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
	 * �����������Ϊ��С�ڵ㣬��������������СԪ��Ӧ�����������
	 * һ����Ҫʹ��һ��parrentNode�ڵ�������ҳ����һ��Ԫ�أ�currentNodeָ��������һ��Ԫ�صĿ�����
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
	 * �ж��Ƿ�Ϊ��ȫ��������
	 * ��ȫ��������Ҫ��Ϊ����k-1��Ϊ������������k���Ҷ�ӽڵ�ȫ����������ߣ��սڵ����ұ�
	 * ʵ�ַ�����
	 * ʹ�ù�����������㷨�����ʱ��Ҫ��ڵ����������ӽڵ�������ҽڵ㣬�������нڵ��ΪҶ�ӽڵ㣬��������ȫ������
	 * ���ñ�־λboolean last=false��//�Ƿ���Ҷ�ӽڵ�
	 * ����жϣ���������Ԫ�أ���
	 * ������Ҷ�ӽڵ�
	 * 		�����ӽڵ�����ڣ������
	 * 		��ڵ㲻���ڣ��ҽڵ���ڣ�return false
	 * 		��ڵ���ڣ��ҽڵ㲻���ڣ���־λtrueҶ�ӽڵ㣬���
	 * 		��ڵ㲻���ڣ��ҽڵ㲻���ڣ���־λtrueҶ�ӽڵ�
	 * 	��Ҷ�ӽڵ�
	 * 		�ж��Ƿ�����Ҷ�ӽڵ������
	 */
	@Override
	public boolean isCompleteBinaryTree() {
		Queue<TreeNode>queue = new LinkedList<>();
		boolean last=false;
		TreeNode currentNode = null;
		queue.offer(root);
		while(!queue.isEmpty()){
			currentNode = queue.poll();
			if(!last){//��Ҷ�ӽڵ�
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
			}else {//Ҷ�ӽڵ㣬�ж��Ƿ�����Ҷ�ӽڵ������
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
	 * ����ǵݹ鷽����ʹ��ջ�������ӽڵ��Ƚ�ջ
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
