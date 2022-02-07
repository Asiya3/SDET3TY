package JavaAssign;

public class Prime5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num=100;
		
		for(int i=2;i<=num;i++)
		{
			int count=0;
			
			for(int j=2;j<=i/2;j++)
			{
				if(i%j==0)
				{
					count++;
				}
				
				
			}
			if(count==0)
			{
				System.out.println(i);
			}
			
			
		}
		
		

	}

}
