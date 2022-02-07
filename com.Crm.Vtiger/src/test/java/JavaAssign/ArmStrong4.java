package JavaAssign;

public class ArmStrong4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num=15;
		int rem;
		int sum=0;
		int temp=num;
		while(num!=0)
		{
			rem=num%10;
			
			num=num/10;
			
			sum=sum+(rem*rem*rem);
			
		}
		
		System.out.println(sum);
		
		
		if(sum==temp)
		{
			System.out.println("Given Number is ArmStrong Number");
		}
		else
		{
			System.out.println("Given Number is Not ArmStrong Number");
		}
		

	}

}
