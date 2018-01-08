package cs.bigdata.Tutorial2;

public class Station {

	public static String usaf(String line) {
		return line.substring(0, 6);
	}

	
	public static String name(String line) {
		return line.substring(13, 42);
	}

	
	public static String countryID(String line) {
		return line.substring(43, 45);
	}

	
	public static String elevation(String line) {
		return line.substring(74, 81);
	}

}
