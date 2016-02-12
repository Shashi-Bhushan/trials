public class DefaultValues{
	public static void main(String... arg){
		DefaultValuesModel model = new DefaultValuesModel();

		System.out.println("Default Char is : " + model.defaultChar);
		System.out.println("Default Char is : " + (int)model.defaultChar);

		System.out.println("Is char equals Long: "  + (model.defaultChar == model.defaultLong));

		model.defaultChar = 35;
		System.out.println("Char is : " + model.defaultChar);
	}
}

class DefaultValuesModel{
	char defaultChar;
	byte defaultByte;
	short defaultShort;
	int defaultInt;
	long defaultLong;
	float defaultFloat;
	double defaultDouble;
	boolean defaultBoolean;
	Object defaultObject;
}