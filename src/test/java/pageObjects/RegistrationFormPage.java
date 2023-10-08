package pageObjects;

import basePages.BasePage;
import dataProvider.CreateUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.ConstantUrls.REGISTRATION_FORM_PAGE;


public class RegistrationFormPage extends BasePage {
    public RegistrationFormPage(WebDriver driver) {
        super(driver);
    }

    // ФОРМА РЕГИСТРАЦИИ
    //Поле ввода "Имя"
    private final By nameFieldInRegForm = By.xpath(".//fieldset[1]//input");
    //поле ввода "E-mail"
    private final By emailFieldInRegForm = By.xpath(".//fieldset[2]//input");
    //поле ввода "Пароль"
    private final By passwordFieldInRegForm = By.xpath(".//fieldset[3]//input");
    // Кнопка "Зарегистрироваться"
    private final By registerButtonInRegForm = By.xpath(".//form/button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text() = 'Зарегистрироваться']");



    /*public RegistrationFormPage() {
        super(driver);
    }*/

    public void openRegistrationPage(){
    driver.get(REGISTRATION_FORM_PAGE);
}


    public  void registerUser(CreateUser createUser) {


        driver.findElement(nameFieldInRegForm).sendKeys(createUser.getName());

        driver.findElement(emailFieldInRegForm).sendKeys(createUser.getEmail());


        driver.findElement(passwordFieldInRegForm).sendKeys(createUser.getPassword());

        driver.findElement(registerButtonInRegForm).click();


        /*driver.manage().timeouts().pageLoadTimeout(10000,
                TimeUnit.MILLISECONDS);*/



    }
}



