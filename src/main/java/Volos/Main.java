package Volos;

import Volos.clothes.controller.LookController;
import Volos.context.Application;
import Volos.views.ConsoleView;
import Volos.views.View;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        //SpringApplication.run(Main.class);
//        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
//        final LookController lookController = context.getBean(LookController.class);
//
//        View view = new ConsoleView();
//        view.displayLooks(lookController.allLooks());
    }
}