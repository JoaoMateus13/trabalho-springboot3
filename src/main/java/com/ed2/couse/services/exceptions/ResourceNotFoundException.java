package com.ed2.couse.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public static final long serialVersionUID = 1L;

    public ResourceNotFoundException (Object id){
        super("Resource not found. Id" + id);
    }
}
