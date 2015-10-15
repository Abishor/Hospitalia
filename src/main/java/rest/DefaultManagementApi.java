package rest;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import javax.ws.rs.core.Response;

public class DefaultManagementApi implements ManagementApi {



    public Response upload(final String accessToken, final Attachment file, final String mediaType) {
        return null;
    }

    public Response addStaff(final String accessToken, final String jsonContent) {
        return null;
    }

    public Response request(final String jsonContent) {
        return null;
    }
}
