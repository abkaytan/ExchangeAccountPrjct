package com.patika.exchangeAccountDeneme;

import com.patika.exchangeAccountDeneme.config.DeveloperInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@DeveloperInfo(
        createdBy = "Ali Büyükkaytan",
        url = "https://github.com/abkaytan",
        email = "a.buyukkaytan@gmail.com"
)
public class ExchangeDenemeApplication {


    public static void main(String[] args) {
        SpringApplication.run(ExchangeDenemeApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
