package src;

public interface StateOfOfVendingMachine {

    public void selectSnack(VendingMachine vm, Snack snack);

    public void insertMoney(VendingMachine vm, double money);

    public void dispenseSnack(VendingMachine vm, double change);
}