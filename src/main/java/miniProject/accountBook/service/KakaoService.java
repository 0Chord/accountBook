package miniProject.accountBook.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import miniProject.accountBook.dto.KakaoAuthResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class KakaoService {

    private final String KAKAO_AUTH_URL = "https://kauth.kakao.com/oauth/token";

    private final RestTemplate restTemplate;

    public KakaoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getAccessToken(String authorizeToken) {
        try {
            String clientId = "ff79af41c4ab3a014eab364fc972ee14";
            String redirectURL = "http://localhost:8080/auth";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("grant_type", "authorization_code");
            params.add("client_id", clientId);
            params.add("redirect_url", redirectURL);
            params.add("code", authorizeToken);

            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);

            ResponseEntity<KakaoAuthResponse> result = restTemplate.exchange(KAKAO_AUTH_URL, HttpMethod.POST, entity, KakaoAuthResponse.class);
            KakaoAuthResponse kakaoAuthResponse = result.getBody();

            System.out.println("AAAAAAAAAAAAA" + kakaoAuthResponse);

            return kakaoAuthResponse.getAccessToken();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
