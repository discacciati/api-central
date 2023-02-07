package com.calculocotacao.apicentral;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class CalculoCotacaoApiClient<InstanceInfo> {
    private final static String ENDPOINT = "https://economia.awesomeapi.com.br/{moeda}/";

    private final EurekaClient eurekaClient;

    private final RestTemplate restTemplate;

    public Double cotacaoMoeda(String moeda) {
        InstanceInfo apiInstanceInfo = eurekaClient.getApplication("moeda")
                .getInstances().stream().findAny().orElseThrow(() -> new RemoteAccessException("Mesa Api indisponível"));
        return restTemplate.getForEntity(ENDPOINT, String.class, apiInstanceInfo.getHostName(), apiInstanceInfo.getPort(), id)
                .getStatusCode()
                .is2xxSuccessful();
    }
}
