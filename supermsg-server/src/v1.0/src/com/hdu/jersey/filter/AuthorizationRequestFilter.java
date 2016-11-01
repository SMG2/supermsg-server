package com.hdu.jersey.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.hdu.jersey.error.ResponseCode;
import com.hdu.jersey.response.BaseResponseMsg;
import com.hdu.jersey.response.ResponseBuilder;
 
public class AuthorizationRequestFilter implements ContainerRequestFilter {
 
	
	/**
	 * 当用户访问/users且用post请求创建用户时，不需要拦截以及验证，但是其他的方法以及路径都是需要判断的，以及过滤
	 * 
	 * */
    @Override
    public void filter(ContainerRequestContext requestContext)
                    throws IOException {
 
    	if("/users".equals(requestContext.getUriInfo().getPath()) && requestContext.getMethod().equalsIgnoreCase("POST"))
    		return ;
    	
    	MultivaluedMap<String, String> headers = requestContext.getHeaders();
    	if(!(headers.containsKey("Nonce")
    			&&headers.containsKey("Timestamp")
    			&&headers.containsKey("Signature")
    			&&headers.containsKey("Userid"))){
    		
            requestContext.abortWith(Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity(ResponseBuilder.build(
                    		new BaseResponseMsg(ResponseCode.UNAUTHORIZED, "Missing parameters,check the heads you send."), null))
                    .build());
            return ;
    		
    	}
    	
    	String Nonce  = headers.get("Nonce").get(0);
    	String Timestamp = headers.get("Timestamp").get(0);
    	String userid = headers.get("Userid").get(0);
    	String Signature = headers.get("Signature").get(0);
    	
    	String data = Nonce+Timestamp+userid;
    	String digest = new com.hdu.jersey.util.SHA1().getDigestOfString(data.getBytes());
    	if(!digest.equals(Signature)){
            requestContext.abortWith(Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity(ResponseBuilder.build(
                    		new BaseResponseMsg(ResponseCode.UNAUTHORIZED, "User cannot access the resource."), null))
                    .build());	
            return ;
    	}
    	
    	System.out.println("filter:-----------------------------");
//        final SecurityContext securityContext =
//                    requestContext.getSecurityContext();
//        if (securityContext == null ||
//                    !securityContext.isUserInRole("privileged")) {
// 
//                requestContext.abortWith(Response
//                    .status(Response.Status.UNAUTHORIZED)
//                    .entity("User cannot access the resource.")
//                    .build());
//        }
    }
}