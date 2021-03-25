package Volos.context;

import Volos.clothes.controller.LookController;
import Volos.clothes.service.LookService;
import Volos.clothes.service.LookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import Volos.repository.LookRepository;
import Volos.repository.LookRepositoryImpl;

@Configuration
public class Application {

    @Bean
    public LookController lookApi() {
        return new LookController(lookService());
    }

    @Bean
    public LookService lookService() {
        return new LookServiceImpl(lookRepository());
    }

    @Bean
    protected LookRepository lookRepository() {
        return new LookRepositoryImpl();
    }
}
