package io.gh.modules.customer.entity;

import java.io.Serializable;

public class UserCustomerEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    private Long userId;

    private Long customerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}