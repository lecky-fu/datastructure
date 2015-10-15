package stack;


public class Main {

	public static void main(String[] args) {
		//双栈法实现算数表达式的求值问题
		evaluate("(1+((2*3)*(4*5)))");
		//定容栈数组 实现测试函数
		FixedCapacityStackArrayTest();
		System.out.println();
		//定容栈链表实现测试函数
		FixedCapacityStackListTest();
	}
	
	/*
	 * 双栈法实现算数表达式的求值问题
	 */
	private static void evaluate(String T){
		FixedCapacityStackArray<String> opt=new FixedCapacityStackArray<>(T.length());
		FixedCapacityStackArray<Double> num=new FixedCapacityStackArray<>(T.length());
		char indexValue;
		String popString;
		for(int i=0;i<T.length();i++){
			indexValue=T.charAt(i);
			if(indexValue=='(');
			else if(indexValue=='+') opt.push("+");
			else if(indexValue=='-') opt.push("-");
			else if(indexValue=='*') opt.push("*");
			else if(indexValue=='/') opt.push("/");
			else if(indexValue==')'){	 
				popString=opt.pop();
				if(popString=="+") num.push(num.pop()+num.pop());
				if(popString=="-") num.push(num.pop()-num.pop());
				if(popString=="*") num.push(num.pop()*num.pop());
				if(popString=="/") num.push(num.pop()/num.pop());
			}else
				num.push(Double.parseDouble(indexValue+""));
		}
		System.out.println("算数表达式的结果为："+num.pop());
	}
	
	/*
	 * 定容站数组实现测试函数
	 * 读取用户输入字符串，存入栈中，若碰到"-"则出栈
	 */
	private static void FixedCapacityStackArrayTest(){
		int num=1;
		//创建定容栈
		FixedCapacityStackArray<String>fcs=new FixedCapacityStackArray<>(num);
		//读入用户输入字符串并存入数组中
		String[] strArray={"it","was","-","the","best","-","of","times","-","-","-","it","was","-","the","-","-"};
		//读取数组中的数据，并根据输入的数据进行响应的操作
		for(int i=0;i<strArray.length;i++){
			if(strArray[i].equals("-")){
				System.out.print(fcs.pop()+" ");
				System.out.println("size:"+fcs.size());
			}else {
				fcs.push(strArray[i]);
			}
		}
		System.out.println();
		//遍历栈
		for(String str:strArray){
			System.out.print(str+" ");
		}
	}
	/*
	 * 链表实现定容栈测试
	 */
	private static void FixedCapacityStackListTest(){
		int num=1;
		//创建定容栈
		FixedCapacityStackList<String>fcs=new FixedCapacityStackList();
		//读入用户输入字符串并存入数组中
		String[] strArray={"it","was","-","the","best","-","of","times","-","-","-","it","was","-","the","-","-"};
		//读取数组中的数据，并根据输入的数据进行响应的操作
		for(int i=0;i<strArray.length;i++){
			if(strArray[i].equals("-")){
				System.out.print(fcs.pop()+" ");
				System.out.println("size:"+fcs.size());
			}else {
				fcs.push(strArray[i]);
			}
		}
		System.out.println();
		//遍历栈
		for(String str:strArray){
			System.out.print(str+" ");
		}
	}
}
