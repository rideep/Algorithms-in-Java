import java.util.Scanner;


public class Valleys {

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int n=in.nextInt();
		String s=in.next();
		String S=s.substring(0, n);
		//System.out.print(S);
		int valleys=0;
		int level=0;
		boolean below=false;
		for(int i=0;i<S.length();i++)
		{
			
			if(s.charAt(i)=='U')
				level++;
			else
				level--;
			if(!below && level<0)
			{
				valleys++;
				below=true;
			}
			if(level>=0)
				below=false;
			
		}
		System.out.println(valleys);
	}

}
