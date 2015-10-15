package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Josephus环的问题： 孩提时的你是否玩过“烫手山芋”游戏：一群小孩围成一圈，有一个刚出锅的山芋在他们之间
 * 传递。其中一个孩子负责数数，每数一次，拿着山芋的孩子就把山芋转交给右边的邻居。一旦数到
 * 某个特定的数，拿着山芋的孩子就必须退出，然后重新数数。如此不断，最后剩下的那个孩子就是 幸运者。 
 * 通常，数数的规则总是从 1 开始，数到 k 时让拿着山芋的孩子出列，然后重新从 1 开始。
 * 
 * Josephus 问题可以表述为： n 个孩子玩这个游戏，最后的幸运者是谁？
 * 为了解答这个问题，我们可以利用队列结构来表示围成一圈的n个孩子。一开始，假定对应于
 * 队列首节点的那个孩子拿着山芋。然后，按照游戏的规则，把“土豆”向后传递到第k个孩子
 * （交替 进行k次dequeue()和k次enqueue()操作），并让她出队（ dequeue()）。如此不断迭代，直到队长 （ getSize()）为 1。
 * 
 * 该算法每经过一次迭代，就有一个孩子出列，因此总共需要做 n-1 次迭代。每次迭代中，需要 顺序访问 k 个孩子，因此总的时间复杂度为 O(nk)。
 * 
 *  附：
 * 在java5中新增加了java.util.Queue接口，用以支持队列的常见操作。该接口扩展了java.util.Collection接口。
 * Queue使用时要尽量避免Collection的add()和remove()方法，而是要使用offer()来加入元素，使用poll()来获取并移出元素。
 * 它们的优 点是通过返回值可以判断成功与否，add()和remove()方法在失败的时候会抛出异常。如果要使用前端而不移出该元素，
 * 使用element()或者peek()方法。
 * 值得注意的是LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
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
		Queue<String> JosephusQueue=new LinkedList<String>();//创建Josephus队列
		for(int i=0;i<kids.length;i++)//将kids数组元素全部放入队列
			JosephusQueue.offer(kids[i]);
		while (1 != JosephusQueue.size()) {//如果队列大小不为1，则接着进行，直到队列大小为1
			for (int i = 1; i < k; i++)//数到k时，将k-1的元素全部移到队列尾端
				JosephusQueue.offer(JosephusQueue.poll());
			JosephusQueue.poll();//将第k个元素出队
		}
		return JosephusQueue.poll();
	}
	
}
