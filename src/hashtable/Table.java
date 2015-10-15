package hashtable;

import java.util.LinkedList;
import java.util.List;

/*
 * hashtable�����ݽṹ
 * ʹ��
 * 		hash����������������
 * 		��ײ������������ӷ�
 */
public class Table<anyType> {
	private static final int DEFUALT_TABLE_SIZE=101;
	private List<anyType>[] theList;
	private int currentSize;
	
	public Table(){
		this(DEFUALT_TABLE_SIZE);
	}
	
	public Table(int tableSize){
		theList = new LinkedList[tableSize];
		for(int i=0;i<tableSize;i++)
			theList[i] = new LinkedList<anyType>();
	}
	
	public void insert(anyType xType){
		List<anyType>whichList = theList[myHash(xType)];
		System.out.println("�����������"+myHash(xType)+"\t����Ĺ�ϣֵ��"+xType.hashCode());
		if(!whichList.contains(xType)){
			whichList.add(xType);		//whichListֻ��һ��ָ��theList������ָ��λ�õ�ָ�룬�ʲ�����ʵ���ϻ���theList�������
			currentSize++;
		}
	}
	
	public void remove(anyType xType){
		List<anyType>whichList=theList[myHash(xType)];
		if(whichList.contains(xType)){
			whichList.remove(xType);
			currentSize--;
		}
	}
	
	public boolean contain(anyType xType){
		List<anyType>whichList=theList[myHash(xType)];
		return whichList.contains(xType);
	}
	
	public void makeEmpty(){
		currentSize=0;
		for(int i=0;i<theList.length;i++)
			theList[i].clear();
	}
	
	private int myHash(anyType xType){
		int hashVal=0;
		hashVal=xType.hashCode()%theList.length;
		if(hashVal<0)
			hashVal+=theList.length;
		return hashVal;
	}

	public static void main(String[] args) {
		Table<people> hashTable = new Table<people>(11);
		for(int i=0;i<11;i++)
			hashTable.insert(new people("xiaoming"+i, 20+i));
		hashTable.remove(new people("xiaoming0", 20));
		System.out.println("�ö����Ѿ���ɾ����ɢ�����Ƿ񻹰����ö���"+hashTable.contain(new people("xiaoming0", 20)));
	}
}

/*
 * �Զ������Ϊ���ܹ�����ɢ�У���Ҫʵ��hashCode��equal����
 */
class people{
	private String name;
	private int age;
	public people(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		people other = (people) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
