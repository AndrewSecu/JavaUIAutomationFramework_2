package online.tekwilacademy.stepdefinitions;

import io.cucumber.java.*;
import io.cucumber.java.BeforeAll;
import online.tekwilacademy.managers.DriverManager;

public class Hooks {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("The execution of the test suite started");
    }

    @Before
    public void executedBeforeEachTest() {
        System.out.println("Test started");
    }

    @After
    public void executeAfterEachTest() {
        DriverManager.getInstance().quiteTheDriver();
        System.out.println("The test is completed");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("The test execution finished");
    }

}
