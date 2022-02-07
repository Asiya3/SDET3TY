package JavaAssign;

public class Reverse2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int num=146;
	      
         int rem;
         int rev=0;
         int temp=num;
         
         while(num!=0)
         {
        	 rem=num%10;
        	 rev=rev*10+rem;
        	 num=num/10;
        	 
         }
		
		System.out.println(rev);
		
	}

}
