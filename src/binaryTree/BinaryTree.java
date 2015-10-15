package binaryTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import queue.QueueList;


public class BinaryTree<E extends Comparable<E>> implements Tree<E> {
	private TreeNode<E> root;
	private int size;
	
	public BinaryTree(){
		
	}
	public BinaryTree(E[] object){
		for(int i=0;i<object.length;i++)
			insert(object[i]);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean search(E e) {
		TreeNode<E> current=root;
		while(current!=null){
			if(current.treeData.compareTo(e)>0)
				current=current.left_Node;
			else if(current.treeData.compareTo(e)<0)
				current=current.right_Node;
			else
				return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean insert(E e) {
		if(root==null)
			root=new TreeNode<E>(e);
		else{
			TreeNode<E> parent,current;
			parent=current=root;
			while(current!=null){
				if(current.treeData.compareTo(e)>0){
					parent=current;
					current=current.left_Node;
				}else if (current.treeData.compareTo(e)<0) {
					parent=current;
					current=current.right_Node;
				}else
					return false;
			}
			if(parent.treeData.compareTo(e)>0)
				parent.left_Node=new TreeNode<E>(e);
			else
				parent.right_Node=new TreeNode<E>(e);
		}
		size++;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean delete(E e) {
		//找到该元素节点
		TreeNode<E> current =root;
		TreeNode<E> parent =null;
		while(current!=null){
			if(current.treeData.compareTo(e)>0){
				parent = current;
				current = current.left_Node;
			}
			else if(current.treeData.compareTo(e)<0){
				parent = current;
				current = current.right_Node;
			}
			else
				break;
		}
		if(current==null)
			return false;
		//若该节点元素左子树为空，直接把该节点的右子树接到父节点上
		if(current.left_Node==null){
			if(parent==null)			//考虑到该元素为根节点时，直接将根节点赋给右子节点
				root=current.right_Node;
			else {
				if(current.treeData.compareTo(parent.treeData)>0)
					parent.right_Node=current.right_Node;
				else 
					parent.left_Node=current.right_Node;
			}
		}else {								//该节点有左子树的时候，在左子树中找到最大的节点，并将最大节点值替换current节点，然后删除
			TreeNode<E> rightMost=current.left_Node;
			TreeNode<E> parentOfRightMost=current;
			while(rightMost.right_Node!=null){
				parentOfRightMost=rightMost;
				rightMost=rightMost.left_Node;
			}
			current.treeData=rightMost.treeData;
			if(parentOfRightMost.right_Node==rightMost)			//若current的左子树节点有右子树
				parentOfRightMost.right_Node=rightMost.left_Node;
			else																			//current的左子树节点没有右子树
				parentOfRightMost.left_Node=rightMost.left_Node;
		}
		size--;
		return true;
	}

	@Override
	public void clear() {
		root=null;
		size=0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public Iterator<E> iterator() {
		return new InorderIteartor();
	}

	private class InorderIteartor implements Iterator<E>{
		List<E> list= new ArrayList<E>();
		int current=0;
		
		/*构造器创建时，将二叉树所有节点以中序遍历方式存入list中*/
		InorderIteartor(){
			inorder();
		}
		
		private void inorder(){
			inorder(root);
		}
		
		@SuppressWarnings("unchecked")
		private void inorder(TreeNode<E> root) {
			if(root==null)
				return;
			inorder(root.left_Node);
			list.add(root.treeData);
			inorder(root.right_Node);
		}

		@Override
		public boolean hasNext() {
			if(current<list.size())
				return true;
			else
				return false;
		}

		@Override
		public E next() {
			return list.get(current++);
		}

		@Override
		public void remove() {
			delete(list.get(current));
			list.clear();
			inorder();
		}
		
	}
	
	@Override
	public void inorder() {
	}

	@Override
	public void preorder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postorder() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public E findMin() {
		TreeNode<E> current = root;
		if(current==null)
			return null;
		while(current.left_Node!=null)
			current = current.left_Node;
		return current.treeData;
	}
	@Override
	public E findMax() {
		TreeNode<E> current = root;
		if(current==null)
			return null; 
		while(current.right_Node!=null)
			current = current.right_Node;
		return current.treeData;
	}
	
	private class TreeNode<E extends Comparable<E>> {
		//定义树节点的左指针
		private TreeNode<E> left_Node;
		private TreeNode<E> right_Node;
		protected E treeData;
		
		//构造函数
		TreeNode(E newdata){
			this.treeData=newdata;
			left_Node=null;
			right_Node=null;
		}
	}

	@Override
	public boolean isCompleteBinaryTree() {
		QueueList<TreeNode<E>> queue =new QueueList<>();
		TreeNode<E> temp=null;
		boolean last=false;
		queue.enqueue(root);
		while(!queue.isEmpty()){
			temp=queue.dequeue();
			if(!last){
				if(temp.left_Node!=null && temp.right_Node==null){
					queue.enqueue(temp.left_Node);
					last=true;
				}else if(temp.left_Node==null&&temp.right_Node==null)
					last=true;
				else if(temp.left_Node!=null && temp.right_Node!=null){
					queue.enqueue(temp.left_Node);
					queue.enqueue(temp.right_Node);
				}else
					return false;
			}else {
				//判断剩下的是否为叶子节点
				if(temp.left_Node!=null || temp.right_Node!=null){
					return false;
				}
			}
		}
		return true;
	}

}
