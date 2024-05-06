package src;

public abstract class SnackDispenseHandler {
    private SnackDispenseHandler next;

    public SnackDispenseHandler(SnackDispenseHandler next) {
        this.next = next;
    }

    public Snack handleRequest(String snack) {
        Snack s = null;
        if (next != null) {
            s = next.handleRequest(snack);
        }
        return s;
    }

}