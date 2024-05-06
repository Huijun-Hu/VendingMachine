package src;

public class WaitingForMoneyState implements StateOfOfVendingMachine {

    @Override
    public void selectSnack(VendingMachine vm, Snack snack) {
        System.out.println("** Please wait util current purches finish and then make another selection. **");
    }

    @Override
    public void insertMoney(VendingMachine vm, double money) {
        System.out.println("[Entered $" + money + "]");
        if (vm.getRequestedSnack().getPrice() * vm.getRequestedQuantity() <= money
                && vm.getRequestedSnack().getQuantity() >= vm.getRequestedQuantity()) {
            vm.setChange(money - vm.getRequestedSnack().getPrice() * vm.getRequestedQuantity());
            vm.setState(new DispensingSnackState());
        } else if (vm.getRequestedSnack().getQuantity() < vm.getRequestedQuantity()) {
            System.out.printf("Insufficient Inventory\nYour $%.1f is returned\n", money);
            vm.purchesFinish();
            vm.setState(new IdleState());
        } else {
            System.out.println("Insufficient Amount, Please take back and re-enter");
        }
    }

    @Override
    public void dispenseSnack(VendingMachine vm, double change) {
        System.out.println("** No payment received. **");
    }

}
