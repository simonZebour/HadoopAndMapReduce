package cs.Lab2.tfidf;

import java.util.Comparator;

public class wordTfIdfComparator implements Comparator<wordTfIdf>{
	
    public int compare(wordTfIdf word1, wordTfIdf word2) {
        return Double.compare(word1.getTfidf(),word2.getTfidf());
        }
}
