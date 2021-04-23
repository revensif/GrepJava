import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class grep {

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

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.print("input line:");
        String line = in.nextLine();
        boolean flagR = false, flagV = false, flagI = false;
        if (!line.matches("(.*)\\.txt(.*)")) {
            System.out.println("Вы не ввели название файла.");
            line = in.nextLine();
        }
        String inputName = line.substring(line.lastIndexOf(" ") + 1);
        BufferedReader reader = new BufferedReader(new FileReader(inputName));
        try {
            reader = new BufferedReader(new FileReader(inputName));
        } catch (IOException e) {
            System.out.println("Данного файла не существует");
        }
        if (line.matches("(.*)\\[-r\\](.*)")) flagR = true;
        if (line.matches("(.*)\\[-v\\](.*)")) flagV = true;
        if (line.matches("(.*)\\[-i\\](.*)")) flagI = true;
        String word = "";

        if (flagI | flagR | flagV) {
            try {
                word = line.substring(line.lastIndexOf("]") + 2, line.lastIndexOf(" "));
            } catch (Exception e) {
                System.out.println("Вы не ввели слово");
            }
        } else {
            try {
                word = line.substring(0, line.lastIndexOf(" "));
            } catch (Exception e) {
                System.out.println("Вы не ввели слово");
            }
        }
        try {
            while ((line = reader.readLine()) != null) {
                if (flagR) {
                    if (flagV) {
                        if (flagI) {
                            if (!line.matches("(.*)(?i)" + word + "(.*)"))
                                System.out.println(line);
                        } else {
                            if (!line.matches("(.*)" + word + "(.*)"))
                                System.out.println(line);
                        }
                    } else {
                        if (flagI) {
                            if (line.matches("(.*)(?i)" + word + "(.*)"))
                                System.out.println(line);
                        } else {
                            if (line.matches("(.*)" + word + "(.*)"))
                                System.out.println(line);
                        }
                    }
                } else {
                    if (flagV) {
                        if (flagI) {
                            if (!grep.checkI(line, word))
                                System.out.println(line);
                        } else {
                            if (!grep.check(line, word))
                                System.out.println(line);
                        }
                    } else {
                        if (flagI) {
                            if (grep.checkI(line, word))
                                System.out.println(line);
                        } else {
                            if (grep.check(line, word))
                                System.out.println(line);
                        }
                    }
                }
            }
        } catch (
                IOException e) {
        }
    }
}
