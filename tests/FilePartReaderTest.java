import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FilePartReaderTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @Test
    void testIsToLineBiggerThanFromLineThrowsException() {
        FilePartReader fpr = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> fpr.setup(fpr.FILEPATH, 3, 2));
        assertThrows(IllegalArgumentException.class, () -> fpr.setup(fpr.FILEPATH, 0, 2));
        assertThrows(IllegalArgumentException.class, () -> fpr.setup(fpr.FILEPATH, -40, 2));
    }

    @Test
    void testReadMethodFileNotFoundCatchesException() { //!!!!!
        FilePartReader fpr = new FilePartReader();
        fpr.setup(fpr.FILEPATH+ "a", 1, 2);
        assertThrows(java.io.FileNotFoundException.class, fpr::read);
    }

    @Test
    void testReadReturnsCorrectResult() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup(fpr.FILEPATH, 1, 2);
        assertEquals("[THIS IS MY GODDAMN TEST, FILE SAS FUF, FAF HEHE, HAHA]", fpr.read().toString());
    }

    @Test
    void testReadLinesReturnsCorrectResult() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup(fpr.FILEPATH, 1, 2);
        assertEquals("[THIS IS MY GODDAMN TEST, FILE SAS FUF]", fpr.readLines().toString());
        fpr.setup(fpr.FILEPATH, 2, 3);
        assertEquals("[FILE SAS FUF, FAF HEHE]", fpr.readLines().toString());
        fpr.setup(fpr.FILEPATH, 1, 1);
        assertEquals("[THIS IS MY GODDAMN TEST]", fpr.readLines().toString());
    }
}