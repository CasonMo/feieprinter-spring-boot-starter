package com.cason.autocinfigure;

import com.cason.feiePrint.service.FeiePrintService;
import com.cason.feiePrint.service.impl.FeiePrintServiceImpl;
import com.cason.feiePrint.utils.FeieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * User: 贝先 [ Cason mo ]
 * Date: 2021/7/23
 * Time: 11:35
 */
@Configuration
@ConditionalOnClass({FeiePrintService.class})
public class StarterAutoConfigure {

    @Bean
    @ConditionalOnMissingBean
    FeiePrintService feiePrintService (){
        return new FeiePrintServiceImpl();
    }

}
