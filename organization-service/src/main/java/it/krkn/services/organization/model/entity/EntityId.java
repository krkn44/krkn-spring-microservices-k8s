package it.krkn.services.organization.model.entity;

import java.io.Serializable;

public interface EntityId<ID> extends Serializable {

    public ID getId();

    public void setId(ID id);

}
