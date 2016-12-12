package com.home.content.test.steps;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.content.test.beans.Title;
import com.home.content.test.helpers.Versions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import com.home.content.test.helpers.HttpContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.home.content.test.helpers.BasicAuth.basicAuth;

@Slf4j
public class BaseStep {

    @Value("${api.base.url}")
    protected final String baseEndpoint = null;

    @Value("${api.titles.url}")
    protected final String titleServiceEndpoint = null;

    @Value("${api.individual.title.url}")
    protected final String titleServiceIndividualEndpoint = null;

    @Value("${jdbcUrl}")
    private String  jdbcUrl;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String  password;

    @Value("${driverClassName}")
    private String driverClassName;

    @Autowired
    protected HttpContext httpContext;


    protected String defaultVersion= Versions.TITLESERVICEVERSION3.getVersionHeader();



    protected void getMethod(String url) throws Throwable {
        getMethodByQueryParam(url,basicAuth("admin","nebula"),defaultVersion);
    }

    protected void getMethodByQueryParam(String url, final String basicAuth,final String version) throws Throwable {

        HttpClient httpClient = new HttpClient();

        GetMethod getMethod = new GetMethod(url);
        getMethod.setRequestHeader("Authorization", basicAuth);
        getMethod.setRequestHeader("Accept", version);

        long start = System.currentTimeMillis();
        httpClient.executeMethod(getMethod);
        long end = System.currentTimeMillis();
        //LOGGER.info(url + "," + (end - start));

        httpContext.populateGetQuery(getMethod);
    }

    protected void postMethod(String url, String post_query) throws Throwable{
        postMethodByQueryParam(url,post_query, basicAuth("admin","nebula"),defaultVersion);
    }

    protected void postMethodByQueryParam(String url, String post_query,final String basicAuth, final String version) throws Throwable {

        HttpClient httpClient = new HttpClient();

        StringRequestEntity stringRequestEntity = new StringRequestEntity(post_query,
                "application/json",
                "UTF-8");

        PostMethod postMethod = new PostMethod(url);
        postMethod.setRequestHeader("AUTH_HEADER", basicAuth);
        postMethod.setRequestHeader("Accept",version);
        postMethod.setRequestEntity(stringRequestEntity);

        long start = System.currentTimeMillis();
        httpClient.executeMethod(postMethod);
        long end = System.currentTimeMillis();
        //LOGGER.info(url + "," + (end - start));

        httpContext.populatePostQuery(postMethod);
    }

    protected ObjectMapper objectMapper = new ObjectMapper();
    protected Title movieTitle = new Title();
    protected List<Title> allTitles = new ArrayList<>();

    protected void populateSingleTitle() throws Throwable {
        getMethod(titleServiceIndividualEndpoint);
        movieTitle = objectMapper.readValue(httpContext.getResponseBody(), Title.class);
    }

    protected void populateAllTitles() throws Throwable{
        getMethod(titleServiceEndpoint);
        allTitles = objectMapper.readValue(httpContext.getResponseBody(), new TypeReference<List<Title>> (){});
    }


}
