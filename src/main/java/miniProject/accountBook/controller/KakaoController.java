package miniProject.accountBook.controller;

import miniProject.accountBook.dto.KakaoUserBasicInfo;
import miniProject.accountBook.dto.KakaoUserInfo;
import miniProject.accountBook.service.KakaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KakaoController {

    private KakaoService kakaoService;

    public KakaoController(KakaoService kakaoService) {
        this.kakaoService = kakaoService;
    }

    @RequestMapping("/auth")
    public String auth(@RequestParam(value="code", required=false) String code, Model model) throws Exception{
        System.out.println("#################" + code);
        String accessToken = kakaoService.getAccessToken(code);
        KakaoUserInfo userInfo = kakaoService.getUserInfo(accessToken);
        Long id = userInfo.getId();
        String email = userInfo.getKakaoAccount().getEmail();
        String nickname = userInfo.getProperties().getNickname();
        KakaoUserBasicInfo userBasicInfo = new KakaoUserBasicInfo(id, email, nickname);
        model.addAttribute("code",code);
        model.addAttribute("access_token",accessToken);
        model.addAttribute("userInfo",userBasicInfo);
        return "testPage";
    }
}
