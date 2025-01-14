package singleton.asis;

public class Main {
    private static final int USER_NUM = 5;
    public static void main(String[] args) {
        User[] user = new User[USER_NUM];
        for(int i= 0 ;i < USER_NUM; i++) {
            user[i] = new User(i+1+"-user");
            user[i].print();
        }
    }
}
