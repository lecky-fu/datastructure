package arrayList;
/*
 * java编程语言进阶篇，线性表章节学习
 * 线性表的抽象类
 */
public abstract class MyAbstractList<E> implements MyList<E> {
	/*protected修饰符，确保size变来变量能够被同包里的类访问且不能被修改*/
	protected int size;

	@Override
	public void add(E e) {
		add(size, e);
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public boolean remove(E e) {
		if(indexOf(e)>=0){
			remove(indexOf(e));
			return true;
		}
		return false;
	}

	@Override
	public int getSize() {
		return size;
	}
	
}
