import src.VendingMachine;

public class Driver {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        vm.selectSnack("Coke", 1); // $3.0 each
        vm.insertMoney(3.0);
        vm.dispenseSnack(vm.getChange());

        System.out.println();

        vm.selectSnack("Cheetos", 2); // $1.5 each
        vm.insertMoney(2.0); // insufficient pay, won't dispense
        vm.insertMoney(5.0);
        vm.dispenseSnack(vm.getChange());

        System.out.println();

        // insufficient inventory example
        vm.selectSnack("Snickers", 1); // $1.5 each
        vm.insertMoney(1.5);

        System.out.println();

        // invalid operation example
        // Idle state
        vm.insertMoney(1);
        vm.dispenseSnack(vm.getChange());

        System.out.println();

        vm.selectSnack("KitKat", 1);
        // Waiting for money state
        vm.selectSnack("Coke", 1);
        vm.dispenseSnack(vm.getChange());

        System.out.println();

        vm.insertMoney(3);
        // dispening snack state
        vm.selectSnack("Coke", 1);
        vm.insertMoney(3);
    }
}
