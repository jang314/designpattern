package oop;

import java.util.ArrayList;

public class MyStack<String> extends ArrayList<String> {
    private ArrayList<String> arList = new ArrayList<String>();

    public void push(String element) {
        arList.add(element);
    }
    public String pop() {
        return arList.remove(arList.size()-1);
    }
}
