package com.winjay.mcpdemosse;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.HttpClientSseClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * Created by Winjay
 *
 * @author <a href="mailto:winjay_chan@qq.com">Winjay(chenwenjie)</a>
 * @date 2025/3/30 18:54
 */
public class SseTest {
    @Test
    public void testSseListTools() {
        McpSyncClient client = McpClient.sync(new HttpClientSseClientTransport("http://api.winjay.com:28080")).build();
        McpSchema.ListToolsResult toolsResult = client.listTools();
        System.out.println("Tools: " + toolsResult.tools());
        client.closeGracefully();
    }

    @Test
    public void testSseCallTools() {
        McpSyncClient client = McpClient.sync(new HttpClientSseClientTransport("http://api.winjay.com:28080")).build();
        McpSchema.CallToolResult callToolResult = client.callTool(new McpSchema.CallToolRequest("getWeather", Map.of("city", "广州市")));
        System.out.println("Tool Result: " + callToolResult);
        client.closeGracefully();
    }
}
