package com.home.content.test.stories;


import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(features = "classpath:com.home.content.test",
        glue = {"com.home.content.test.steps"}, tags = {"~@wip"},
        format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class ContentStories {
}


