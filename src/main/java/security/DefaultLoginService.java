package security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;

public class DefaultLoginService implements LoginService {
    private static final Logger LOG = LoggerFactory.getLogger(DefaultLoginService.class);
    private final String masterKey;
    private final Map<String, String> cache;

    public DefaultLoginService(final String adminToken) {
        checkArgument(!adminToken.isEmpty(), "The master key must be set");
        masterKey = adminToken;
        cache = new HashMap<String, String>();
    }

    public boolean validate(final String user, final String token) {
        return false;
    }

    public String createUser(final String newUser, final String adminToken) {
        return null;
    }
}
