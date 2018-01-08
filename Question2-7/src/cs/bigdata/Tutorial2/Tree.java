package cs.bigdata.Tutorial2;

public class Tree {

	public static String year(String line) {
		int idx;
		for (byte i = 1 ; i <= 5 ; i++) {
			idx = line.indexOf(';');
			line = line.substring(idx+1, line.length());
		}
		idx = line.indexOf(';');
		if (idx==0)
			return "????" ;
		else
			return line.substring(0, idx);
	}

	public static String height(String line) {
		int idx;
                for (byte i = 1 ; i <= 6 ; i++) {
                        idx = line.indexOf(';');
                        line = line.substring(idx+1, line.length());
                }
		idx = line.indexOf(';');
		if (idx==0)
                        return "?";
                else
			return line.substring(0,idx);
	}

}
