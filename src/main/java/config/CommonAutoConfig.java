package config;

import base.boot.idgen.CommonSelfIdGenerator;
import base.boot.idgen.IdGen;
import base.boot.json.GsonJson;
import base.boot.json.Json;
import base.boot.registry.DomainRegistry;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by xiaogangfan.
 * Time 2018/8/26 下午5:46
 */
@Configuration
public class CommonAutoConfig {

    @Bean
    @ConditionalOnMissingBean(Json.class)
    public Json json() {
        return new GsonJson();
    }


    @Bean
    @ConditionalOnMissingBean(DomainRegistry.class)
    public DomainRegistry domainRegistry() {
        return new DomainRegistry();
    }

    @Bean
//    @ConditionalOnMissingBean(IdGen.class)
    public IdGen idGen() {
        return new CommonSelfIdGenerator();
    }

}
