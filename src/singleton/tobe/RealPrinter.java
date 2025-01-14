package singleton.tobe;

public class RealPrinter implements Printer{
    private static Printer printer = null;
    private RealPrinter() {}

    public synchronized static Printer getPrinter() {
        if(printer==null) {
            printer = new RealPrinter();
        }
        return printer;
    }
    @Override
    public void print(String str) {
        // 실제 프린터 로직
    }
}
