package stack;


public class Main {

	public static void main(String[] args) {
		//˫ջ��ʵ���������ʽ����ֵ����
		evaluate("(1+((2*3)*(4*5)))");
		//����ջ���� ʵ�ֲ��Ժ���
		FixedCapacityStackArrayTest();
		System.out.println();
		//����ջ����ʵ�ֲ��Ժ���
		FixedCapacityStackListTest();
	}
	
	/*
	 * ˫ջ��ʵ���������ʽ����ֵ����
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
		System.out.println("�������ʽ�Ľ��Ϊ��"+num.pop());
	}
	
	/*
	 * ����վ����ʵ�ֲ��Ժ���
	 * ��ȡ�û������ַ���������ջ�У�������"-"���ջ
	 */
	private static void FixedCapacityStackArrayTest(){
		int num=1;
		//��������ջ
		FixedCapacityStackArray<String>fcs=new FixedCapacityStackArray<>(num);
		//�����û������ַ���������������
		String[] strArray={"it","was","-","the","best","-","of","times","-","-","-","it","was","-","the","-","-"};
		//��ȡ�����е����ݣ���������������ݽ�����Ӧ�Ĳ���
		for(int i=0;i<strArray.length;i++){
			if(strArray[i].equals("-")){
				System.out.print(fcs.pop()+" ");
				System.out.println("size:"+fcs.size());
			}else {
				fcs.push(strArray[i]);
			}
		}
		System.out.println();
		//����ջ
		for(String str:strArray){
			System.out.print(str+" ");
		}
	}
	/*
	 * ����ʵ�ֶ���ջ����
	 */
	private static void FixedCapacityStackListTest(){
		int num=1;
		//��������ջ
		FixedCapacityStackList<String>fcs=new FixedCapacityStackList();
		//�����û������ַ���������������
		String[] strArray={"it","was","-","the","best","-","of","times","-","-","-","it","was","-","the","-","-"};
		//��ȡ�����е����ݣ���������������ݽ�����Ӧ�Ĳ���
		for(int i=0;i<strArray.length;i++){
			if(strArray[i].equals("-")){
				System.out.print(fcs.pop()+" ");
				System.out.println("size:"+fcs.size());
			}else {
				fcs.push(strArray[i]);
			}
		}
		System.out.println();
		//����ջ
		for(String str:strArray){
			System.out.print(str+" ");
		}
	}
}
