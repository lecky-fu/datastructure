package queue;


public class Main {

	public static void main(String[] args) {
		QueueList<String>test=new QueueList<>();
		for(int i=0;i<10;i++){
			test.enqueue(i+"����");
		}
//		for(int i=0;i<10;i++){
//			System.out.println(test.dequeue());
//		}
		//����queueList��ʵ����Iteratable�ӿڣ��ʿ���ʹ��foreach���������������
		for (String str : test) {
			System.out.println(str);
		}
		//��������֪��������������ṹʵ�֣�Ҳ����ʹ��һ��forѭ����������
	}

}
