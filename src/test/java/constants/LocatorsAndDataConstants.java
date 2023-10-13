package constants;

import org.openqa.selenium.By;

public class LocatorsAndDataConstants {
    public static final String WRONG_PASSWORD = "12345";
    public static final By WRONG_PASSWORD_MESSAGE = By.xpath(".//fieldset[2]/div/p");
public static final  By CHECKOUT_ORDER_BUTTON = By.xpath(".//button[text() = 'Оформить заказ']");

}
