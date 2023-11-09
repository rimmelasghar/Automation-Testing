package org.example.SwagsLabsTesting.pages;


import org.example.Labs.Params;
import org.example.Methods.Method;
import org.example.SwagsLabsTesting.SwagsLabParams;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    public static SwagsLabParams params= new SwagsLabParams();

    public  static WebDriverWait wait;
    public static Method method;
    public Login(Method method,WebDriver wait){
        Login.method = method;
    }
    public static void loginTest(){

        method.enterText(params.userNameIdentifier,params.userName);
        method.enterText(params.userPasswordIdentifier,params.userPassword);
        method.clickElement(params.loginBtnIdentifier);
        System.out.println("<--- Login Test: Status --->");
        method.verifyExpectedText(params.productIdentifier,params.expectedProductResults);
    }

    public static void main(String[] args) throws Exception{
        System.out.println("Run SwagsLabTests.java For the Execution of this Code!!! ");
    }
}