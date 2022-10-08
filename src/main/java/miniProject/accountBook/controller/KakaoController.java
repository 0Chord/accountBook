package miniProject.accountBook.controller;

import miniProject.accountBook.service.KakaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KakaoController {

    private KakaoService kakaoService;

    public KakaoController(KakaoService kakaoService) {
        this.kakaoService = kakaoService;
    }

    @RequestMapping("/auth")
    public String auth(@RequestParam(value="code", required=false) String code) throws Exception{
        System.out.println("#################" + code);
        String accessToken = kakaoService.getAccessToken(code);
        return "testPage";
    }
}
