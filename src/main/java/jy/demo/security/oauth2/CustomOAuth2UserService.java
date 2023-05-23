package jy.demo.security.oauth2;

import jy.demo.model.User;
import jy.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserService userService;


    @Autowired
    public CustomOAuth2UserService(UserService userService) {
        this.userService = userService;
    }


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> defaultOAuth2UserService = new DefaultOAuth2UserService();

        OAuth2User defaultOAuth2User = defaultOAuth2UserService.loadUser(userRequest);
        CustomOAuth2User customOAuth2User = new KakaoOAuth2User(defaultOAuth2User.getAttributes());

        User user = userService.saveOrUpdate(customOAuth2User);
        customOAuth2User.setId(user.getId());

//        String accessToken = userRequest.getAccessToken().getTokenValue();
        return customOAuth2User;
    }

}
