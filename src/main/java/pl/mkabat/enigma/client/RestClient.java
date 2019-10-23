package pl.mkabat.enigma.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.POST;

@Slf4j
public class RestClient<P> {

    private final RestTemplate restTemplate;

    public RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean isSuccessful(ResponseEntity responseEntity) {
        return responseEntity != null &&
                       (responseEntity.getStatusCode().is2xxSuccessful() ||
                                responseEntity.getStatusCode().is3xxRedirection());
    }

    public <T> T callPost(String urlPath, HttpEntity<P> httpEntity, ParameterizedTypeReference<T> responseType) {
        return call(urlPath, httpEntity, POST, responseType);
    }

    private <T> T call(String urlPath, HttpEntity<P> httpEntity, HttpMethod httpMethod, ParameterizedTypeReference<T> responseType) {

        ResponseEntity<T> result = restTemplate.exchange(urlPath,
                                                         httpMethod,
                                                         httpEntity,
                                                         responseType);

        if (isSuccessful(result)) {
            return result.getBody();
        } else {
            throw new RestClientException("Unable to perform operation for endpoint: " + urlPath + " message: " + result.getBody());
        }
    }
}
