package lab_7_set_student;

import java.io.FileNotFoundException;
import java.util.*;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "src/lab_7_set_student/data/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void setWords(List<String> words) {
		this.words = words;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		// TODO
		List<WordCount> result= new ArrayList<>();
		for(String w: words){
			int countWord= count(w);
			WordCount wc= new WordCount(w,countWord);
			if(!result.contains(wc))
				result.add(wc);
		}
		return result;
	}

	private int count(String w) {
		int count=0;
		for (int i=0;i<words.size();i++){
			if(words.get(i).equals(w))
				count++;
		}
		return count;
	}

	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String> result= new HashSet<>();
		List<WordCount> temp= getWordCounts();
		for(WordCount wc: temp){
			if(wc.getCount()==1)
				result.add(wc.getWord());
		}
		return result;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		// TODO
		Set<String> result= new HashSet<>();
		List<WordCount> temp= getWordCounts();
		for(WordCount wc: temp){
			if(wc.getCount()>1)
				result.add(wc.getWord());
		}
		return result;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {
		// TODO
		List<WordCount> temp= getWordCounts();
		Set<WordCount> result= new HashSet<>();
		for(int i=0;i<temp.size();i++){
			result.add(temp.get(i));
		}
		return result;
	}
	// Prints out the number of times each unique token appears in the file
// data/hamlet.txt (or fit.txt) according to ascending order of
	//tokens
// Example: An - 3, Bug - 10, ...
	public Set<WordCount> exportWordCounts() {
		// TODO
		Set<WordCount> result= new TreeSet<>(new Comparator<WordCount>() {
			@Override
			public int compare(WordCount o1, WordCount o2) {
				return o1.getWord().compareTo(o2.getWord());
			}
		});
		result.addAll(getWordCounts());
		return result;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurrences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurrence() {
		// TODO
		Set<WordCount> result= new TreeSet<>(new Comparator<WordCount>() {
			@Override
			public int compare(WordCount o1, WordCount o2) {
				return o2.getWord().compareTo(o1.getWord());
			}
		});
		result.addAll(getWordCounts());

		return result;
	}

	// delete words begining with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<String> filterWords(String pattern) {
		// TODO
		Set<String> result= new HashSet<>();
		for(String w: words){
			if(w.indexOf(pattern)!=0)
				result.add(w);
		}
		return result;
	}


	public static void main(String[] args) {
		MyWordCount test= new MyWordCount();
		System.out.print(Arrays.toString(test.getWordCounts().toArray()));
		System.out.println(Arrays.toString(test.exportWordCountsByOccurrence().toArray()));

	}
}
