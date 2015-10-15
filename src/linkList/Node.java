package linkList;
/*
 * 链表的节点类
 * 保存数据
 * 指向下一个节点的指针
 * 根据数据创建一个节点的构造函数
 * 根据数据和下一个节点指针创建一个节点的构造函数
 * get、set方法
 */
public class Node {
	private int m_Data;
	private Node m_Next;
	
	public Node(int data){
		this.m_Data=data;
		this.m_Next=null;
	}
	
	public Node(int data,Node node){
		this.m_Data=data;
		this.m_Next=node;
	}

	public int getM_Data() {
		return m_Data;
	}

	public void setM_Data(int m_Data) {
		this.m_Data = m_Data;
	}

	public Node getM_Next() {
		return m_Next;
	}

	public void setM_Next(Node m_Next) {
		this.m_Next = m_Next;
	}
	
}
