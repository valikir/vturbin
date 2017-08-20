package ru.job4j.Polymorphism;

/**
 * Created by vturb on 19-Aug-17.
 */
public class StubInput implements Input {
    private  String[] answers;
    private  int position = 0;

    public StubInput(String[] answers){
        this.answers = answers;
    }

    public String ask(String question) {

            return answers[position++];
    }
}
