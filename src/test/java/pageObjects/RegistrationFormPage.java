package pageObjects;

import base.pages.BasePage;
import data.provider.CreateUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.ConstantUrls.REGISTRATION_FORM_PAGE;


public class RegistrationFormPage extends BasePage {
    // ФОРМА РЕГИСТРАЦИИ
    //Поле ввода "Имя"
    private static final By nameFieldInRegForm = org.openqa.selenium.By.xpath(".//fieldset[1]//input");
    //поле ввода "E-mail"
    private static final By emailFieldInRegForm = By.xpath(".//fieldset[2]//input");
    //поле ввода "Пароль"
    private static final By passwordFieldInRegForm = By.xpath(".//fieldset[3]//input");
    // Кнопка "Зарегистрироваться"
    private static final By registerButtonInRegForm = By.cssSelector(".button_button__33qZ0");
    private static final By ENTER_BUTTON_IN_REGISTRATION_FORM = By.cssSelector(".Auth_link__1fOlj");
    public RegistrationFormPage(WebDriver driver) {
        super(driver);
    }
    public static void openRegistrationPage() {
        driver.get(REGISTRATION_FORM_PAGE);
    }
    public static void clickEnterButtonInRegForm() {
        driver.findElement(ENTER_BUTTON_IN_REGISTRATION_FORM).click();
    }
    public static void registerUser(CreateUser createUser) {

        driver.findElement(nameFieldInRegForm).sendKeys(createUser.getName());

        driver.findElement(emailFieldInRegForm).sendKeys(createUser.getEmail());

        driver.findElement(passwordFieldInRegForm).sendKeys(createUser.getPassword());

        driver.findElement(registerButtonInRegForm).click();
    }
}



