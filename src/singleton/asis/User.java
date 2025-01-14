package singleton.asis;

public class User {
    private String name;
    public User(String name) {
        this.name = name;
    }
    public void print() {
        Printer printer = Printer.getPrinter();
        System.out.printf("%s print using ", this.name);
        System.out.println(printer.toString());
    }
}
