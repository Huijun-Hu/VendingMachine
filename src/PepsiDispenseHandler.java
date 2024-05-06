package src;

public class PepsiDispenseHandler extends SnackDispenseHandler {
    private SnackDispenseHandler next;
    private Snack snack = new Snack("Pepsi", 2.5, 20);

    public PepsiDispenseHandler(SnackDispenseHandler next) {
        super(next);
    }

    public Snack handleRequest(String snack) {
        Snack s = null;
        if (snack == "Pepsi") {
            s = this.snack;
        } else {
            s = super.handleRequest(snack);
        }
        return s;
    }
}