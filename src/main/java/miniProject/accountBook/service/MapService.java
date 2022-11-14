package miniProject.accountBook.service;

import miniProject.accountBook.dto.LocationInfo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class MapService {
    private final String SEARCH_URL = "https://dapi.kakao.com/v2/local/search/keyword.json?y=36.627831&x=127.4568115";
    private final RestTemplate restTemplate;
    private final String REST_API_KEY = "d078d63bfea989cd9ed843a8b8c59cfe";
    ;

    public MapService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static String mapToUrlParam(Map<String, Object> params) {
        StringBuffer paramData = new StringBuffer();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            if (paramData.length() != 0) {
                paramData.append('&');
            }
            paramData.append(param.getKey());
            paramData.append('=');
            paramData.append(String.valueOf(param.getValue()));
        }
        return paramData.toString();
    }

    public LocationInfo getLocation(String keyword) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "KakaoAK " + REST_API_KEY);

            Map<String, Object> params = new HashMap<>();
            params.put("query", keyword);

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(headers);
            ResponseEntity<LocationInfo> locationInfo = restTemplate.exchange(SEARCH_URL + "&" + this.mapToUrlParam(params), HttpMethod.GET, entity, LocationInfo.class);
            LocationInfo info = locationInfo.getBody();
            System.out.println("info = " + info);
            return info;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
