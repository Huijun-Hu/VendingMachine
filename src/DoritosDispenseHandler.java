package src;

public class DoritosDispenseHandler extends SnackDispenseHandler {
    private SnackDispenseHandler next;
    private Snack snack = new Snack("Doritos", 2.0, 8);

    public DoritosDispenseHandler(SnackDispenseHandler next) {
        super(next);
    }

    public Snack handleRequest(String snack) {
        Snack s = null;
        if (snack == "Doritos") {
            s = this.snack;

        } else {
            s = super.handleRequest(snack);
        }
        return s;
    }
}
