package Synchronize;

import net.jcip.annotations.ThreadSafe;

import java.io.*;
import java.util.*;

@ThreadSafe
public class ParallelSearch implements Runnable {
    String root;
    String text;
    List<String> exts;
    final File directory;
    List<String> foundfiles = new LinkedList<>();
    List<File> subdirs = new LinkedList<>();


    public ParallelSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
        this.directory = new File(root);
        // root - путь до папки откуда надо осуществлять поиск.
        // text - заданных текст.
        // exts - расширения файлов в которых нужно делать поиск.
    }

    synchronized private List<File> getAllSubDir() {
        synchronized (subdirs) {
            getSubDirectiories(directory);
            int i = 0;
            while (i < subdirs.size()) {
                File file = subdirs.get(i);
                getSubDirectiories(file);
                i++;
                //System.out.println(subdirs);
            }
            subdirs.add(directory);
            return subdirs;
        }
    }

    synchronized private List<File> getSubDirectiories(File file) {
        String[] names = file.list();
        if (names == null) {
            return subdirs;
        }
        for (String name : names) {
            File f = new File(file + "/" + name);
            if (f.isDirectory()) {
                subdirs.add(f);
            }
        }
        return subdirs;
    }


    private String getFileExtension(String name) {
        try {
            return name.substring(name.lastIndexOf("."));
        } catch (Exception e) {
            return "";
        }
    }

    // BrowseText пробегает по файлу с заданным расширением (.docx, .txt) и сверяет текст в файле с заданным текстом
    private File BrowseText(File file) {
        for (String s : exts) {
            if (getFileExtension(file.getName()).equals(s)) {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = br.readLine()) != null) {
                        if (line.contains(text)) {
                            return file;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    // result() пробегает по всем файлам из всех подпапок и сохраняет файлы с содержащим(заданным) текстом в листе foundfiles
    public List<String> result() {
        synchronized (subdirs) {
            int j = 0;
            while (j < subdirs.size()) {
                File f = subdirs.get(j);
                String[] names = f.list();
                if (names != null) {
                    for (String name : names) {
                        File subdirfiles = new File(f + "/" + name);
                        //System.out.println(subdirfiles);
                        if (BrowseText(subdirfiles) != null) {
                            foundfiles.add(subdirfiles.toString());
                        }
                    }
                }
                j++;
            }
            return foundfiles;
        }
    }

    // Данный поток запускает функцию getAllSubDir(), которая считает количество подпапок в заданной папке и сохраняет их в лист subdirs
    @Override
    public void run() {
        getAllSubDir();
    }

    // Отдельный класс для второго потока, который запускает функцию result()
    private class ThreadCompute implements Runnable {

        @Override
        public void run() {
            result();
            System.out.println(foundfiles);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> extensions = new ArrayList<>();
        extensions.add(".docx");
        extensions.add(".txt");
        ParallelSearch parallelSearch = new ParallelSearch("C:/Users/vturb/Documents", "В течении года мы проводили нашу игру", extensions);
        Thread t1 = new Thread(parallelSearch);
        ThreadCompute thread = parallelSearch.new ThreadCompute();
        Thread t2 = new Thread(thread);
        t1.start();
        t2.start();
    }


}
