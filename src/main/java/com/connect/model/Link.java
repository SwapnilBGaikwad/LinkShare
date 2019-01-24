package com.connect.model;

import java.util.Objects;

public class Link {
    private String identifier;

    public Link(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return Objects.equals(identifier, link.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }
}
