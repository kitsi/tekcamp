import com.bootcamp.teksystems.ood_exercises.facade.Item;
import com.bootcamp.teksystems.ood_exercises.facade.PurchaseFacade;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FacadeTest {

    PurchaseFacade facade = new PurchaseFacade();

    @Test
    public void facadeCanAddItemsToOrder() {
        boolean expectedResult = true;
        boolean actualResult = facade.processOrderItem(1,1);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void facadeCanGetNumberOfItemsInStock() {
        facade.replenishInventory();
        int expectedResult = 10;
        int actualReesult = facade.getStock(Item.DESK);
        Assert.assertEquals(actualReesult, expectedResult);
    }

    @Test
    public void facaceReturnsTrueForIsEmptyIfOrderIsEmpty() {
        boolean expectedResult = true;
        facade.emptyOrder();
        boolean actualResult = facade.isOrderEmpty();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void facaceReturnsFalseForIsEmptyIfOrderHasItems() {
        boolean expectedResult = false;
        facade.processOrderItem(1,1);
        boolean actualResult = facade.isOrderEmpty();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void facadeCanProvidePaymentOptions() {
        String expectedResult = "1) Paypal, 2) Mastercard, 3) Visa";
        String actualResult = facade.getPaymentOptions();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void facadeCanGetInvoiceWithItemsInOrder() {
        facade.processOrderItem(1, 1);
        String expectedLineItem = String.format(" %-34s| %-15s","Fezibo Adjustable Desk", "$299.99");
        Assert.assertTrue(facade.getInvoice().contains(expectedLineItem));
    }

    @Test
    public void facadeCanGetInvoiceIfNoItemsInOrder() {
        facade.emptyOrder();
        String expectedLineItem = String.format(" %-34s| %-15s","TOTAL ", "$0.00");
        Assert.assertTrue(facade.getInvoice().contains(expectedLineItem));
    }

    @Test
    public void facadeCanProcessPaymentIfOrderHasItems() {
        facade.processOrderItem(2, 1);
        String expectedResult = "Paypal has been charged";
        String actualResult = facade.processPayment(1).strip();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void facadeCanProcessPaymentIfOrderIsEmpty() {
        facade.emptyOrder();
        String expectedResult = "No payment has been charged";
        String actualResult = facade.processPayment(1).strip();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void facadeCanShipIfOrderHasItems() {
        facade.processOrderItem(3, 1);
        String expectedLineItem = "\nOrder has been shipped to:";
        Assert.assertTrue(facade.ship("Silly Goose", "123 Street", "SomeCity", "SomeState", "12345").contains(expectedLineItem));
    }

    @Test
    public void facadeCanShipIfOrderIsEmpty() {
        facade.emptyOrder();
        String expectedLineItem = "There is no order to ship";
        Assert.assertTrue(facade.ship("", "", "", "", "").contains(expectedLineItem));
    }

}
