package com.svetikov.storage2020.component;


import com.svetikov.storage2020.service.ModelService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class ComponentPLCDATA {
    @Bean
    public PLCComponent plcComponent(ModelService modelService){
     return    new PLCComponent(modelService);
    }
}
