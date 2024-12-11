package online.tekwilacademy.stepdefinitions;

import io.cucumber.java.*;
import io.cucumber.java.BeforeAll;
import online.tekwilacademy.managers.DriverManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {

    private static final Logger logger = LogManager.getLogger(Hooks.class);

    @BeforeAll
    public static void beforeAll() {
        logger.log(Level.INFO,"The execution of the test suite started");
    }

    @Before
    public void executedBeforeEachTest() {
        logger.log(Level.INFO,"Test started");
    }

    @After
    public void executeAfterEachTest() {
        DriverManager.getInstance().quiteTheDriver();
        logger.log(Level.INFO,"Test completed");    }

    @AfterAll
    public static void afterAll() {
        logger.log(Level.INFO,"The test execution finished");
    }
}
