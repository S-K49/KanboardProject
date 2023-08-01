package api.tests;

import org.testng.annotations.BeforeMethod;

import static utils.EnvProperties.setupInstance;

public class BaseApiTest {

    @BeforeMethod
    public void setup(){
        setupInstance("default");
    }
}