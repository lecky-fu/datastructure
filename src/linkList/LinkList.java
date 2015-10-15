package linkList;
/*
 * �����ࣺ
 * ����ĵ�һ���ڵ㣬����������ѯ������������Ҫ�ӵ�һ���ڵ㿪ʼ
 * ����������Ĺ��캯��
 * ����һ���ڵ�Ĺ��캯��
 * �������ݵ������������ǰ��ķ��� InsertAtBegin()
 * ��������ķ��� VisitAllNode()
 * �����ݲ��뵽ָ��indexλ�õķ��� InsertAfterId()
 * ɾ�������е�һ������Ϊid�Ľڵ� RemoveAtId()
 * ������� removeAll()
 * ������(���ı�����)�ķ��������������ڵ�Ԫ�ص�˳�� swapWithNext()
 */
public class LinkList {
	//����ͷ
	private Node first_Node;
	/*
	 * ����������
	 */
	public LinkList(){
		this.first_Node=null;
	}
	/*
	 * ��������һ��Ԫ�ص�����
	 */
	public LinkList(int data){
		this.first_Node=new Node(data);
	}
	/*
	 * �������ݵ������������ǰ��ķ��� InsertAtBegin()
	 */
	public void insertAtBegin(int data){
		if (this.first_Node==null) 
			this.first_Node=new Node(data);
		else {
			this.first_Node=new Node(data, first_Node);
		}
	}
	/*
	 * �����������нڵ�Ԫ��
	 */
	public String visitAllNode(){
		String s="";
		while(first_Node!=null){
			s+= first_Node.getM_Data();
			first_Node=first_Node.getM_Next();
		}
		return s;
	}
	
	/*
	 * �����ݲ��뵽ָ��index�ķ���
	 */
	public void insertAfterId(int id,int data){
		Node next=first_Node;
		if(next==null)
			next=new Node(data);
		else{
			while(next.getM_Next()!=null&&next.getM_Data()!=id){
				next=next.getM_Next();
			}
			next.setM_Next(new Node(data,next.getM_Next()));
		}
	}
	
	/*
	 *  ɾ�������е�һ������Ϊid�Ľڵ� RemoveAtId()
	 */
	public  boolean removeAtId(int id) {
		Node next=first_Node;
		Node ahead;
		if(next==null)
			return false;
		else if(next.getM_Data()==id){
			first_Node=next.getM_Next();
			return true;
		}else {
			
		}
		return false;
	}
}
