package binaryTree;

public class Test {

	public static BST<Integer> bst = null;  
	public static void main(String[] args) {
		bst = new BST<Integer>(new Integer[]{
			60,55,100,45,57,67,107,59,101
		});
		searchTest();
		System.out.println("���Ԫ��Ϊ="+bst.findMax());
		System.out.println("��СԪ��Ϊ="+bst.findMin());
		System.out.println("�Ƿ�Ϊ��ȫ��������"+bst.isCompleteBinaryTree());
		System.out.println("�����������������");
		bst.levelorder();
		System.out.println("�����������������");
		bst.inorder();
	}

	
	private static void searchTest(){
		for(int i =0;i<8;i++)
			System.out.println(i+"���ڷ�"+bst.search(i));
	}
}
