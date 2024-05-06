package src;

public class CheetosDispenseHandler extends SnackDispenseHandler {
    private SnackDispenseHandler next;
    private Snack snack = new Snack("Cheetos", 1.5, 7);

    public CheetosDispenseHandler(SnackDispenseHandler next) {
        super(next);
    }

    public Snack handleRequest(String snack) {
        Snack s = null;
        if (snack == "Cheetos") {
            s = this.snack;

        } else {
            s = super.handleRequest(snack);
        }
        return s;
    }
}
