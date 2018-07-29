import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWordAnalyzer {
    private FilePartReader reader;

    FileWordAnalyzer(FilePartReader reader) {
        this.reader = reader;
    }

    ArrayList wordsByABC() {
        ArrayList<String> resultList = new ArrayList<>();
        String textFromFile = singleStringFromList(reader.readLines());
        Arrays.stream(textFromFile
                .split(" "))
                .sorted()
                .forEach(resultList::add);

        return resultList;
    }

    ArrayList wordsContainingSubstring(String substring) {
        ArrayList<String> resultList = new ArrayList<>();
        String textFromFile = singleStringFromList(reader.readLines());
        Arrays.stream(textFromFile
                .split(" "))
                .filter(s -> s.contains(substring))
                .forEach(resultList::add);

        return resultList;
    }

    ArrayList wordsArePalindrome() {
        ArrayList<String> resultList = new ArrayList<>();
        String textFromFile = singleStringFromList(reader.readLines());
        Arrays.stream(textFromFile
                .split(" "))
                .filter(s -> s.equals(new StringBuilder(s).reverse().toString()))
                .forEach(resultList::add);

        return resultList;

    }

    public String singleStringFromList(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String element: list) {stringBuilder.append(element);}
        return stringBuilder.toString();
    }

    public static void main(String [] args) {

        FilePartReader fpr = new FilePartReader();
        fpr.setup(fpr.FILEPATH, 1, 4);
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
    }

}
