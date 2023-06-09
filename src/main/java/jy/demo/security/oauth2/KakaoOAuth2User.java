package jy.demo.security.oauth2;

import java.util.List;
import java.util.Map;
import jy.demo.common.HttpResponse;
import jy.demo.exception.DataNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KakaoOAuth2User extends CustomOAuth2User {

    public static final String ATTRIBUTES = "kakao_account";
    public static final String ATTRIBUTES_PROFILE = "profile";
    public static final String ATTRIBUTES_NAME = "nickname";
    public static final String ATTRIBUTES_EMAIL = "email";
    public static final String ATTRIBUTES_KEY = "id";


    public KakaoOAuth2User(Map<String, Object> providedAttributes) {

        try {
            super.attributes = (Map<String, Object>) providedAttributes.get(ATTRIBUTES);

            if (!providedAttributes.containsKey(ATTRIBUTES_KEY) ||
                !attributes.keySet().containsAll(List.of(ATTRIBUTES_PROFILE, ATTRIBUTES_EMAIL))) {
                throw new IllegalArgumentException();
            }

            super.name = String.valueOf(((Map<?, ?>) attributes.get(ATTRIBUTES_PROFILE)).get(ATTRIBUTES_NAME));
            super.email = String.valueOf(attributes.get(ATTRIBUTES_EMAIL));
            super.socialProviderKey = String.valueOf(providedAttributes.get(ATTRIBUTES_KEY));

        } catch (NullPointerException | IllegalArgumentException e) {
            throw new DataNotFoundException(HttpResponse.INVALID_KAKAO_OAUTH);
        }
    }
}

