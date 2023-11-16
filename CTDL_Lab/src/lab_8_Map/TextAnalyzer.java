package lab_8_Map;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextAnalyzer {
    // <word, its positions>
    private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

    public TextAnalyzer(String fileName) throws IOException {
        this.load(fileName);
    }

    // load words in the text file given by fileName and store into map by using add
    // method in Task 2.1.
    // Using BufferedReader reffered in file TextFileUtils.java
    public void load(String fileName) throws IOException {
        // TODO
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = null;
        int index = 1;
        while (true) {
            line = reader.readLine(); // đọc từng dòng

            if (line == null)
                break; // dừng nếu hết dữ liệu
            StringTokenizer tokens = new StringTokenizer(line, " "); // tách từng từ trong line

            while (tokens.hasMoreTokens()) {
                String word = tokens.nextToken();
                if (!tokens.hasMoreTokens()) { // kiểm tra xem từ đó có ở cuối hàng hay không
                    add(word, -index);
                    index++;
                } else {
                    add(word, index++); // tăng index
                }
            }
        }
        reader.close();

    }
    // In the following method, if the word is not in the map, then adding that word
    // to the map containing the position of the word in the file. If the word is
    // already in the map, then its word position is added to the list of word
    // positions for this word.
    // Remember to negate the word position if the word is at the end of a line in
    // the text file

    public void add(String word, int position) {
        // TODO
        if (map.containsKey(word)) {
            map.get(word).add(position);
        }
        else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(position);
            map.put(word, list);
        }
    }

    // This method should display the words of the text file along with the
    // positions of each word, one word per line, in alphabetical order
    public void displayWords() {
        // TODO
        Map<String, ArrayList<Integer>> result = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        result.putAll(map);
        System.out.println(Arrays.toString(result.entrySet().toArray()));
    }

    // This method will display the content of the text file stored in the map
    public void displayText() {
        // TODO
        Set<String> setKey = map.keySet();
        List<Integer> listPos = new ArrayList<>();
        List<String> listString = new ArrayList<>();
        for (String key : setKey) {
            listPos.addAll(map.get(key));
            for (Integer temp : map.get(key)) {
                listString.add(key);
            }
        }
        int index = 0;
        for (String s : listString) {
            index++;
            if (!listPos.contains(index)) {
                System.out.print(listString.get(listPos.indexOf(-index)) + " ");
                System.out.println();
            } else System.out.print(listString.get(listPos.indexOf(index)) + " ");
        }
    }

    // This method will return the word that occurs most frequently in the text file
    public String mostFrequentWord() {
        // TODO
        Set<String> keys = map.keySet();
        int max = 0;
        String re = "";
        for (String word : keys) {
            int temp = map.get(word).size();
            if (temp > max) {
                max = temp;
                re = word;
            }
        }
        return re;
    }

    public String listValue() {
        return Arrays.toString(map.values().toArray());
    }

    public static void main(String[] args) throws IOException {
        TextAnalyzer test = new TextAnalyzer("src/lab_8_Map/data/short.txt");
//		test.displayWords();
        test.displayText();
    }
}
