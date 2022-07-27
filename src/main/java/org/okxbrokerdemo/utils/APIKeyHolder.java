package org.okxbrokerdemo.utils;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class APIKeyHolder {
    private String apiKey;
    private String secretKey;
    private String passPhrase;
    private String accessToken;
    private AutorizationMethod autorizationMethod;

    private Boolean isSimluate = true;

    public void init(String apiKey, String secertKey, String passPhrase) {
        this.apiKey = apiKey;
        this.secretKey = secertKey;
        this.passPhrase = passPhrase;
        autorizationMethod = AutorizationMethod.APIKeyPair;

    }

    public void init(String accessToken) {
        this.accessToken = accessToken;
        autorizationMethod = AutorizationMethod.AccessToken;
    }

    public boolean renewToken(String newToken) {
        if (autorizationMethod.equals(AutorizationMethod.AccessToken)) {
            this.accessToken = newToken;
            return true;
        }
        return false;

    }
}
