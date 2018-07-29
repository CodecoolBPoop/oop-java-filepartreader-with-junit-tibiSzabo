import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilePartReader {
    private String filePath;
    private int fromLine;
    private int toLine;
    public final String FILEPATH = System.getProperty("user.dir") + "\\testfile.txt";

    FilePartReader(){
        this.filePath = "invalid default value";
        this.fromLine = 0;
        this.toLine = 0;
    }

    public void setup(String filePath, int fromLine, int toLine) {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException("toLine < fromLine or fromLine < 1");
        } else {
            this.filePath = filePath;
            this.fromLine = fromLine;
            this.toLine = toLine;
        }

    }

    public List<String> read() {
        List<String> result = new ArrayList<>();
        String line;
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public List<String> readLines(){
        List<String> fileContent = read();
        List<String> result = new ArrayList<>();

        int idx = fromLine;
        while (toLine - idx != -1) {
            result.add(fileContent.get(idx - 1));
            idx++;
        }
        return result;
    }

}
