package org.qe.hawkular.page;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularDatasourcesPageConstants;
import org.qe.hawkular.util.HawkularUtils;

public class HawkularDatasourcesPage {

    public final WebDriver driver;

    public HawkularDatasourcesPage(WebDriver driver) {
        this.driver = driver;
    }

    By addDriver = HawkularDatasourcesPageConstants.addDriver;
    By loadDriverFile = HawkularDatasourcesPageConstants.loadDriverFile;
    String driverFilePath = HawkularDatasourcesPageConstants.driverFilePath;
    By driverFilePathNextButton = HawkularDatasourcesPageConstants.driverFilePathNextButton;

    By driverNameSelect = HawkularDatasourcesPageConstants.driverNameSelect;
    String driverName = HawkularDatasourcesPageConstants.driverName;
    By driverModuleNameSelect = HawkularDatasourcesPageConstants.driverModuleNameSelect;
    String driverModuleName = HawkularDatasourcesPageConstants.driverModuleName;
    By driverClassSelect = HawkularDatasourcesPageConstants.driverClassSelect;
    String driverClass = HawkularDatasourcesPageConstants.driverClass;
    By driverParamsNextButton = HawkularDatasourcesPageConstants.driverParamsNextButton;

    By addButton = HawkularDatasourcesPageConstants.addButton;

    By exportJDR = HawkularDatasourcesPageConstants.exportJDR;

    By verifyDriverUploadSuccess = HawkularDatasourcesPageConstants.verifyDriverUploadSuccess;

    // TODO optional: Driver Major Version, Driver Minor Version

    public void navigateAddDriverTab() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(addDriver);
        util.waitForElementPresent(loadDriverFile);
    }

    public void downloadFile() throws IOException{
        URL website = new URL(driverFilePath);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream("/tmp/driver.jar");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    }
    
    public void loadDriverFile() {
        HawkularUtils util = new HawkularUtils(driver);
        try {
            downloadFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        util.sendKeysTo(loadDriverFile, "/tmp/driver.jar");
        util.navigateTo(driverFilePathNextButton);
    }

    public void defineDriverParams() {
        HawkularUtils util = new HawkularUtils(driver);
        util.sendKeysTo(driverNameSelect, driverName);
        util.sendKeysTo(driverModuleNameSelect, driverModuleName);
        util.sendKeysTo(driverClassSelect, driverClass);
        util.navigateTo(driverParamsNextButton);
    }

    public void addDriverSubmit() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(addButton);
    }

    public void exportJDR() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(exportJDR);
    }

    public void verifyDriverUploadSuccess() {
        HawkularUtils util = new HawkularUtils(driver);
        util.waitForElementPresent(verifyDriverUploadSuccess);
    }

    public void verifyExportJDRSuccess() {
        // TODO  verify file download
    }

}
