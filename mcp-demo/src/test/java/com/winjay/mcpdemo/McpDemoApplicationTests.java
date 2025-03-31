package com.winjay.mcpdemo;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.ServerParameters;
import io.modelcontextprotocol.client.transport.StdioClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class McpDemoApplicationTests {

	@Test
	public void testMcpListTools() {
		ServerParameters parameters = ServerParameters.builder("java")
				.args("-jar", "/Users/winjay/01-workspace/02-code/01-java/study/spring-ai-study/mcp-demo/target/mcp-demo-0.0.1-SNAPSHOT.jar")
				.build();

		McpSyncClient mcpClient = McpClient.sync(new StdioClientTransport(parameters)).build();

		McpSchema.ListToolsResult listToolsResult = mcpClient.listTools();
		System.out.println("Tools: " + listToolsResult.tools());
		mcpClient.closeGracefully();
	}

	@Test
	public void testMcpCallTools() {
		ServerParameters parameters = ServerParameters.builder("java")
				.args("-jar", "/Users/winjay/01-workspace/02-code/01-java/study/spring-ai-study/mcp-demo/target/mcp-demo-0.0.1-SNAPSHOT.jar")
				.build();

		McpSyncClient mcpClient = McpClient.sync(new StdioClientTransport(parameters)).build();

		McpSchema.CallToolResult callToolResult = mcpClient.callTool(new McpSchema.CallToolRequest("getWeather", Map.of("city", "广州")));
		System.out.println("Tool Result: " + callToolResult);
		mcpClient.closeGracefully();
	}



}
