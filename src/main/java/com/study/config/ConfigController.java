package com.study.config;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.context.annotation.Bean;

public class ConfigController {

    @Bean
    public Hibernate5Module hibernate5Module(){
        Hibernate5Module hibernate5Module = new Hibernate5Module();
        /*
        강제 지연 로딩!
        엔티티에 관련된 모든 데이터 가져온다.
        hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING,
                true);
        */
        return hibernate5Module;
    }
}
