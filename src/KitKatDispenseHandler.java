package src;

public class KitKatDispenseHandler extends SnackDispenseHandler {
    private SnackDispenseHandler next;
    private Snack snack = new Snack("KitKat", 1.0, 10);

    public KitKatDispenseHandler(SnackDispenseHandler next) {
        super(next);
    }

    public Snack handleRequest(String snack) {
        Snack s = null;
        if (snack == "KitKat") {
            s = this.snack;

        } else {
            s = super.handleRequest(snack);
        }
        return s;
    }
}
