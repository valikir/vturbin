import java.util.*;

public class WordCounter implements Runnable {
    public String text;

    public WordCounter(final String text) {
        this.text = text;
    }

    @Override
    public void run() {
        int wordCount = 0;
        for (int e = 0; e < text.length(); e++) {
            if (text.charAt(e) == ' ') {
                wordCount++;
            }
        }
        wordCount++;
        System.out.println("Text has " + wordCount + " words");
    }

    public static class SpaceCounter implements Runnable {
        public String text;

        public SpaceCounter(final String text) {
            this.text = text;
        }

        @Override
        public void run() {
            int spaceCount = 0;
            for (int e = 0; e < text.length(); e++) {
                if (text.charAt(e) == ' ') {
                    spaceCount++;
                }
            }
            System.out.println("Text has " + spaceCount + " spaces");
        }
    }

    public static void main(String[] args) {
        String text = "Создать программу,"
               + " которая будет считать количество слов и пробелов в тексте."
               + " Здесь не надо использовать регулярные выражения."
               + " Просто в цикле перебрать символы.";
        Thread t1 = new Thread(new WordCounter(text));
        Thread t2 = new Thread(new SpaceCounter(text));

        System.out.println("Программа считает количество слов и пробелов в тексте");
        t1.start();
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Программа завершена");
    }
}
