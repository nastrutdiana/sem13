package ro.ase.cts.unitestslab.tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.*;
import ro.ase.cts.unitestslab.Calculator;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.Date;

public class CalculatorTests {
    private Calculator calculator;
    private static FileWriter resultsFile;
    private static int passedTests = 0;

    @BeforeClass
    public static void globalSetUp() throws Exception {
        resultsFile = new FileWriter(Instant.now().getEpochSecond() + "-results.txt");
        System.out.println("Fisierul este pregatit pentru scriere.");
    }

    @Before
    public void setUp() throws Exception {
        calculator = Calculator.getInstance();
    }
    @Test
    public void testSingleton()
    {
        Calculator calculatorTest = Calculator.getInstance();
        assertSame("Singleton nu este implementat corect.", calculator, calculatorTest);
        passedTests++;
    }

    @Test
    public void testAdd() {
        assertEquals("Adunare zerouri.",0,  calculator.add(0,0), 0);
        assertEquals("Adunare numere naturale.", 100, calculator.add(51,49), 0);
        assertEquals("Adunare valori reale.", 100.333, calculator.add(51.111,49.223), 0.01);
        passedTests++;
    }

    @Test
    public void testMultiply() {
        assertEquals("Multiplicare intregi.", calculator.multiply(4,5), 20, 0.1);
        assertEquals("Multiplicare numere reale.", calculator.multiply(4.99,55.22), 275.5, 0.1);
        assertEquals("Test inmultire cu 0.",0,  calculator.multiply(0,5), 0);
        assertEquals("Testare comutativitate inmultire cu 0.", 0, calculator.multiply(5,0), 0);
        passedTests++;
    }

    @Test
    public void testDivide() throws Exception {
        assertEquals("Impartirea lui 0.",0,  calculator.divide(0,11), 0);
        assertEquals("Impartire numere naturale.", 12.5, calculator.divide(25,2), 0);
        assertEquals("Impartire numere reale.", 1.038, calculator.divide(51.111,49.223), 0.001);
        passedTests++;
    }

    @Test(expected = Exception.class)
    public void testDivideToZero() throws Exception {
        calculator.divide(123, 0);
        passedTests++;
    }

    @Test
    public void testFileContentRead() throws Exception {
        String filepath = "testfile.txt";
        String content = Files.readString(Path.of(filepath));

        assertEquals("Citirea din fisier nu s-a realizat corect.", content,  calculator.getAResultsFile(filepath));
        passedTests++;
    }
    @AfterClass
    public static void globalCleanUp() throws Exception {
        resultsFile.write("" + passedTests);
        resultsFile.close();
        System.out.println("Fisier inchis cu succes.");
    }
}
