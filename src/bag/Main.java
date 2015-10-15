package bag;

public class Main {

	public static void main(String[] args) {
		Bag<String>bag=new Bag<>();
		for(int i=0;i<10;i++){
			bag.add(i+"fupeng");
		}
		for (String str : bag) {
			System.out.println(str);
		}
	}

}
