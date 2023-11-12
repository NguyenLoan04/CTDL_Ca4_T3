package lab_8_Map;

import lab_7_set_student.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "src/lab_8_Map/data/fit.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();

	public MyWordCountApp() throws FileNotFoundException {
		this.loadData();
	}

	// Load data from fileName into the above map (containing <word, its occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() throws FileNotFoundException {
		Scanner input= new Scanner(new File(fileName));
		while(input.hasNext()){
			String key= input.next();
//			if(!map.containsKey(key))
//				map.put(key,1);
//			else
//				map.put(key,map.get(key)+1);
			map.put(key,map.getOrDefault(key,0)+1); // method có sẵn kiểm tra key xuất hiện
		}
	}
	// Returns the number of Key unique in file
	public int countDistinct(){
		return map.size();
	}

	// Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
	public int countUnique() {
		// TODO
		return 0;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		// TODO
		Collection<Integer> results= map.values();
		System.out.print(Arrays.toString(results.toArray()));
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		// TODO
		Map<String,Integer> result= new TreeMap<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		result.putAll(map); // cho phần tử map vào TreeMap
		System.out.print(Arrays.toString(result.entrySet().toArray()));
	}
}
