package ru.base64utils;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.File;
import java.io.IOException;


@SpringBootApplication
public class Base64utilsApplication implements ApplicationContextAware {

    private static Logger log = (Logger) LoggerFactory.getLogger(Base64utilsApplication.class);

    @Autowired
    private static ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return ctx;
    }

    public static void main(String[] args)
    {
        SpringApplication.run(Base64utilsApplication.class, args);
        /*
        ctx = getApplicationContext();
        log.debug(String.format("Create app context: %s",ctx.toString()));
       log.debug("args: "+ args[0].toString());

        File file = new File(args[0].toString());
        log.debug(String.format("create file: %s",file.toString()));

        Base64Func func = ctx.getBean("func",Base64Func.class);

        func.setFile(file);
        try {
            func.encode64();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }

}
