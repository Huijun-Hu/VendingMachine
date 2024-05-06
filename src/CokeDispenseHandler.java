package src;

public class CokeDispenseHandler extends SnackDispenseHandler {
    private SnackDispenseHandler next;
    private Snack snack = new Snack("Coke", 3.0, 10);

    public CokeDispenseHandler(SnackDispenseHandler next) {
        super(next);
    }

    public Snack handleRequest(String snack) {
        Snack s = null;
        if (snack == "Coke") {
            s = this.snack;

        } else {
            s = super.handleRequest(snack);
        }
        return s;
    }
}
