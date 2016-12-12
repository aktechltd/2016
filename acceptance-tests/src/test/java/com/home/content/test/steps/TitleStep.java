package com.home.content.test.steps;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TitleStep extends BaseStep{

    @Given("^Stable condition$")
    public void Stable_condition() throws Throwable {
        System.out.println(baseEndpoint);
    }

    @When("^An action happened$")
    public void An_action_happened() throws Throwable {
        System.out.println(titleServiceEndpoint);
    }

    @Then("^Something happens$")
    public void Something_happens() throws Throwable {
        System.out.println(titleServiceIndividualEndpoint);
    }


    @Given("^The title service titles url$")
    public void The_title_service_titles_url() throws Throwable {
        System.out.printf("");
    }

    @When("^I request all titles from titleService$")
    public void I_request_all_titles_from_titleService() throws Throwable {
        getMethod(titleServiceIndividualEndpoint+"3f2d5b1a8aab8510VgnVCM1000008664150a____");
    }

    @Then("^All titles received successfully$")
    public void All_titles_received_successfully() throws Throwable {
        System.out.println(httpContext.getResponseBody());
    }

    @Then("^Read a title$")
    public void readATitle() throws Throwable {
        populateSingleTitle();
    }

    @Then("^Read all titles$")
    public void readAllTitles() throws Throwable {
        populateAllTitles();
    }
}
