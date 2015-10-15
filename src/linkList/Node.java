package linkList;
/*
 * ����Ľڵ���
 * ��������
 * ָ����һ���ڵ��ָ��
 * �������ݴ���һ���ڵ�Ĺ��캯��
 * �������ݺ���һ���ڵ�ָ�봴��һ���ڵ�Ĺ��캯��
 * get��set����
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
