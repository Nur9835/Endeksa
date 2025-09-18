package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class ValuationsPage {

    public ValuationsPage(WebDriver driver){

        PageFactory.initElements(Driver.getDriver(),this);
    }



}
