public class ClassTest{

	public static void main(String... arg){
		Class classDemo = DemoClass.class;

		Class classDemoAnotherInstance = DemoClass.class;

		areTwoClassesEqual(classDemo, classDemoAnotherInstance);

		Class runtimeInstance = null;
		try {
			runtimeInstance = Class.forName("DemoClass");
		}catch(ClassNotFoundException cause){
			
		}

		areTwoClassesEqual(runtimeInstance, classDemo);
	}

	private static void areTwoClassesEqual(Class first, Class second){
		System.out.println("Comparing Classes | one : " + first.getName() + " | Second : " + second.getName());

		System.out.println("Equal : " + (first == second));
	}
}

class DemoClass{
	private String str;
}