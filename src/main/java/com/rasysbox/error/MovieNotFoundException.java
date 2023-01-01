package com.rasysbox.error;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(Long id) {
        super("Movie id not found : " + id);
    }

}
