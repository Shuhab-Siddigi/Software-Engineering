package LibraryTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/Features/",
    plugin = { "summary","html:target/report.html"},
    snippets = SnippetType.CAMELCASE,
    glue = { "Library","LibraryTest"}
    )
    

public class AppTest {
}