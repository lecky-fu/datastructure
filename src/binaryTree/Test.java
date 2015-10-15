package binaryTree;

public class Test {

	public static BST<Integer> bst = null;  
	public static void main(String[] args) {
		bst = new BST<Integer>(new Integer[]{
			60,55,100,45,57,67,107,59,101
		});
		searchTest();
		System.out.println("最大元素为="+bst.findMax());
		System.out.println("最小元素为="+bst.findMin());
		System.out.println("是否为完全二叉树："+bst.isCompleteBinaryTree());
		System.out.println("广度优先搜索遍历：");
		bst.levelorder();
		System.out.println("深度优先搜索遍历：");
		bst.inorder();
	}

	
	private static void searchTest(){
		for(int i =0;i<8;i++)
			System.out.println(i+"存在否？"+bst.search(i));
	}
}
