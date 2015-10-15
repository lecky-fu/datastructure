package linkList;
/*
 * 链表类：
 * 链表的第一个节点，创建链表、查询、遍历链表都需要从第一个节点开始
 * 创建空链表的构造函数
 * 创建一个节点的构造函数
 * 插入数据到整个链表的最前面的方法 InsertAtBegin()
 * 遍历链表的方法 VisitAllNode()
 * 将数据插入到指定index位置的方法 InsertAfterId()
 * 删除链表中第一个数据为id的节点 RemoveAtId()
 * 清空链表 removeAll()
 * 调整链(不改变数据)的方法来交换两个节点元素的顺序 swapWithNext()
 */
public class LinkList {
	//连表头
	private Node first_Node;
	/*
	 * 创建空链表
	 */
	public LinkList(){
		this.first_Node=null;
	}
	/*
	 * 创建含有一个元素的链表
	 */
	public LinkList(int data){
		this.first_Node=new Node(data);
	}
	/*
	 * 插入数据到整个链表的最前面的方法 InsertAtBegin()
	 */
	public void insertAtBegin(int data){
		if (this.first_Node==null) 
			this.first_Node=new Node(data);
		else {
			this.first_Node=new Node(data, first_Node);
		}
	}
	/*
	 * 访问链表所有节点元素
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
	 * 将数据插入到指定index的方法
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
	 *  删除链表中第一个数据为id的节点 RemoveAtId()
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
