package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Josephus�������⣺ ����ʱ�����Ƿ����������ɽ����Ϸ��һȺС��Χ��һȦ����һ���ճ�����ɽ��������֮��
 * ���ݡ�����һ�����Ӹ���������ÿ��һ�Σ�����ɽ��ĺ��ӾͰ�ɽ��ת�����ұߵ��ھӡ�һ������
 * ĳ���ض�����������ɽ��ĺ��Ӿͱ����˳���Ȼ��������������˲��ϣ����ʣ�µ��Ǹ����Ӿ��� �����ߡ� 
 * ͨ���������Ĺ������Ǵ� 1 ��ʼ������ k ʱ������ɽ��ĺ��ӳ��У�Ȼ�����´� 1 ��ʼ��
 * 
 * Josephus ������Ա���Ϊ�� n �������������Ϸ��������������˭��
 * Ϊ�˽��������⣬���ǿ������ö��нṹ����ʾΧ��һȦ��n�����ӡ�һ��ʼ���ٶ���Ӧ��
 * �����׽ڵ���Ǹ���������ɽ��Ȼ�󣬰�����Ϸ�Ĺ��򣬰ѡ���������󴫵ݵ���k������
 * ������ ����k��dequeue()��k��enqueue()�����������������ӣ� dequeue()������˲��ϵ�����ֱ���ӳ� �� getSize()��Ϊ 1��
 * 
 * ���㷨ÿ����һ�ε���������һ�����ӳ��У�����ܹ���Ҫ�� n-1 �ε�����ÿ�ε����У���Ҫ ˳����� k �����ӣ�����ܵ�ʱ�临�Ӷ�Ϊ O(nk)��
 * 
 *  ����
 * ��java5����������java.util.Queue�ӿڣ�����֧�ֶ��еĳ����������ýӿ���չ��java.util.Collection�ӿڡ�
 * Queueʹ��ʱҪ��������Collection��add()��remove()����������Ҫʹ��offer()������Ԫ�أ�ʹ��poll()����ȡ���Ƴ�Ԫ�ء�
 * ���ǵ��� ����ͨ������ֵ�����жϳɹ����add()��remove()������ʧ�ܵ�ʱ����׳��쳣�����Ҫʹ��ǰ�˶����Ƴ���Ԫ�أ�
 * ʹ��element()����peek()������
 * ֵ��ע�����LinkedList��ʵ����Queue�ӿڣ�������ǿ��԰�LinkedList����Queue���á�
 * 
 * @author lecky
 *
 */
public class Josephus {

	public static void main(String[] args) {
		String[] kids = {"zhangsan","lisi","wangwu","laoliu"};
		int k=4;
		System.out.println(Josephus(kids, k));
	}
	
	private static String Josephus(String[] kids,int k){
		Queue<String> JosephusQueue=new LinkedList<String>();//����Josephus����
		for(int i=0;i<kids.length;i++)//��kids����Ԫ��ȫ���������
			JosephusQueue.offer(kids[i]);
		while (1 != JosephusQueue.size()) {//������д�С��Ϊ1������Ž��У�ֱ�����д�СΪ1
			for (int i = 1; i < k; i++)//����kʱ����k-1��Ԫ��ȫ���Ƶ�����β��
				JosephusQueue.offer(JosephusQueue.poll());
			JosephusQueue.poll();//����k��Ԫ�س���
		}
		return JosephusQueue.poll();
	}
	
}
