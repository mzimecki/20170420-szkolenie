package com.example.spring;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class App {

    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(Hello.class, EnglishTranslation.class);

        Hello hello = factory.getBean(Hello.class);
        System.out.println("hello = " + hello.sayHello("Jakub"));
    }

}

interface Translation {
    String hello(String name);
}

class PolishTranslation implements Translation {
    public String hello(String name) {
        return String.format("Witaj, %s!", name);

    }
}

class EnglishTranslation implements Translation {
    public String hello(String name) {
        return String.format("Hello, %s!", name);
    }
}

class Hello {

    private final Translation translation;

    public Hello(Translation translation) {
        this.translation = translation;
    }

    public String sayHello(String name) {
        return translation.hello(name);
    }

}