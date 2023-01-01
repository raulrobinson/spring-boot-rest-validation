package com.rasysbox.error;

import java.util.Set;

public class MovieUnSupportedFieldPatchException extends RuntimeException {

    public MovieUnSupportedFieldPatchException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allow.");
    }

}
