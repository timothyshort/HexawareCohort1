package freddie.frameworks;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Add RunWith Parameter
@RunWith(Suite.class)

// Define Suite with Classes
@Suite.SuiteClasses( {
	JUnitTest01.class,
	JUnitLoginTest.class
})
public class JUnitSuite {

}
