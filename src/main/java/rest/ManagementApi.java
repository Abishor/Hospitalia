package rest;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface ManagementApi {
    /**
     * Upload an initial/modified structure for the hospital
     * @param accessToken
     * @param file
     * @param mediaType
     * @return response regarding the success of the operation
     */
    @POST
    @Path("management/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    Response upload(@Multipart("accesstoken") String accessToken, @Multipart("file") Attachment file, @Multipart("mediaType") String mediaType);

    /**
     * Add personel in the hospital's resource pool
     * @param accessToken - the security check that only authorized entities are making changes in the system
     * @param jsonContent - the addition(s) to be made to the resources
     * @return response regarding the success of the operation
     */
    @POST
    @Path("management/staff/add")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    Response addStaff(@Multipart("accesstoken") String accessToken, @Multipart("content") String jsonContent);

    /**
     * Post the request to the hospital management system
     * @param jsonContent - the request, with all it's data
     * @return response regarding the success of the operation
     */
    @POST
    @Path("management/request")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response request(@Multipart("request") String jsonContent);
}
