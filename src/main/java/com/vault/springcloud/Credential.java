package com.vault.springcloud;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("my")
public class Credential {

    private String username;
    private String password;

}
