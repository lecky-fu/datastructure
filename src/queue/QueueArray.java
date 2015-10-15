package queue;
/*
 * 使用数组实现队列数据结构
 * 缺点：数组实现队列数据结构时，初始化数组大小之后不能改变数组的大小，若要改变，则会导致需要额外的时间和空间
 * 			使用链表可以避免该问题
 * 分析：
 * 1，队列有入队和出队两个方法
 * 2，入队和出队元素可以使用两个数组下标元素作为指针：front，back
 * 3，队列元素个数currentSize=front-back+1
 * 4，进行错误控制，当出队方法控制数组下标指针超出数组范围时，不能入队
 */
public class QueueArray {
	//定义数组
	private int[] queue;
	//定义两个下标指针
	private int front;
	private int back;
	//定义出队元素
	private int dequeueEle;
	//定义当前队列元素个数
	private int currentSize;
	
	/*
	 * 初始化队列数组
	 */
	public QueueArray(int size){
		//创建队列数组的大小
		queue=new int[size];
		//初始化队列指针
		front=0;
		back=0;
	}
	
	/*
	 * 定义入队方法
	 */
	public boolean enqueue(int element){
		if(back<queue.length){
			queue[back]=element;
			back++;
			return true;
		}else
			return false;
	}
	
	/*
	 * 出队方法
	 */
	public boolean dequeue(){
		if(front==0&&back==0)
				return false;
		if (front<=back) {
			dequeueEle=queue[front];
			front++;
			return true;
		}
		else
			return false;
	}
	
	/*
	 * 获取出队元素
	 */
	public int getDequeueEle() {
		return dequeueEle;
	}
	
}
