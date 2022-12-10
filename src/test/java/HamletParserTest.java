import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testResult() {
//        System.out.println(hamletText);
        assertEquals(-1, hamletParser.findHamlet(hamletText));
        assertEquals(-1, hamletParser.findHoratio(hamletText));
    }

    @Test
    public void testChangeHamletToLeon1() {
        HamletParser hp = new HamletParser();

        String input = "Hello, my name is Hamlet, you killed my father, prepare to die";
        String expected = "Hello, my name is Leon, you killed my father, prepare to die";
        String actual = hp.changeHamletToLeon(input);

        assertEquals(expected, actual);
    }

    @Test
    public void testChangeHamletToLeon2() {
        HamletParser hp = new HamletParser();

        String input = "Hello, my name is HAMLET, you killed my father, prepare to die";
        String expected = "Hello, my name is LEON, you killed my father, prepare to die";
        String actual = hp.changeHamletToLeon(input);

        assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq1() {
        HamletParser hp = new HamletParser();

        String input = "Hello, my name is Horatio, you killed my father, prepare to die";
        String expected = "Hello, my name is Tariq, you killed my father, prepare to die";
        String actual = hp.changeHoratioToTariq(input);

        assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq2() {
        HamletParser hp = new HamletParser();

        String input = "Hello, my name is HORATIO, you killed my father, prepare to die";
        String expected = "Hello, my name is TARIQ, you killed my father, prepare to die";
        String actual = hp.changeHoratioToTariq(input);

        assertEquals(expected, actual);
    }

    @Test // proper noun case
    public void testFindHoratio1() {
        HamletParser hp = new HamletParser();
        String horatio = "Hello, my name is Horatio, you killed my father, prepare to die";
        String inigo = "Hello, my name is Inigo Montoya, you killed my father, prepare to die";

        assertEquals(1, hp.findHoratio(horatio));
        assertEquals(-1, hp.findHoratio(inigo));
    }

    @Test // all upper case
    public void testFindHoratio2() {
        HamletParser hp = new HamletParser();
        String horatio = "Hello, my name is HORATIO, you killed my father, prepare to die";
        String inigo = "Hello, my name is INIGO Montoya, you killed my father, prepare to die";

        assertEquals(2, hp.findHoratio(horatio));
        assertEquals(-1, hp.findHoratio(inigo));
    }

    @Test // proper noun case
    public void testFindHamlet1() {
        HamletParser hp = new HamletParser();
        String hamlet = "Hello, my name is Hamlet, you killed my father, prepare to die";
        String inigo = "Hello, my name is Inigo Montoya, you killed my father, prepare to die";

        assertEquals(1, hp.findHamlet(hamlet));
        assertEquals(-1, hp.findHamlet(inigo));
    }

    @Test // all upper case
    public void testFindHamlet2() {
        HamletParser hp = new HamletParser();
        String hamlet = "Hello, my name is HAMLET, you killed my father, prepare to die";
        String inigo = "Hello, my name is INIGO Montoya, you killed my father, prepare to die";

        assertEquals(2, hp.findHamlet(hamlet));
        assertEquals(-1, hp.findHamlet(inigo));
    }
}