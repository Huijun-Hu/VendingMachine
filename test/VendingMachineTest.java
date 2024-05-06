package test;

import org.junit.Assert;
import org.junit.Test;

import src.*;

public class VendingMachineTest {
    VendingMachine vm = new VendingMachine();

    @Test
    public void testSelectSnack() {
        vm.selectSnack("Coke", 2);
        Assert.assertEquals("Coke", vm.getRequestedSnack().getName());
        Assert.assertEquals(2, vm.getRequestedQuantity());
    }

    @Test
    public void testInsertMoney() {
        vm.insertMoney(10.0);
    }

    @Test
    public void testGetChange() {
        vm.selectSnack("Coke", 2);
        vm.insertMoney(10.0);
        Assert.assertEquals(4, vm.getChange(), 0.01);
    }

    @Test
    public void testGetRequestedQuantity() {
        vm.selectSnack("Coke", 2);
        vm.insertMoney(10.0);
        vm.dispenseSnack(vm.getChange());

        Assert.assertEquals(0, vm.getRequestedQuantity());
    }

    @Test
    public void testGetRequestedSnack() {
        vm.selectSnack("Coke", 2);
        Assert.assertEquals("Coke", vm.getRequestedSnack().getName());
        Assert.assertEquals(2, vm.getRequestedQuantity());
    }

    @Test
    public void testGetState() {
        Assert.assertEquals(vm.getState().getClass(), new IdleState().getClass());

        vm.selectSnack("Coke", 2);
        Assert.assertEquals(vm.getState().getClass(), new WaitingForMoneyState().getClass());

        vm.insertMoney(10);
        Assert.assertEquals(vm.getState().getClass(), new DispensingSnackState().getClass());

        vm.dispenseSnack(4);
        Assert.assertEquals(vm.getState().getClass(), new IdleState().getClass());
    }

    @Test
    public void testPurchesFinish() {
        vm.selectSnack("Coke", 2);
        vm.purchesFinish();

        Assert.assertEquals(0, vm.getRequestedQuantity());
        Assert.assertEquals(0, vm.getChange(), 0.01);
    }

    @Test
    public void testSetChange() {
        vm.setChange(1000);
        Assert.assertEquals(1000, vm.getChange(), 0.001);

    }

    @Test
    public void testSetState() {
        vm.setState(new DispensingSnackState());
        Assert.assertEquals(vm.getState().getClass(), new DispensingSnackState().getClass());
    }
}
