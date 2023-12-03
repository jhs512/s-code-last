package com.ll.scode.standard.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Ut {
    private static ApplicationContext context;
    private static ObjectMapper objectMapper;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        context = applicationContext;
        objectMapper = context.getBean(ObjectMapper.class);
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    public static class json {
        @SneakyThrows
        public static String stringify(Object o) {
            return objectMapper.writeValueAsString(o);
        }
    }
}
