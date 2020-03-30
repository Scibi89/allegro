import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    strict = true,
    features = {"C:/projects/dev/Allegro/src/test/features/Allegro.feature"},
    plugin = {"json:C:/projects/dev/Allegro/target/cucumber-parallel/json/1.json"},
    monochrome = true,
    tags = {},
    glue = {"com.allegro"})
public class AllegroTestRunner {

}
