package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularDatasourcesPageConstants {

    public static final By addDriver = By.xpath("id('hk-datasources')//button[text()='Add Driver']");
    public static final By loadDriverFile = By.id("driver-file");
    public static final String driverFilePath = "http://web.bc.jonqe.lab.eng.bos.redhat.com/hawkular/Hawkular-QE/mysql-connector-java-5.1.17-bin.jar";
    public static final By driverFilePathNextButton = By.xpath(
            "//button[@ng-disabled='addJdbcDriverForm.$invalid' and not(@disabled)]");

    public static final By driverNameSelect = By.id("dn");
    public static final String driverName = "mysql";
    public static final By driverModuleNameSelect = By.id("dmn");
    public static final String driverModuleName = "com.mysql";
    public static final By driverClassSelect = By.id("dc");
    public static final String driverClass = "com.mysql.jdbc.Driver";
    public static final By driverParamsNextButton = By
            .xpath("//button[@ng-disabled='!dac.driverData.driverName || !dac.driverData.moduleName || !dac.driverData.driverClass' and not(@disabled)]");

    public static final By addButton = By
            .xpath("//div[@class='modal-dialog']//button[contains(text(),'Add')]");
    
    public static final By verifyDriverUploadSuccess = By.xpath("//div[@class='modal-dialog']//div[contains(@class,'alert') and not(contains(@class,'ng-hide'))]//strong[text()='Success!']");

    public static final By exportJDR = By.xpath("//button[@ng-click='tabs.requestExportJDR()']");
    
}