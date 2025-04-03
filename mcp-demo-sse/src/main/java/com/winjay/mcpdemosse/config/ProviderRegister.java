package com.winjay.mcpdemosse.config;

import com.winjay.mcpdemosse.service.BalanceService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.winjay.mcpdemosse.service.WeatherService;

/**
 * Created by Winjay
 *
 * @author <a href="mailto:winjay_chan@qq.com">Winjay(chenwenjie)</a>
 * @date 2025/3/29 19:27
 */
@Configuration
public class ProviderRegister {
    @Bean
    public ToolCallbackProvider weatherTools(WeatherService weatherService, BalanceService balanceService) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(weatherService, balanceService)
                .build();
    }
}
