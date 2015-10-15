package binaryTree;

public abstract class AbstractBinaryTree<E extends Comparable<E>> implements Tree<E> {

	@Override
	public boolean isEmpty() {
		return 0 == getSize();
	}
}
