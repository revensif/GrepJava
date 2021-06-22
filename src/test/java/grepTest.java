import SuperMain.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class grepTest {
    void check(String[] args, String result) throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Grep.main(args);
        String value = output.toString();
        Assert.assertEquals(value, result);
    }

    @Test
    public void checkR() throws Exception {
        check(new String[]{"-r", "\s", "test.txt"}, "Это означает, что для передачи символов, вводимых с клавиатуры, приходится нажимать клавишу <Enter>, что приводит к формированию последовательности символов перевода строки и возврата каретки.\r\n" +
                "Эти символы сохраняются во входном буфере вместе с введенными с клавиатуры.\r\n" +
                "Кроме того, если ввести с клавиатуры несколько символов подряд, не нажав клавишу <Enter>, они так и останутся во входном буфере.\r\n" +
                "В рассматриваемом здесь цикле эти Символы отбрасываются до тех пор, пока не будет достигнут конец строки.\r\n" +
                "Если не сделать этого, лишние символы будут передаваться программе в качестве выбранной буквы, что не соответствует действительности.\r\n" +
                "Для того чтобы убедиться в этом, попробуйте закомментировать внутренний цикл do-while в исходном коде программы.\r\n" +
                "После представления ряда других языковых средств Java в главе 10 будут рассмотрены более совершенные способы обработки консольного ввода.\r\n" +
                "Но применение метода read() в данной программе дает элементарное представление о принципе действия системы ввода-вывода в Java.\r\n" +
                "А кроме того, в данной программе демонстрируется еще один пример применения циклов в практике программирования на java.\r\n");
    }

    @Test
    public void checkV() throws Exception {
        check(new String[]{"-v", "символы", "test.txt"}, "string.\r\n" +
                "Это означает, что для передачи символов, вводимых с клавиатуры, приходится нажимать клавишу <Enter>, что приводит к формированию последовательности символов перевода строки и возврата каретки.\r\n" +
                "Кроме того, если ввести с клавиатуры несколько символов подряд, не нажав клавишу <Enter>, они так и останутся во входном буфере.\r\n" +
                "В рассматриваемом здесь цикле эти Символы отбрасываются до тех пор, пока не будет достигнут конец строки.\r\n" +
                "Для того чтобы убедиться в этом, попробуйте закомментировать внутренний цикл do-while в исходном коде программы.\r\n" +
                "После представления ряда других языковых средств Java в главе 10 будут рассмотрены более совершенные способы обработки консольного ввода.\r\n" +
                "Но применение метода read() в данной программе дает элементарное представление о принципе действия системы ввода-вывода в Java.\r\n" +
                "А кроме того, в данной программе демонстрируется еще один пример применения циклов в практике программирования на java.\r\n");
    }

    @Test
    public void checkI() throws Exception {
        check(new String[]{"-i", "ПРоГраМме", "test.txt"}, "Если не сделать этого, лишние символы будут передаваться программе в качестве выбранной буквы, что не соответствует действительности.\r\n" +
                "Но применение метода read() в данной программе дает элементарное представление о принципе действия системы ввода-вывода в Java.\r\n" +
                "А кроме того, в данной программе демонстрируется еще один пример применения циклов в практике программирования на java.\r\n");
    }

    @Test
    public void checkWithout() throws Exception {
        check(new String[]{"символы", "test.txt"}, "Эти символы сохраняются во входном буфере вместе с введенными с клавиатуры.\r\n" +
                "Если не сделать этого, лишние символы будут передаваться программе в качестве выбранной буквы, что не соответствует действительности.\r\n");
    }

    @Test
    public void checkVI() throws Exception {
        check(new String[]{"-v", "-i", "СимВоЛЫ", "test.txt"}, "string.\r\n" +
                "Это означает, что для передачи символов, вводимых с клавиатуры, приходится нажимать клавишу <Enter>, что приводит к формированию последовательности символов перевода строки и возврата каретки.\r\n" +
                "Кроме того, если ввести с клавиатуры несколько символов подряд, не нажав клавишу <Enter>, они так и останутся во входном буфере.\r\n" +
                "Для того чтобы убедиться в этом, попробуйте закомментировать внутренний цикл do-while в исходном коде программы.\r\n" +
                "После представления ряда других языковых средств Java в главе 10 будут рассмотрены более совершенные способы обработки консольного ввода.\r\n" +
                "Но применение метода read() в данной программе дает элементарное представление о принципе действия системы ввода-вывода в Java.\r\n" +
                "А кроме того, в данной программе демонстрируется еще один пример применения циклов в практике программирования на java.\r\n");
    }

    @Test
    public void checkRI() throws Exception {
        check(new String[]{"-r", "-i", "[A-Z]", "test.txt"}, "string.\r\n" +
                "Это означает, что для передачи символов, вводимых с клавиатуры, приходится нажимать клавишу <Enter>, что приводит к формированию последовательности символов перевода строки и возврата каретки.\r\n" +
                "Кроме того, если ввести с клавиатуры несколько символов подряд, не нажав клавишу <Enter>, они так и останутся во входном буфере.\r\n" +
                "Для того чтобы убедиться в этом, попробуйте закомментировать внутренний цикл do-while в исходном коде программы.\r\n" +
                "После представления ряда других языковых средств Java в главе 10 будут рассмотрены более совершенные способы обработки консольного ввода.\r\n" +
                "Но применение метода read() в данной программе дает элементарное представление о принципе действия системы ввода-вывода в Java.\r\n" +
                "А кроме того, в данной программе демонстрируется еще один пример применения циклов в практике программирования на java.\r\n");
    }

    @Test
    public void checkVR() throws Exception {
        check(new String[]{"-v", "-r", "[A-Z]", "test.txt"}, "string.\r\n" +
                "Эти символы сохраняются во входном буфере вместе с введенными с клавиатуры.\r\n" +
                "В рассматриваемом здесь цикле эти Символы отбрасываются до тех пор, пока не будет достигнут конец строки.\r\n" +
                "Если не сделать этого, лишние символы будут передаваться программе в качестве выбранной буквы, что не соответствует действительности.\r\n" +
                "Для того чтобы убедиться в этом, попробуйте закомментировать внутренний цикл do-while в исходном коде программы.\r\n" +
                "А кроме того, в данной программе демонстрируется еще один пример применения циклов в практике программирования на java.\r\n");
    }

    @Test
    public void checkVIR() throws Exception {
        check(new String[]{"-i", "-v", "-r", "[a-z]", "test.txt"}, "Эти символы сохраняются во входном буфере вместе с введенными с клавиатуры.\r\n" +
                "В рассматриваемом здесь цикле эти Символы отбрасываются до тех пор, пока не будет достигнут конец строки.\r\n" +
                "Если не сделать этого, лишние символы будут передаваться программе в качестве выбранной буквы, что не соответствует действительности.\r\n");
    }
}