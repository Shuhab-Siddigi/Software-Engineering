package PMATest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/Features/",
    plugin = { "summary","html:target/report.html"},
    snippets = SnippetType.CAMELCASE,
    monochrome = true,
    glue = { "PMA","PMATest"}
    )
    

public class PMATest {
}