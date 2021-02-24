package LibraryTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "/home/shuhabsiddigi/Documents/SWE1/Project/LibraryApp/src/test/Features/",
    plugin = { "summary"},
    snippets = SnippetType.CAMELCASE,
    glue = { "Library","LibraryTest"}
    )
    

public class AppTest {
}