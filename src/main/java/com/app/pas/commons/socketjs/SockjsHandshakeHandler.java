package com.app.pas.commons.socketjs;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.xml.ws.RequestWrapper;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketExtension;
import org.springframework.web.socket.WebSocketHandler;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

/**
 *
 * This handler assigned a user id if none found. Can be used for anonymous
 * access and user channels without logging in
 * 
 * @author dhenton
 */

public class SockjsHandshakeHandler extends DefaultHandshakeHandler {

	@Override
	protected Principal determineUser(ServerHttpRequest request,
			WebSocketHandler wsHandler, Map<String, Object> attributes) {
		System.out.println("textHandshakeHandler 호출");
		WebSocketHttpHeaders headers = new WebSocketHttpHeaders(request.getHeaders());
		for (String key : headers.keySet()) {
			System.out.println("header key " + key + " " + headers.get(key));
		}

		Principal originalPrincipal = request.getPrincipal();
		if (originalPrincipal != null) {
			System.out.println("returning original principal "
					+ originalPrincipal.getName());
			return originalPrincipal;
		} else {
			System.out.println("original principal null ");
		}
		final String principalName = UUID.randomUUID().toString();
		System.out.println("assigning principal name : " + principalName);

		Principal principal = new Principal() {
			@Override
			public String getName() {
				return principalName;

			}
		};

		return principal;
	}

}