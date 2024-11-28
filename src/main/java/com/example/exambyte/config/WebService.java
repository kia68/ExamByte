package com.example.exambyte.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.HashSet;
import java.util.Set;

public class WebService implements OAuth2UserService<OAuth2UserRequest, OAuth2User>{

        private DefaultOAuth2UserService defaultOAuth2UserService = new DefaultOAuth2UserService();
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("loadUser called");
        OAuth2User oAuth2User = defaultOAuth2UserService.loadUser(userRequest);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>(oAuth2User.getAuthorities());
        if ("kia68".equals(oAuth2User.getAttribute("login"))){
            grantedAuthorities.add(new SimpleGrantedAuthority("ORGANIZATOR_ROLE"));
        }
        return new DefaultOAuth2User(grantedAuthorities, oAuth2User.getAttributes(), "id");
    }
}
