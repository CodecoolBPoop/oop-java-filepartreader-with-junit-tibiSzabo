import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {


    @Test
    void testWordsByABCReturnsCorrectResults() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup(fpr.FILEPATH, 1, 4);
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        assertEquals("[FUFFAF, GODDAMN, HEHEHAHA, IS, MY, SAS, TESTFILE, THIS]", fwa.wordsByABC().toString());
    }

    @Test
    void testwordsContainingSubstringReturnsCorrectResults() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup(fpr.FILEPATH, 1, 4);
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        assertEquals("[HEHEHAHA]", fwa.wordsContainingSubstring("HA").toString());
        assertEquals("[THIS, IS, TESTFILE]", fwa.wordsContainingSubstring("I").toString());
    }

    @Test
    void testwordsArePalindromeReturnsCorrectResults() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup(fpr.FILEPATH, 1, 4);
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        assertEquals("[SAS, FUF, FAF]", fwa.wordsArePalindrome().toString());
    }
}
