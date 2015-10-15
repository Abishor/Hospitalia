package rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import security.LoginService;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.Response;

public class DefaultAuthenticationApi implements AuthenticationApi {
    private static final Logger LOG = LoggerFactory.getLogger(DefaultAuthenticationApi.class);
    private final LoginService loginService;

    public DefaultAuthenticationApi(final LoginService loginService) {
        this.loginService = loginService;
    }

    public Response postOtp(@FormParam("phone") String phone, @FormParam("OTP") String otp) {
        return null;
    }

    public Response validateAccessToken(@FormParam("accesstoken") String accessToken) {
        return null;
    }
}
