package com.zdxj.controller;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;

/**
 * 获取RSA公钥接口
 * @author zhaodx
 * @date 2020-07-21 14:49
 */
@RestController
@RequestMapping("rsa")
public class KeyPairController {

    @Autowired
    private KeyPair keyPair;

    @GetMapping("publicKey")
    public Map<String, Object> publicKey() {
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return new JWKSet(key).toJSONObject();
    }

}
