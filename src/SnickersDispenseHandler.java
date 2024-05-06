package src;

public class SnickersDispenseHandler extends SnackDispenseHandler {
    private SnackDispenseHandler next;
    private Snack snack = new Snack("Snickers", 1.5, 0);

    public SnickersDispenseHandler(SnackDispenseHandler next) {
        super(next);
    }

    public Snack handleRequest(String snack) {
        Snack s = null;
        if (snack == "Snickers") {
            s = this.snack;

        } else {
            s = super.handleRequest(snack);
        }
        return s;
    }
}
