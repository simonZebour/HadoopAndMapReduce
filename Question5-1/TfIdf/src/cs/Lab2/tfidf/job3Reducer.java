package cs.Lab2.tfidf;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class job3Reducer extends Reducer<Text, Text, Text, Text> {

    public job3Reducer() {
    }
 // Reducer input : (word , docId>WordCount/WordPerDoc)
    
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        // Number Of doc in the corpus 
        int numberOfDocuments = 2;
        // Doc per words
        int docsPerWord = 0;
        // Create a tab to save docId, wordcount and wordsPerDoc while iterating to find the docPerWords 
        Map<String, String> docAndWordcountWordperdocTab = new HashMap<String, String>();
        for (Text docWordcountWordperdoc : values) {
        	docsPerWord++;
            String[] docAndWordcountWordperdoc = docWordcountWordperdoc.toString().split(">");
            String doc = docAndWordcountWordperdoc[0];
            String WordcountWordperdoc = docAndWordcountWordperdoc[1];
            docAndWordcountWordperdocTab.put(doc, WordcountWordperdoc);
        }
        for (String doc : docAndWordcountWordperdocTab.keySet()) {
        	
            String[] WordcountAndWordperdoc = docAndWordcountWordperdocTab.get(doc).split("/");
            String Wordcount = WordcountAndWordperdoc[0];
            String Wordsperdoc = WordcountAndWordperdoc[1];

            //Compute TermFrequency = wordCount/WordsPerDoc
            double tf = Double.valueOf(Double.valueOf(Wordcount)
                    / Double.valueOf(Wordsperdoc));

            //Compute InverseDocumentFrequency = numberOfDocuments/docsPerWord
            double idf = (double) numberOfDocuments / (double) docsPerWord;

            //given that log(10) = 0, just consider the term frequency in documents
            double tfIdf = tf * Math.log10(idf);
            String tfidf = String.valueOf(tfIdf);

            context.write(new Text(key + "#" + doc), new Text(tfidf));
        }
    }
}
//Reducer3 output : (word@doc, TFIDF)