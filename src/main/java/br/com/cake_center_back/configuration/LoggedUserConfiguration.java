package br.com.cake_center_back.configuration;


import br.com.cake_center_back.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Essa classe serve apenas para simular um usuário logado,
 * deverá ser apaga em produção
 */
@Configuration
public class LoggedUserConfiguration {

    @Bean
    public User loggedUser(){
        User user = new User();
        user.setUsername("admin");
        user.setEmail("admin@admin.com");
        user.setPassword("admin");
        return user;
    }

}
