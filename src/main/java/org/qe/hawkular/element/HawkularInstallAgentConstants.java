package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularInstallAgentConstants {
	
	public static final By logoLocator = By.id("hawkularLogo");
	public static final By installAgentLocator = By.xpath("//*[contains(text(),'Install Agent')]");
	
	// main question if test
	public static final String testSubject = "Is 'install agent' displayed? ";
	
}
