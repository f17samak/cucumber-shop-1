package ku.shop;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Before
    public void setup() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("a product with quantity (.+) with price (.+) exists")
    public void a_product_with_price_exists(String name, int quantity, double price) {
        catalog.addProduct(name, quantity, price);

    }


    @When("I buy (.+) with quantity (.+)")
    public void i_buy_with_quantity(String name, int quant) {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quant);
    }

    @Then("total should be (.+)")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }


    @Then("there's (.+) items of (.+) left")
    public void there_are_items_of_left(int quant, String name) {
        Product product = catalog.getProduct(name);
        assertEquals(quant, product.quantity);
    }


}



