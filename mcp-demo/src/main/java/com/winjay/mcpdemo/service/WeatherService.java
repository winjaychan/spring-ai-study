package com.winjay.mcpdemo.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

/**
 * Created by Winjay
 *
 * @author <a href="mailto:winjay_chan@qq.com">Winjay(chenwenjie)</a>
 * @date 2025/3/29 19:25
 */
@Service
public class WeatherService {
    @Tool(description = "获取城市的天气")
    public String getWeather(@ToolParam(description = "城市名称") String city) {
        // Simulate a weather service
        return "Sunny in " + city + ",温度:" + city.length();
    }
}
