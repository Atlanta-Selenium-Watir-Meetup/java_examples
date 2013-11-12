package derpbear;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created with IntelliJ IDEA.
 * User: orieken
 * Date: 11/12/13
 * Time: 1:07 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Cucumber.class)
@Cucumber.Options(
        format = {
                "pretty",
                "html:target/cucumber"
        }
)

public class RunCukeTest {
}

