package SuperMain;

import java.io.*;


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
            System.out.println("В консоли нет аргументов");
            System.exit(0);
        }
        String string = String.join(" ", args);
         if (!string.matches("(-r)?\s?(-v)?\s?(-i)?\s?(.)+\s(.)+")) {
             System.out.println("Неправильный ввод: [-r] [-v] [-i] word filename.txt\r\n" +
                     "Опции записываются в таком порядке, как показано на примере выше\r\n" +
                     "Далее перечислены через пробел слово, которое нужно найти и название файла");
             System.exit(0);
         }
        for (String words : args) {
            switch (words) {
                case "-r" -> flagR = true;
                case "-v" -> flagV = true;
                case "-i" -> flagI = true;
            }
        }
        String inputName = args[args.length - 1];
        String word = args[args.length - 2];
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(inputName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String line;
            while ((line = reader != null ? reader.readLine() : null) != null) {
                if (flagR) {
                    final boolean matches = line.toLowerCase().matches("(.*)" + word.toLowerCase() + "(.*)");
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
        } catch (
                IOException e) {
        }
    }
}

