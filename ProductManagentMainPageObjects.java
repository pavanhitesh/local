package com.verizon.pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.verizon.base.SingletonAction;
import com.verizon.utilities.TestStatus;


public class ProductManagentMainPageObjects {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath="//div[@class='navbar-right']/ul/li//div[text()='Administration']")
    WebElement lnkAdmin;
    @FindBy(xpath=".//div[contains(text(),'Global Administration')]")
    WebElement lnkGlobalAdmin;
    
    /**
     * Global Admin Inner Links
     */
    
    @FindBy(xpath=".//a[contains(text(),'Projects')]")
    WebElement lnkProject;
    @FindBy(xpath=".//input[@placeholder='Enter Project Name or Clarity ID']")
    WebElement txtProjectName;
    
    @FindBy(xpath=".//a[contains(text(),'Project Mappings')]")
    WebElement lnkProjectMappings;
    @FindBy(xpath=".//*[text()='PnbOrg']/parent::span/following::div[1]/button")
    WebElement drpDownPnbOrg;
    @FindBy(xpath=".//*[text()='SubPnbOrg']/parent::span/following::div[1]/button")
    WebElement drpDownSubPnbOrg;
    @FindBy(xpath=".//*[text()='Product Category']/parent::span/following::div[1]/button")
    WebElement drpDownProductCategory;
    @FindBy(xpath=".//*[text()='Program']/parent::span/following::div[1]/button")
    WebElement drpDownProgram;
    
    String drpDownValue = ".//*[contains(text(),'@@value@@')]";
    
    @FindBy(xpath=".//a[contains(text(),'Data Utilities')]")
    WebElement lnkDataUtilities;
    @FindBy(xpath=".//*[text()='Dropdown Name']/parent::span/following::div[1]/button")
    WebElement drpDownName;
    
    @FindBy(xpath=".//a[contains(text(),'Financials')]")
    WebElement lnkFinancials;
    @FindBy(xpath=".//label[text()='Business Capex & Revenue Upload']")
    WebElement labelBusinessCapex;
    
    
    @FindBy(xpath=".//div[contains(text(),'Governance Action Log')]")
    WebElement lnkGovernanceActionLog;
    @FindBy(xpath=".//div[contains(text(),'Workflow Templates')]")
    WebElement lnkWorkflowTemplates;
    @FindBy(xpath=".//input[@placeholder='Enter User Name']")
    WebElement txtUserName;
    @FindBy(xpath=".//button[text()='Submit']")
    WebElement btnSubmit;
    @FindBy(xpath=".//div[@class='vz-table__table']")
    WebElement vzTable;
    @FindBy(xpath=".//div[@class='vz-table__table-body']")
    WebElement vzTableBody;
    @FindBy(xpath=".//governance-framework-template-list[@class='ng-scope ng-isolate-scope']/div[@class='row']")
    WebElement tableTemplate;
    
    
    
    
    
	
	public ProductManagentMainPageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 90);
	}

	/**
	 * 
	 */
	public void navigate(String url) {
		this.driver.get(url);
		this.driver.manage().window().maximize();
	}
	
	public void navigateToGlobalAdminPage() {
        wait.until(ExpectedConditions.visibilityOf(lnkAdmin));
        Actions act = new Actions(this.driver);
        act.moveToElement(lnkAdmin).build().perform();
        lnkGlobalAdmin.click();
    }
	
	
	public void navigateToGovernanceActionLog() {
        wait.until(ExpectedConditions.visibilityOf(lnkAdmin));
        Actions act = new Actions(this.driver);
        act.moveToElement(lnkAdmin).build().perform();
        lnkGovernanceActionLog.click();
    }
    
    
    public void navigateToWorkflowTemplate() {
        wait.until(ExpectedConditions.visibilityOf(lnkAdmin));
        Actions act = new Actions(this.driver);
        act.moveToElement(lnkAdmin).build().perform();
        lnkWorkflowTemplates.click();
    }
    
    public void waitforAdminpage() throws IOException {
        try {
        wait.until(ExpectedConditions.visibilityOf(txtUserName));
        SingletonAction.getExtentReport().insertStep("UserNavigate to Admin Page->"+this.driver.getTitle(), "", TestStatus.PASS, ""    , true);
        }catch(Exception e) {
            SingletonAction.getExtentReport().insertStep("UserNavigate to Admin Page", "", TestStatus.FAIL, ""    , true);
        }
    }
	
	
	 public void clickOnSubmitButton() {
        btnSubmit.click();
    }
    public void waitforResultGrid() throws IOException {
        try {
        wait.until(ExpectedConditions.visibilityOf(vzTableBody));
        SingletonAction.getExtentReport().insertStep("Result Displayed", "", TestStatus.PASS, ""    , true);
        }catch(Exception e) {
            SingletonAction.getExtentReport().insertStep("Result Not Displayed", "", TestStatus.FAIL, ""    , true);
        }
    }
    public void waitforTemplateResultGrid() throws IOException {
        try {
        wait.until(ExpectedConditions.visibilityOf(tableTemplate));
        SingletonAction.getExtentReport().insertStep("Template Page Loaded", "", TestStatus.PASS, ""    , true);
        }catch(Exception e) {
            SingletonAction.getExtentReport().insertStep("Template Page Not Loaded", "", TestStatus.FAIL, ""    , true);
        }
    }
    
    public void clickProjectLink() throws IOException {
    	try {
    		wait.until(ExpectedConditions.visibilityOf(lnkProject));
    		lnkProject.click();
    		wait.until(ExpectedConditions.visibilityOf(txtProjectName));
    		SingletonAction.getExtentReport().insertStep("Project Page Loaded", "", TestStatus.PASS, ""    , true);
    	}catch(Exception e) {
    		SingletonAction.getExtentReport().insertStep("Project Not navigated", "", TestStatus.FAIL, ""    , true);
    	}
    }
    
    
    public void enterProjectName(String projectName) throws IOException {
    	try {
    		wait.until(ExpectedConditions.visibilityOf(txtProjectName));
    		txtProjectName.sendKeys(projectName);
    		clickOnSubmitButton();
    	}catch(Exception e) {
    		SingletonAction.getExtentReport().insertStep("unable to enter project name", "", TestStatus.FAIL, ""    , true);
    	}
    }
    
    
    public void clickProjectMapping() throws IOException {
    	try {
    		wait.until(ExpectedConditions.visibilityOf(lnkProjectMappings));
    		lnkProjectMappings.click();
    		wait.until(ExpectedConditions.visibilityOf(drpDownPnbOrg));
    		SingletonAction.getExtentReport().insertStep("ProjectMappings Page Loaded", "", TestStatus.PASS, ""    , true);
    	}catch(Exception e) {
    		SingletonAction.getExtentReport().insertStep("ProjectMappings Not navigated", "", TestStatus.FAIL, ""    , true);
    	}
    }
    
    public void enterProjectMappingData(String pnbOrg, String subPnbOrg,String productCategory , String program) throws IOException {
    	try {
	    	drpDownPnbOrg.click();
	    	String pnbOrgXpath = drpDownValue.replace("@@value@@", pnbOrg);
	    	this.driver.findElement(By.xpath(pnbOrgXpath)).click();
	    	
	    	drpDownSubPnbOrg.click();
	    	String subPnbOrgXpath = drpDownValue.replace("@@value@@", subPnbOrg);
	    	this.driver.findElement(By.xpath(subPnbOrgXpath)).click();
	    	
	    	drpDownProductCategory.click();
	    	String productCategoryXpath = drpDownValue.replace("@@value@@", productCategory);
	    	this.driver.findElement(By.xpath(productCategoryXpath)).click();
	    	
	    	drpDownProgram.click();
	    	String programXpath = drpDownValue.replace("@@value@@", program);
	    	this.driver.findElement(By.xpath(programXpath)).click();
	    	
	    	clickOnSubmitButton();
	   
    	}catch(Exception e) {
    		SingletonAction.getExtentReport().insertStep("Not able to Select "+pnbOrg, "", TestStatus.FAIL, ""    , true);
    	}
    }
    
    public void clickDataUtlities() throws IOException {
    	try {
    		wait.until(ExpectedConditions.visibilityOf(lnkDataUtilities));
    		lnkDataUtilities.click();
    		wait.until(ExpectedConditions.visibilityOf(drpDownName));
    		SingletonAction.getExtentReport().insertStep("ProjectMappings Page Loaded", "", TestStatus.PASS, ""    , true);
    	}catch(Exception e) {
    		SingletonAction.getExtentReport().insertStep("ProjectMappings Not navigated", "", TestStatus.FAIL, ""    , true);
    	}
    }
    
    public void searchforDataUtlities(String data) throws IOException {
    	try {
    		drpDownName.click();
	    	String pnbOrgXpath = drpDownValue.replace("@@value@@", data);
	    	this.driver.findElement(By.xpath(pnbOrgXpath)).click();
    	}catch(Exception e) {
    		SingletonAction.getExtentReport().insertStep("DataUtlities Not Selected", "", TestStatus.FAIL, ""    , true);
    	}
    }
   
    public void clickFinancials() throws IOException {
    	try {
    		wait.until(ExpectedConditions.visibilityOf(lnkFinancials));
    		lnkFinancials.click();
    	}catch(Exception e) {
    		SingletonAction.getExtentReport().insertStep("Unable to click financials ", "", TestStatus.FAIL, ""    , true);
    	}
    }
    
    public void waitforFinancialsData() throws IOException {
    	try {
    		wait.until(ExpectedConditions.visibilityOf(labelBusinessCapex));
    		SingletonAction.getExtentReport().insertStep("Financials Page Loaded", "", TestStatus.PASS, ""    , true);
    	}catch(Exception e) {
    		SingletonAction.getExtentReport().insertStep("Financials Page Loaded", "", TestStatus.FAIL, ""    , true);
    	}
    }
    
}
