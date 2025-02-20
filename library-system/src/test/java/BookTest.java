import com.example.Book;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {
    
    @Test 
    public void testISBN() {
        Book b = new Book("", "", "0", "306", "40615");
        assertEquals(b.isbn, "030640615-2");
        b = new Book("", "", "0", "439", "02348");
        assertEquals(b.isbn, "043902348-3");
        b = new Book("", "", "1", "86197", "271");
        assertEquals(b.isbn, "186197271-7");
    }

    @Test
    public void testGenerateCheckDigit() {
        Book b = new Book("", "", "0", "306", "40615");
        assertEquals(b.generateCheckDigit("0", "306", "40615"), "2");
        assertEquals(b.generateCheckDigit("0", "439", "02348"), "3");
        assertEquals(b.generateCheckDigit("1", "86197", "271"), "7");
    }
}
