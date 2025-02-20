import com.example.Book;
import com.example.Library;

import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {


    @Test
    public void testAddBook() {
        Library l = new Library();
        Book b = new Book("", "", "0", "306", "40615");
        l.add(b);

        assertTrue(l.books.contains(b));
    }

    @Test
    public void testAddMultipleBooks() {
        Library l = new Library();

        Book b1 = new Book("", "", "0", "439", "02348");
        Book b2 = new Book("", "", "0", "306", "40615");
        Book b3 = new Book("", "", "1", "86197", "271");

        l.add(b1);
        l.add(b2);
        l.add(b3);

        assertTrue(l.books.contains(b1));
        assertTrue(l.books.contains(b2));
        assertTrue(l.books.contains(b3));
    }

    @Test
    public void testAddNull() {
        Library l = new Library();
        l.add(null);
        assertTrue(l.books.isEmpty());
    }

    @Test
    public void testRemoveBook() {
        Library l = new Library();

        Book b1 = new Book("", "", "0", "439", "02348");
        Book b2 = new Book("", "", "0", "306", "40615");
        Book b3 = new Book("", "", "1", "86197", "271");

        l.add(b1);
        l.add(b2);
        l.add(b3);

        l.remove(b1);

        assertTrue(l.books.contains(b2));
        assertTrue(l.books.contains(b3));
        assertFalse(l.books.contains(b1));
    }

    @Test
    public void testRemoveMultipleBooks() {
        Library l = new Library();

        Book b1 = new Book("", "", "0", "439", "02348");
        Book b2 = new Book("", "", "0", "306", "40615");
        Book b3 = new Book("", "", "1", "86197", "271");

        l.add(b1);
        l.add(b2);
        l.add(b3);

        l.remove(b1);
        l.remove(b2);

        assertTrue(l.books.contains(b3));
        assertFalse(l.books.contains(b2));
        assertFalse(l.books.contains(b1));
    }

    @Test
    public void testRemoveAllBooks() {
        Library l = new Library();

        Book b1 = new Book("", "", "0", "439", "02348");
        Book b2 = new Book("", "", "0", "306", "40615");
        Book b3 = new Book("", "", "1", "86197", "271");

        l.add(b1);
        l.add(b2);
        l.add(b3);

        l.remove(b1);
        l.remove(b2);
        l.remove(b3);

        assertFalse(l.books.contains(b1));
        assertFalse(l.books.contains(b2));
        assertFalse(l.books.contains(b3));
        assertTrue(l.books.isEmpty());
    }

    @Test
    public void testTakeBook() {
        Library l = new Library();

        Book b1 = new Book("", "", "0", "439", "02348");
        Book b2 = new Book("", "", "0", "306", "40615");
        Book b3 = new Book("", "", "1", "86197", "271");

        l.add(b1);
        l.add(b2);
        l.add(b3);

        Book t = l.take(b1.isbn);

        assertTrue(l.books.contains(b2));
        assertTrue(l.books.contains(b3));
        assertFalse(l.books.contains(b1));

        assertEquals(b1, t);
    }

    @Test
    public void testTakeMultipleBooks() {
        Library l = new Library();

        Book b1 = new Book("", "", "0", "439", "02348");
        Book b2 = new Book("", "", "0", "306", "40615");
        Book b3 = new Book("", "", "1", "86197", "271");

        l.add(b1);
        l.add(b2);
        l.add(b3);

        Book t1 = l.take(b1.isbn);
        Book t2 = l.take(b2.isbn);

        assertTrue(l.books.contains(b3));
        assertFalse(l.books.contains(b2));
        assertFalse(l.books.contains(b1));

        assertEquals(t1, b1);
        assertEquals(t2, b2);
    }

    @Test
    public void testTakeAllBooks() {
        Library l = new Library();

        Book b1 = new Book("", "", "0", "439", "02348");
        Book b2 = new Book("", "", "0", "306", "40615");
        Book b3 = new Book("", "", "1", "86197", "271");

        l.add(b1);
        l.add(b2);
        l.add(b3);

        Book t1 = l.take(b1.isbn);
        Book t2 = l.take(b2.isbn);
        Book t3 = l.take(b3.isbn);

        assertFalse(l.books.contains(b1));
        assertFalse(l.books.contains(b2));
        assertFalse(l.books.contains(b3));

        assertEquals(t1, b1);
        assertEquals(t2, b2);
        assertEquals(t3, b3);

        assertTrue(l.books.isEmpty());
    }
}
