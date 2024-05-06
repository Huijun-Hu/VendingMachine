package src;

public class DispensingSnackState implements StateOfOfVendingMachine {

    @Override
    public void selectSnack(VendingMachine vm, Snack snack) {
        System.out.println("** Can not select another item when current purches is not finished. **");
    }

    @Override
    public void insertMoney(VendingMachine vm, double money) {
        System.out.println("** Do not insert money when current purches is not finished. **");
    }

    @Override
    public void dispenseSnack(VendingMachine vm, double change) {
        System.out.println("[" + vm.getRequestedSnack().getName() + " * " + vm.getRequestedQuantity() + " dispensed.]");
        System.out.println("[Your change is " + change + "]");
        vm.purchesFinish();
        vm.setState(new IdleState());
    }
}
