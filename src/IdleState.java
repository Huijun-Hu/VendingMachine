package src;

public class IdleState implements StateOfOfVendingMachine {

    @Override
    public void selectSnack(VendingMachine vm, Snack snack) {
        System.out.println("[Selected " + snack.getName() + " * " + vm.getRequestedQuantity() + "]");
        vm.setState(new WaitingForMoneyState());
    }

    @Override
    public void insertMoney(VendingMachine vm, double money) {
        System.out.println("** Please select item. **");
    }

    @Override
    public void dispenseSnack(VendingMachine vm, double change) {
        System.out.println("** Please select item. **");
    }

}
