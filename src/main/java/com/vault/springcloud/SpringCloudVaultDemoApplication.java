package com.vault.springcloud;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.core.VaultVersionedKeyValueTemplate;
import org.springframework.vault.support.VaultResponse;
import org.springframework.vault.support.Versioned;

@Slf4j
@RequiredArgsConstructor
@EnableConfigurationProperties(Credentials.class)
@SpringBootApplication
public class SpringCloudVaultDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(SpringCloudVaultDemoApplication.class);

	private static final String VAULT_PATH_PREFIX = "secret";

	@Autowired
	private VaultTemplate vaultTemplate;


	public static void main(String[] args) {

		SpringApplication.run(SpringCloudVaultDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// You usually would not print a secret to stdout
		System.out.println("Here we gooooo");
//		VaultResponse response = vaultTemplate.read("secret/gs-vault-config");
		VaultResponse response = vaultTemplate.read("/secret/data/spring-vault-config-poc");
		System.out.println("Value of username");
		System.out.println("-------------------------------");
		System.out.println(response.getData().get("example.username"));
		System.out.println("-------------------------------");
		System.out.println();
	}
}
