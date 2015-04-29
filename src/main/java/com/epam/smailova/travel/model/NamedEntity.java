package com.epam.smailova.travel.model;

import java.util.UUID;

public class NamedEntity extends BaseEntity {

    private String name;

    public NamedEntity(UUID uuid) {
        super(uuid);

    }

    public NamedEntity() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+"  id "+super.getId()+
                "  name "+getName();
    }
}
