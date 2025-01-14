package modeling.set;

public class Computer {
    private Mainboard mb;
    private CPU cpu;
    private Memory m;
    private PowerSupply ps;

    /**
     * 합성 관계
     * */
    public Computer() {
        this.mb = new Mainboard();
        this.cpu = new CPU();
        this.m = new Memory();
        this.ps = new PowerSupply();
    }

    /**
     * 집약 관계
     * */
    public Computer(Mainboard mb, CPU cpu, Memory m, PowerSupply ps) {
        this.mb = mb;
        this.cpu = cpu;
        this.m = m;
        this.ps = ps;
    }
}
