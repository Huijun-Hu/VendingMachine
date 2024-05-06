package src;

public class VendingMachine {
    private StateOfOfVendingMachine state;
    private Snack requestedSnack;
    private int requestedQuantity;
    private double change;

    private SnackDispenseHandler chain = new CokeDispenseHandler(new PepsiDispenseHandler(new CheetosDispenseHandler(
            new DoritosDispenseHandler(new KitKatDispenseHandler(new SnickersDispenseHandler(null))))));

    public VendingMachine() {
        state = new IdleState();
    }

    public void selectSnack(String requestedSnack, int quantity) {
        this.requestedSnack = chain.handleRequest(requestedSnack);
        this.requestedQuantity = quantity;
        state.selectSnack(this, this.requestedSnack);
    }

    public void insertMoney(double money) {
        state.insertMoney(this, money);
    }

    public void dispenseSnack(double change) {
        state.dispenseSnack(this, change);
    }

    public void purchesFinish() {
        // update inventory
        requestedSnack.setQuantity(requestedSnack.getQuantity() - requestedQuantity);
        // reset vending machine
        requestedQuantity = 0;
        requestedSnack = null;
        change = 0;
    }

    public StateOfOfVendingMachine getState() {
        return state;
    }

    public void setState(StateOfOfVendingMachine state) {
        this.state = state;
    }

    public Snack getRequestedSnack() {
        return requestedSnack;
    }

    public int getRequestedQuantity() {
        return requestedQuantity;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

}
