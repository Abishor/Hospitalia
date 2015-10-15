package security;

import java.lang.String;public interface LoginService {
    boolean validate(final String user, final String token);
    String createUser(final String newUser, final String adminToken);
}
