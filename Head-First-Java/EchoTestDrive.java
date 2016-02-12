public class EchoTestDrive{
	public static void main(String... arg){
		Echo e1 = new Echo();
		Echo e2 = new Echo();

		int x = 0;
		while(x < 4){
			e1.hello();

			e1.count = e1.count + 1;	// 1 2 3 4 

			if(x == 3){
				e2.count = e2.count + 1;
			}

			if(x > 0){		
				e2.count = e2.count + e1.count;
			}

			System.out.println("X " + x + " E1.count " + e1.count + " E2.count " + e2.count);
			x = x + 1;
		}

		System.out.println("E2's count is : " + e2.count);
	}
}

class Echo{
	int count = 0;

	void hello(){
		System.out.println("Hello .....");
	}
}