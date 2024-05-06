package test;

import src.Snack;

import org.junit.Assert;
import org.junit.Test;

public class SnackTest {
    Snack s = new Snack("Ritz", 4.5, 10);

    @Test
    public void testGetName() {
        String exptected = "Ritz";
        String actual = s.getName();
        Assert.assertEquals(exptected, actual);
    }

    @Test
    public void testGetPrice() {
        double exptected = 4.5;
        double actual = s.getPrice();
        Assert.assertEquals(exptected, actual, 0.01);
    }

    @Test
    public void testGetQuantity() {
        int exptected = 10;
        int actual = s.getQuantity();
        Assert.assertEquals(exptected, actual);
    }

    @Test
    public void testSetQuantity() {
        s.setQuantity(7);
        int exptected = 7;
        int actual = s.getQuantity();
        Assert.assertEquals(exptected, actual);
    }
}
