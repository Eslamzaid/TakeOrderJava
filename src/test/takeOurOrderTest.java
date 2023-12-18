package test;

import module.Item;
import module.TakeOutOrder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class takeOurOrderTest {
    TakeOutOrder takeOutOrderTest;
    @Before
    public void setup(){
        takeOutOrderTest = new TakeOutOrder();
    }

    @Test
    public void testMakesARegularOrder() {
        Item item1 = new Item("Shawarma", takeOutOrderTest.generatesComboId());
        Item item2 = new Item("Shawarma", takeOutOrderTest.generatesComboId());
        Item item3 = new Item("Shawarma", takeOutOrderTest.generatesComboId());
        Item item4 = new Item("Kabsa", takeOutOrderTest.generatesComboId());

        takeOutOrderTest.addOrder(item1);
        takeOutOrderTest.addOrder(item2);
        takeOutOrderTest.addOrder(item3);
        takeOutOrderTest.addOrder(item4);
        assertEquals(takeOutOrderTest.getOrderList(), 4);
        takeOutOrderTest.addInstruction("I want extra potato and onion");
        assertEquals(takeOutOrderTest.getInstructions(), 1);
        takeOutOrderTest.conformOrder();
        System.out.println(takeOutOrderTest.checkStatus());
        takeOutOrderTest.finishOrder();
    }



}
