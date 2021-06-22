package SuperMain;

import java.io.*;
import java.util.regex.Pattern;


public class Grep {

    public static boolean check(String line, String word) {
        String[] words = line.split(" ");
        for (String i : words) {
            if (i.equals(word))
                return true;
        }
        return false;
    }

    public static boolean checkI(String line, String word) {
        String[] words = line.split(" ");
        for (String i : words) {
            if (i.equalsIgnoreCase(word))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean flagR = false, flagV = false, flagI = false;
        if (args.length < 2) {
            System.out.println("В консоли нет аргументов\r\n" +
                    "Пример ввода: [-r] [-v] [-i] word filename.txt\r\n" +
                    "Первые три опции не обязательные, поэтому минимум элементов это 2\r\n" +
                    "Этими элементами являются слово и название файла\r\n" +
                    "Перед ними могут идти три опции, функции которых написаны ниже\r\n" +
                    "Опция [-r] - вместо слова ищет регулярное выражение\r\n" +
                    "Опция [-v] - инвертирует условие фильтрации(выводит всё что не соответствует)\r\n" +
                    "Опция [-i] - игнорирует регистр слов");
            System.exit(1);
        }
        for (int i = 0; i < args.length - 2; i++) {
            switch (args[i]) {
                case "-r" -> flagR = true;
                case "-v" -> flagV = true;
                case "-i" -> flagI = true;
                default -> {
                    System.out.println("Неизвестный ключ: " + args[i]);
                    System.exit(1);
                }
            }
        }
        Pattern pattern = Pattern.compile("(?iU)", Pattern.CASE_INSENSITIVE + Pattern.UNICODE_CASE);
        String inputName = args[args.length - 1];
        String word = args[args.length - 2];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputName));
            String line;
            while ((line = reader.readLine()) != null) {
                if (flagR) {
                    final boolean matches = line.matches(pattern + "(.*)" + word + "(.*)");
                    if (flagV) {
                        if (flagI) {
                            if (!matches)
                                System.out.println(line);
                        } else {
                            if (!line.matches("(.*)" + word + "(.*)"))
                                System.out.println(line);
                        }
                    } else {
                        if (flagI) {
                            if (matches)
                                System.out.println(line);
                        } else {
                            if (line.matches("(.*)" + word + "(.*)"))
                                System.out.println(line);
                        }
                    }
                } else {
                    if (flagV) {
                        if (flagI) {
                            if (!Grep.checkI(line, word))
                                System.out.println(line);
                        } else {
                            if (!Grep.check(line, word))
                                System.out.println(line);
                        }
                    } else {
                        if (flagI) {
                            if (Grep.checkI(line, word))
                                System.out.println(line);
                        } else {
                            if (Grep.check(line, word))
                                System.out.println(line);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Данного файла не существует");
        }
    }
}

