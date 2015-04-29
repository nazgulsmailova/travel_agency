package com.epam.smailova.travel.model;

import java.util.UUID;

public abstract class BaseEntity {
    private final UUID uuid;
    private Integer id;
    private boolean deleted;



    public BaseEntity() {
        uuid = UUID.randomUUID();
    }

    public BaseEntity(UUID uuid) {
        this.uuid = uuid;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;

        BaseEntity that = (BaseEntity) o;

        return uuid.equals(that.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    public boolean isNew() {
        return (this.id == null);
    }
}


