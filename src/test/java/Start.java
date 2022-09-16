import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        TestNG tng = new TestNG();

        List<String> suites = new ArrayList<>();
        suites.add("./src/test/ejecutar/suiteMain.xml");
        tng.setTestSuites(suites);

        tng.run();
    }
}
