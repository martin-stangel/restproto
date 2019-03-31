package com.whitestein.restproto.server;

import org.glassfish.jersey.server.ResourceConfig;

public class RestProtoApp extends ResourceConfig {

	public RestProtoApp() {
		packages("com.whitestein.restproto");
	}
}
