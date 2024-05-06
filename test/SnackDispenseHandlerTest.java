package test;

import src.*;

import org.junit.Assert;
import org.junit.Test;

public class SnackDispenseHandlerTest {
    SnackDispenseHandler s6 = new SnickersDispenseHandler(null);
    SnackDispenseHandler s5 = new KitKatDispenseHandler(s6);
    SnackDispenseHandler s4 = new DoritosDispenseHandler(s5);
    SnackDispenseHandler s3 = new CheetosDispenseHandler(s4);
    SnackDispenseHandler s2 = new PepsiDispenseHandler(s3);
    SnackDispenseHandler chain = new CokeDispenseHandler(s2);

    @Test
    public void testHandleRequest() {
        Snack expected = s4.handleRequest("Doritos");
        Snack actual = chain.handleRequest("Doritos");

        Assert.assertEquals(expected, actual);
    }
}
