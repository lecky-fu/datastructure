package arrayList;
/*
 * java������Խ���ƪ�����Ա��½�ѧϰ
 * ���Ա�Ľӿ�				
 */
public interface MyList<E> {
	/*��e��ӵ�list��β��*/
	void add(E e);
	
	/*��ȡlist�Ĵ�С*/
	int getSize();
	
	/*��e��ӵ�ָ��indexλ��*/
	void add(int index,E e);
	
	/*ɾ��list�е�����Ԫ��*/
	void clear();
	
	/*�ж��Ƿ����Ԫ��e*/
	boolean contain(E e);
	
	/*��ȡָ��indexλ�õ�Ԫ��*/
	E get(int index);
	
	/*��ȡָ��Ԫ�ص�һ�����ֵ�λ��*/
	int indexOf(E e);
	
	/*��ȡָ��Ԫ�������ֵ�λ��*/
	int lastIndexOf(E e);
	
	/*�ж�list�Ƿ�Ϊ��*/
	boolean isEmpty();
	
	/*ɾ��Ԫ��e*/
	boolean remove(E e);
	
	/*ɾ��ָ��λ���ϵ�Ԫ��*/
	E remove(int index);
	
	/*��ָ��λ���ϵ�Ԫ���滻Ϊ��Ԫ��*/
	E set(int index,E e);

	void trimToSize();
}