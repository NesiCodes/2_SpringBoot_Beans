package com.nesi;

import com.abc.foo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@ComponentScan({"com.nesi", "com.abc.foo"})
@SpringBootApplication
public class BeansApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(BeansApplication.class, args);

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String name: beanNames){
            System.out.println(name);
        }

        System.out.println(ctx.getBean("user").toString());
    }

    @Bean
    public User user(){
        return new User("Unejsi", "Isufaj", "unejsi@gmail.com");
    }

}
