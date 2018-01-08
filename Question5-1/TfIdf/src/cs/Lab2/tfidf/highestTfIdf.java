package cs.Lab2.tfidf;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

public class highestTfIdf {

		public static void main(String[] args) throws IOException {
			
			String localSrc = "outputJob3/part-r-00000";
			//Open the file
			Configuration conf = new Configuration();
			FileSystem fs = FileSystem.get(conf);
			InputStream in = new BufferedInputStream(new FileInputStream(localSrc));
			
			//Create List
			ArrayList<wordTfIdf> WordsFinalList = new ArrayList<wordTfIdf>();
			wordTfIdf wordtfidf = new wordTfIdf();
			String word = new String();


				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader br = new BufferedReader(isr);
				
				// read line by line
				String line = br.readLine();
			
				while (line !=null){
					// Process of the current line
					//split
					String[] wordAndTfIdf = line.split("\t");
					word = wordAndTfIdf[0];
					Double tfIdf = Double.parseDouble(wordAndTfIdf[1]);
					//System.out.print(word + " : " + tfIdf + "\n");
					//Word
					wordtfidf.setWord(word);
					wordtfidf.setTfidf(tfIdf);
					//Put in the Array
					WordsFinalList.add(0, wordtfidf);;
					//SortList
					Collections.sort(WordsFinalList, new wordTfIdfComparator());
					// go to the next line
					line = br.readLine();
				}
				for(wordTfIdf w : WordsFinalList) {
					System.out.print(w.getWord()+ " : " + w.getTfidf() + "\n");
				}
			}	
		}

