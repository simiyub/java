package data;

public class Computer {
    private final Case computerCase;
    private final Monitor monitor;
    private final Motherboard motherboard;

    public Computer(Case computerCase, Monitor monitor, Motherboard motherboard) {
        this.computerCase=computerCase;
        this.monitor=monitor;
        this.motherboard=motherboard;
    }

    public void powerUp() {
       computerCase.powerUp();
        drawLogo();
    }

    private void drawLogo() {
        System.out.println("======My PC World=======");
        monitor.drawPixelAt(1500,1200,"red");
    }
}
