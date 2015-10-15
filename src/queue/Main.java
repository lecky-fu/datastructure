package queue;


public class Main {

	public static void main(String[] args) {
		QueueList<String>test=new QueueList<>();
		for(int i=0;i<10;i++){
			test.enqueue(i+"付朋");
		}
//		for(int i=0;i<10;i++){
//			System.out.println(test.dequeue());
//		}
		//由于queueList类实现了Iteratable接口，故可以使用foreach方法遍历该类对象
		for (String str : test) {
			System.out.println(str);
		}
		//或者若是知道该类是用链表结构实现，也可以使用一下for循环方法遍历
	}

}
