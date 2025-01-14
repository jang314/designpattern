package solid;

public class Main {
    public static void main(String[] args) {
        Kid kid = new Kid(new Robot());
        kid.play();
        kid = new Kid(new Car());
        kid.play();

        kid = new Kid(new Lego());
        kid.play();


    }
}
