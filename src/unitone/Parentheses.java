package unitone;

import stack.FixedCapacityStackArray;

/*
 * �����ŶԽ���ƥ�䣬����ջ��ʹ������
 * ���磬����[()]{}{[()()]()}������ж�Ϊtrue�����ڲ�ƥ������Ŷ�[()}�����false
 * �㷨�����İ棩1.3.4
 */
public class Parentheses {
	private static final char LEFT_PAREN = '(';
	private static final char RIGHT_PAREN = ')';
	private static final char LEFT_BRACE = '{';
	private static final char RIGHT_BRACE = '}';
	private static final char LEFT_BRACKET = '[';
	private static final char RIGHT_BRACKET  = ']';
	
	public static void main(String[] args) {
		char[] T={'[','(',')',']','{','}','{','[','(',')',']','(',')','}' };
		char[] T1={'[',']','{','('};
		System.out.println(pairs(T));
		System.out.println(pairs(T1));
	}
	
	/*
	 * @param char[] str�������飬Ϊ��Ҫ�жϵ����Ŷ�
	 * @param return �жϽ��
	 */
	private static boolean pairs(char[] str){
		FixedCapacityStackArray<Character>item=new FixedCapacityStackArray<>(str.length);
		if(str.length%2!=0)
			return false;
		for(int i=0;i<str.length;i++){
			if (str[i]==LEFT_PAREN||str[i]==LEFT_BRACE||str[i]==LEFT_BRACKET) {
				item.push(str[i]);
			}else {
				if(str[i]==RIGHT_PAREN&&item.pop()!=LEFT_PAREN)
					return false;
				else if(str[i]==RIGHT_BRACE &&item.pop()!=LEFT_BRACE)
					return false;
				else if(str[i]==RIGHT_BRACKET&&item.pop()!=LEFT_BRACKET)
					return false;
			}
		}
		if(!item.isEmpty())
			return false;
		return true;
	}
}
