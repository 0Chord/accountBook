package miniProject.accountBook.controller;

import miniProject.accountBook.dto.KakaoUserBasicInfo;
import miniProject.accountBook.dto.KakaoUserInfo;
import miniProject.accountBook.service.KakaoService;
import miniProject.accountBook.session.SessionConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class KakaoController {

    private final Logger logger = LoggerFactory.getLogger(KakaoController.class);
    private final KakaoService kakaoService;

    public KakaoController(KakaoService kakaoService) {
        this.kakaoService = kakaoService;
    }

    @RequestMapping("/auth")
    public String auth(@RequestParam(value="code", required=false) String code, Model model,
                       HttpServletRequest request){
        String accessToken = kakaoService.getAccessToken(code);
        KakaoUserInfo userInfo = kakaoService.getUserInfo(accessToken);
        String email = userInfo.getKakaoAccount().getEmail();
        String nickname = userInfo.getProperties().getNickname();
        KakaoUserBasicInfo userBasicInfo = new KakaoUserBasicInfo(email, nickname);
        logger.info("userBasicInfo = " + userBasicInfo);
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, userBasicInfo);
        model.addAttribute("member",userBasicInfo);
        return "signIn/private";
    }
}
