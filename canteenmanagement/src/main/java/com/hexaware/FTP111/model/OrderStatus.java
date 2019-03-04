package com.hexaware.FTP111.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This is OrderStatus.
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public enum OrderStatus {
    /** Accepted. */
    APPROVED,
    /** Pending. */
    PENDING,
    /** Rejected. */
    REJECTED,
    /** Partial. */
    PARTIAL;
}
