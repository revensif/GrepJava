import junit.framework.TestCase;


public class grepTest extends TestCase {

    public void testCheck() {
        String result = "Нет";
        String line = "Как сегодня хорошо";
        String word = "как";
        String[] words = line.split(" ");
        for (String i : words) {
            if (i.equals(word)) {
                result = "Есть";
                break;
            }
        }
        assertEquals(result, "Нет");
    }

    public void testCheckR() {
        String result = "Нет";
        String line = "Как сегодня хорошо";
        String word = "год";
         if (line.matches("(.*)" + word + "(.*)")) result = "Есть";
        assertEquals(result, "Есть");
    }

    public void testCheckI() {
        String result = "Нет";
        String line = "Как сегодня хорошо";
        String word = "как";
        String[] words = line.split(" ");
        for (String i : words) {
            if (i.equalsIgnoreCase(word)) {
                result = "Есть";
                break;
            }
        }
        assertEquals(result, "Есть");
    }

    public void testCheckIR() {
        String result = "Нет";
        String line = "Как сегодня хорошо";
        String word = "ГОД";
        if (line.toLowerCase().contains(word.toLowerCase())) result = "Есть";
        assertEquals(result, "Есть");
    }
}

