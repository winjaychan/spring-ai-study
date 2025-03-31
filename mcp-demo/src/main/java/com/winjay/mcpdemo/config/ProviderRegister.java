package com.winjay.mcpdemo.config;

import com.winjay.mcpdemo.service.WeatherService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Winjay
 *
 * @author <a href="mailto:winjay_chan@qq.com">Winjay(chenwenjie)</a>
 * @date 2025/3/29 19:27
 */
@Configuration
public class ProviderRegister {
    @Bean
    public ToolCallbackProvider weatherTools(WeatherService weatherService) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(weatherService)
                .build();
    }
}
