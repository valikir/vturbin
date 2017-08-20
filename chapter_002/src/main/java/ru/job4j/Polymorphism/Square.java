package ru.job4j.Polymorphism;

/**
 * Created by vturb on 19-Aug-17.
 */
public class Square implements Shape {

    public String pic(){
        StringBuilder sb = new StringBuilder();
        sb.append("++++++");
        sb.append("+    +");
        sb.append("+    +");
        sb.append("+    +");
        sb.append("+    +");
        sb.append("++++++");
        return sb.toString();
    }
}
