//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class UnitTestBook {
//    Book book;
//    double init = 100;
//
//    @BeforeEach
//    void init() {book = new Book(init);}
//
//    @Test
//    void testIncome() {
//        book.receive("earned from work", 100);
//        assertEquals(200, book.getBalance());
//    }
//
//    @Test
//    void testExpense() throws OverExpenseException {
//        book.pay("buy egg", 50);
//        assertEquals(50, book.getBalance());
//    }
//
//    @Test
//    @DisplayName("throws OverExpenseException when expense more than balance")
//    void testExpenseMoreThanBalance() {
//        assertThrows(OverExpenseException.class,
//                () -> book.pay("buy snack", 200));
//        assertEquals(-100, book.getBalance());
//    }
//}