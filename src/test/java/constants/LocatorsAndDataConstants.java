package constants;

import org.openqa.selenium.By;

public class LocatorsAndDataConstants {
    public static final String WRONG_PASSWORD = "12345";
    public static final By WRONG_PASSWORD_MESSAGE = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/p");
public static final  By CHECKOUT_ORDER_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/section[2]/div/button[text() = 'Оформить заказ']");

}
