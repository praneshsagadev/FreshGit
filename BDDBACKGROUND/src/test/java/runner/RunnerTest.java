package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="E:\\SELENIUM NEW\\BDDBACKGROUND\\src\\test\\resources\\FEATUREFILE"
,glue="stepDefination"
,monochrome=true
,publish=true)


public class RunnerTest {
	

}
