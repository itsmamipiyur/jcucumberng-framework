package jcucumberng.project.hooks;

import cucumber.api.java.AfterStep;
import jcucumberng.framework.api.Selenium;
import jcucumberng.framework.utils.PropsUtil;

public class StepHook {

	private Selenium selenium = null;

	// PicoContainer injects ScenarioHook object
	public StepHook(ScenarioHook scenarioHook) {
		selenium = scenarioHook.getSelenium();
	}

	@AfterStep
	public void afterStep() throws Throwable {
		if (!Boolean.parseBoolean(PropsUtil.frameworkConf("screenshot.on.fail"))) {
			selenium.embedScreenshot();
		}
	}

}
