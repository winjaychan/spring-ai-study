package com.winjay.mcpdemosse.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

/**
 * Created by Winjay
 *
 * @author <a href="mailto:winjay_chan@qq.com">Winjay(chenwenjie)</a>
 * @date 2025/3/31 17:15
 */
@Service
public class BalanceService {
    @Tool(description = "获取账户余额")
    public String getBalance(@ToolParam(description = "账户") String accountId) {
        // Simulate a balance service
        return "Account " + accountId + " has a balance of $" + (accountId.length() * 100000);
    }
}
