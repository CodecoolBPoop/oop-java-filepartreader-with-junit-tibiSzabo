import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilePartReader {
    private String filePath;
    private int fromLine;
    private int toLine;

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

    public List<String> read(String filePath) {
        List<String> result = new ArrayList<>();
        String line;
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                line += " ";
                result.add(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public String readLines(){
        List<String> fileContent = read(filePath);
        StringBuilder result = new StringBuilder("");
        int idx = fromLine;
        while (toLine - idx != -1) {
            result.append(fileContent.get(idx - 1));
            idx++;
        }
        return result.toString();
    }

}
