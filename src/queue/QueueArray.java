package queue;
/*
 * ʹ������ʵ�ֶ������ݽṹ
 * ȱ�㣺����ʵ�ֶ������ݽṹʱ����ʼ�������С֮���ܸı�����Ĵ�С����Ҫ�ı䣬��ᵼ����Ҫ�����ʱ��Ϳռ�
 * 			ʹ��������Ա��������
 * ������
 * 1����������Ӻͳ�����������
 * 2����Ӻͳ���Ԫ�ؿ���ʹ�����������±�Ԫ����Ϊָ�룺front��back
 * 3������Ԫ�ظ���currentSize=front-back+1
 * 4�����д�����ƣ������ӷ������������±�ָ�볬�����鷶Χʱ���������
 */
public class QueueArray {
	//��������
	private int[] queue;
	//���������±�ָ��
	private int front;
	private int back;
	//�������Ԫ��
	private int dequeueEle;
	//���嵱ǰ����Ԫ�ظ���
	private int currentSize;
	
	/*
	 * ��ʼ����������
	 */
	public QueueArray(int size){
		//������������Ĵ�С
		queue=new int[size];
		//��ʼ������ָ��
		front=0;
		back=0;
	}
	
	/*
	 * ������ӷ���
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
	 * ���ӷ���
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
	 * ��ȡ����Ԫ��
	 */
	public int getDequeueEle() {
		return dequeueEle;
	}
	
}
