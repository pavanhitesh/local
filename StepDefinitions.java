package com.verizon.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.verizon.base.SingletonAction;
import com.verizon.pageobjects.ProductManagentMainPageObjects;
import com.verizon.utilities.TestStatus;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefinitions {

	Logger logger = LogManager.getLogger(StepDefinitions.class);
	ProductManagentMainPageObjects productManagment;

	@When("^user navigates to project tab under global administration$")
	public void user_navigates_to_project_tab_under_global_administration() throws Throwable {
		productManagment.clickProjectLink();
	}

	@When("^user search for the project \"([^\"]*)\"$")
	public void user_search_for_the_project(String projectName) throws Throwable {
	    productManagment.enterProjectName(projectName);
	}

	@Then("^project details should be displayed$")
	public void project_details_should_be_displayed() throws Throwable { 
		productManagment.waitforResultGrid();
	}

	@When("^user navigates to project mapping tab under global administration$")
	public void user_navigates_to_project_mapping_tab_under_global_administration() throws Throwable {
		productManagment.clickProjectMapping();
	}

	@When("^user search for the project mapping with PnbOrg-\"([^\"]*)\",SubPnbOrg-\"([^\"]*)\",ProductCategory-\"([^\"]*)\" and Program as \"([^\"]*)\"$")
	public void user_search_for_the_project_mapping_with_PnbOrg_SubPnbOrg_ProductCategory_and_Program_as(String pnbOrg, String subPnbOrg,String productCategory , String program) throws Throwable {
		productManagment.enterProjectMappingData(pnbOrg, subPnbOrg, productCategory, program);
	}

	@Then("^project mapping details should be displayed$")
	public void project_mapping_details_should_be_displayed() throws Throwable {
		productManagment.waitforResultGrid();   
	}

	@When("^user navigates to data utilities tab under global administration$")
	public void user_navigates_to_data_utilities_tab_under_global_administration() throws Throwable {
		productManagment.clickDataUtlities();
	}

	@When("^user search for the data utilities \"([^\"]*)\"$")
	public void user_search_for_the_data_utilities(String data) throws Throwable {
		productManagment.searchforDataUtlities(data);
	}

	@Then("^data utilities details should be displayed$")
	public void data_utilities_details_should_be_displayed() throws Throwable {
		productManagment.waitforResultGrid();
	}

	@When("^user navigates to financials tab under global administration$")
	public void user_navigates_to_financials_tab_under_global_administration() throws Throwable {
		productManagment.clickFinancials(); 
	}

	@Then("^Financials page should be loaded$")
	public void financials_page_should_be_loaded() throws Throwable {
		productManagment.waitforFinancialsData();
	}

	

}
