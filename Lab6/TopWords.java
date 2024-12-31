import java.io.*;
import java.util.*;
//import java.util.stream.Collectors;

public class TopWords {
    public static void main(String[] args) {
        String fileName = "popwords.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            Map<String, Integer> wordCounts = new HashMap<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }
            }
            wordCounts.entrySet()
                      .stream()
                      .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                      .limit(10)
                      .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        } catch (IOException e) {
            System.out.println("Can't read file" + e.getMessage());
        }
    }
}
