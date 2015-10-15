package arrayList;
/*
 * java������Խ���ƪ�����Ա��½�ѧϰ
 * ���Ա�ĳ�����
 */
public abstract class MyAbstractList<E> implements MyList<E> {
	/*protected���η���ȷ��size���������ܹ���ͬ�����������Ҳ��ܱ��޸�*/
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
