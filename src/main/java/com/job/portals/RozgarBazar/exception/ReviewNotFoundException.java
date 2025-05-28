
package com.job.portals.RozgarBazar.exception;

public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException(Long id) {
        super("Review not found for id: " + id);
    }
}
