package study.entity;

public class main {

	public static void main(String[] args) {
		int a=4,b=6, c=8;
		
		try {
			System.out.println("A");
			throw new NullPointerException ("Hello");
		} catch (ArithmeticException e) {
			System.out.println("B");
		}
	}	
		
	/*	String s1 = new String("cdac");
		String s2 = new String("acts");
		System.out.println(s1==s2);*/
		
		
		/*for(int i=1; i<=6; i++)
		{
			if(i%3 == 0)
				continue;
			
			System.out.println(i+" ");
		}*/
	}

