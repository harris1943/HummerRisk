package io.hummerrisk.commons.utils;

import io.hummerrisk.commons.exception.HRException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RestTemplateUtils {

    private static RestTemplate restTemplate;

    private static void getTemplate() {
        restTemplate = (RestTemplate) CommonBeanFactory.getBean("restTemplate");
    }

    public static String get(String url, HttpHeaders httpHeaders) {
        getTemplate();
        try {
            HttpEntity<MultiValueMap> requestEntity = new HttpEntity<>(httpHeaders);
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
            return responseEntity.getBody();
        } catch (java.lang.Exception e) {
            LogUtil.error(e.getMessage(), e);
            HRException.throwException("Tapd接口调用失败：" + e.getMessage());
            return null;
        }
    }

    public static String post(String url, Object paramMap, HttpHeaders httpHeaders) {
        getTemplate();
        try {
            HttpEntity<MultiValueMap> requestEntity = new HttpEntity<>((MultiValueMap) paramMap, httpHeaders);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
            return responseEntity.getBody();
        } catch (java.lang.Exception e) {
            LogUtil.error(e.getMessage(), e);
            HRException.throwException("Tapd接口调用失败：" + e.getMessage());
            return null;
        }

    }

}
