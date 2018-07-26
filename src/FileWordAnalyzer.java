import java.util.ArrayList;
import java.util.Arrays;

public class FileWordAnalyzer {
    private FilePartReader reader;

    FileWordAnalyzer(FilePartReader reader) {
        this.reader = reader;
    }

    public ArrayList wordsByABC() {
        ArrayList<String> resultList = new ArrayList<>();
        String textFromFile = reader.readLines();
        Arrays.stream(textFromFile.split(" "))
                .sorted()
                .forEach(resultList::add);

        return resultList;
    }

    public ArrayList wordsContainingSubstring(String substring) {
        ArrayList<String> resultList = new ArrayList<>();
        String textFromFile = reader.readLines();
        Arrays.stream(textFromFile.split(" "))
                .filter(s -> s.contains(substring))
                .forEach(resultList::add);

        return resultList;
    }

    public ArrayList wordsArePalindrome() {
        ArrayList<String> resultList = new ArrayList<>();
        String textFromFile = reader.readLines();
        Arrays.stream(textFromFile.split(" "))
                .filter(s -> s.equals(new StringBuilder(s).reverse().toString()))
                .forEach(resultList::add);

        return resultList;

    }

}
