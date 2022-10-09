package miniProject.accountBook.service;

import miniProject.accountBook.dto.KakaoAuthResponse;
import miniProject.accountBook.dto.KakaoUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class KakaoService {

    private final Logger logger = LoggerFactory.getLogger(KakaoService.class);
    private final String KAKAO_AUTH_URL = "https://kauth.kakao.com/oauth/token";
    private final String KAKAO_REQ_URL = "https://kapi.kakao.com/v2/user/me";
    private final RestTemplate restTemplate;

    public KakaoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getAccessToken(String authorizeToken) {
        try {
            String clientId = "d078d63bfea989cd9ed843a8b8c59cfe";
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

            return kakaoAuthResponse.getAccessToken();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public KakaoUserInfo getUserInfo(String accessToken) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization","Bearer " + accessToken);
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(headers);

            ResponseEntity<KakaoUserInfo> kakaoUserInfo = restTemplate.exchange(KAKAO_REQ_URL,
                    HttpMethod.POST,
                    entity,
                    KakaoUserInfo.class);

            KakaoUserInfo kakaoInfo = kakaoUserInfo.getBody();
            logger.info("kakaoUserInfo = {} ", kakaoInfo);

            return kakaoInfo;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
