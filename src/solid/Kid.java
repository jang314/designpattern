package solid;

public class Kid {
    private Toy toy;

    public Kid(Toy toy) {
        this.toy = toy;
    }

    public void play() {
        toy.play();
    }
}
