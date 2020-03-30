import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    strict = true,
    features = {"src/test/features/Allegro.feature"},
    plugin = {"json:Allegro/target/cucumber-parallel/json/1.json"},
    monochrome = true,
    tags = {},
    glue = {"com.allegro"})
public class AllegroTestRunner {

}
