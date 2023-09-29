package com.example.demofinnhub.infra;

import org.springframework.web.client.RestTemplate;
import com.example.demofinnhub.model.dto.finnhub.resp.CompanyProfile;

// @Service // Bean
public class AppleRestClient { // Service

    // @Autowired // Bean
    RestTemplate restTemplate;

    static final String url = "xxxx";

    public AppleRestClient() {
        this.restTemplate = new RestTemplate();
    }

    public AppleRestClient(RestTemplate restTemplate) {
        if (restTemplate == null) // = @NonNull
            throw new IllegalArgumentException();
        this.restTemplate = restTemplate;
    }

    public CompanyProfile invokeForCompanyProfile(String url){
        return restTemplate.getForObject(url, CompanyProfile.class);
    }

    public CompanyProfile[] invokeForCompanyProfileList(String url){
        return restTemplate.getForObject(url, CompanyProfile[].class);
    }

    public CompanyProfile getProfile(String symbol) {
        // String url = "xxxx";
        return restTemplate.getForObject(url, CompanyProfile.class);
    }

    public static void main(String[] args) {
        AppleRestClient restClient = new AppleRestClient(new RestTemplate());
        CompanyProfile profile = restClient.invokeForCompanyProfile(url);
    }
}

// this can be a library, no spring boot here, everyone can use
// library 目的:封裝，可多人重複使用
