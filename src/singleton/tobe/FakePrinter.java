package singleton.tobe;

public class FakePrinter implements Printer {
    private String str;

    @Override
    public void print(String str) {
        this.str = str;
    }

    public String get() {
        return str;
    }
}
