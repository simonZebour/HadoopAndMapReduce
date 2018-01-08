package cs.bigdata.Tutorial2;

import cs.bigdata.Tutorial2.Tree;
import java.io.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;



public class Main {

	public static void main(String[] args) throws IOException {
		
		if (args.length != 1) {
			System.out.println("Il faut passer hdfs/path/to/arbres.csv en argument (ex : /user/cloudera/arbres.csv)");
			System.exit(-1);
		}

		//Open the file

		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		String uri = conf.get("fs.defaultFS"); // we get the hdfs full path (ex : "hdfs://quickstart.cloudera:8020")
		Path pt = new Path(uri + args[0]); // pt is the full path to our file in hdfs
		InputStream in = new BufferedInputStream(fs.open(pt));
		
		try{
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			
			// read line by line
			String line = br.readLine();
			line = br.readLine(); // we don't read the header

			while (line !=null){
				// Process of the current line
				// We use the methods of the class Tree to display the year and the height of each tree, without instanciating one
				System.out.println("Year : " + Tree.year(line) + "  height : " + Tree.height(line));
				// go to the next line
				line = br.readLine();
			}
		}
		finally{
			//close the file
			in.close();
			fs.close();
		}
 
		
		
	}

}
