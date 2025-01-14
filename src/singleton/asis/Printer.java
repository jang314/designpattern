package singleton.asis;

public class Printer {
    // 정적 변수에 Printer 인스턴스를 바로 초기화 하기
    private static Printer printer = null;
    private static int counter =0 ;
    // 외부에서 호출하지 못하도록 수정
//    private Printer() {
//    }

    public synchronized static Printer getPrinter() {
        if(printer==null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
            printer = new Printer();
        }

        return printer;
    }

    public synchronized static void print(String str) {
            counter++;
            System.out.println(str+counter);
    }
}
