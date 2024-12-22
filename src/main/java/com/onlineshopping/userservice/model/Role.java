package com.onlineshopping.userservice.model;

public enum Role {
    ROLE_USER("ROLE_USER"),ROLE_ADMIN("ROLE_ADMIN");
   private String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
