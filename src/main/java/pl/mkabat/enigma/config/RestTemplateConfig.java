package pl.mkabat.enigma.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.springframework.http.HttpStatus.*;

@Configuration
@Slf4j
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.requestFactory(SimpleClientHttpRequestFactory.class)
                      //skipping error handling
                      .interceptors(new AuthorizationHeaderPropagator())
                      .build();
    }

    private static class AuthorizationHeaderPropagator implements ClientHttpRequestInterceptor {
        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
                throws IOException {
            //for demo we set a static token, normally, we should call rest api to get token by credentials
            //and cache it in security context
            request.getHeaders().set("Authorization", "Bearer " + "3e5cac39-7e38-4139-8fd6-30adc06a61bd");

            return execution.execute(request, body);
        }
    }


}
