package JavaAssign;

public class Strong3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num=145;
		
		int rem;
		
		int sum=0;
		int temp=num;
		
		
		while(num!=0)
		{
			rem=num%10;
			
			int fact=1;
			
			num=num/10;
			
			for(int i=1;i<=rem;i++)
			{
				
				fact=fact*i;
				
				
			}
			
			sum=sum+fact;
			
			
		}
	
		System.out.println(sum);
		
		if(sum==temp)
		{
			
			System.out.println("Given Number is Strong Number");
			
			
		}
		
		else
		{
			System.out.println("Given Number is Not Strong Number");
			
		}
		
		
	}

}
