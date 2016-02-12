public class ArrayClass{
	public static void main(String... arg){
		int[] arr = new int[7];

		System.out.println("Array is: " + arr);
		System.out.println("Array Class is: " + arr.getClass());
		System.out.println("Array Class Name is: " + arr.getClass().getName());


		Integer[] arrIntObject = new Integer[1];
		System.out.println("Array is: " + arrIntObject);
		System.out.println("Array Class is: " + arrIntObject.getClass());
		System.out.println("Array Class Name is: " + arrIntObject.getClass().getName());

		Object ob = new Object();
		System.out.println("Array is: " + ob);
		System.out.println("Array Class is: " + ob.getClass());
		System.out.println("Array Class Name is: " + ob.getClass().getName());

		int x = 0;
		System.out.println("X : " + (int.class == java.lang.Integer.TYPE));
	}
}