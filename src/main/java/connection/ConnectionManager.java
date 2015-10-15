package connection;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.WebSocketSession;
import processing.RequestProcessor;
import processing.ResponseProcessor;

public class ConnectionManager {
    private static final Logger LOG = LoggerFactory.getLogger(ConnectionManager.class);

    private Cache<String, Connection> cache = CacheBuilder.newBuilder().weakKeys().weakValues().build();
    private RequestProcessor requestProcessor;
    private ResponseProcessor responseProcessor;

    public Connection createConnection(WebSocketSession webSocketSession, Login login) {
        Connection connection = initConnection(webSocketSession, login);

        cache.put(extractKey(webSocketSession), connection);

        return connection;
    }

    public Connection getConnection(WebSocketSession webSocketSession) {
        return cache.getIfPresent(extractKey(webSocketSession));
    }

    public void disconnectAndRemove(WebSocketSession webSocketSession) {
        Connection connection = getConnection(webSocketSession);
        if (connection != null) {
            LOG.debug("Disconnecting connection {}", connection);
            connection.disconnect();
            cache.invalidate(extractKey(webSocketSession));
        } else {
            LOG.error("Connection not found, can't disconnect WS session {}", webSocketSession);
        }
    }

    public void setCache(Cache<String, Connection> cache) {
        this.cache = cache;
    }

    private Connection initConnection(WebSocketSession webSocketSession, Login login) {
        return null;
    }

    public String extractKey(WebSocketSession webSocketSession) {
        return webSocketSession.getId();
    }

    public void setRequestProcessor(RequestProcessor requestProcessor) {
        this.requestProcessor = requestProcessor;
    }

    public void setResponseProcessor(ResponseProcessor responseProcessor) {
        this.responseProcessor = responseProcessor;
    }
}
