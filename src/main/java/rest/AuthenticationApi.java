package rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

public interface AuthenticationApi {
    @POST
    @Path("user/auth")
    @Produces("application/json")
    public Response postOtp(@FormParam("phone") String phone, @FormParam("OTP") String otp);

    @POST
    @Path("user/validate")
    @Produces("application/json")
    public Response validateAccessToken(@FormParam("accesstoken") String accessToken);
}
