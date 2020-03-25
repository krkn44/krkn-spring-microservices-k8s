package it.krkn.services.department.model.entity;

import java.io.Serializable;

public interface EntityId<ID> extends Serializable {

    public ID getId();

    public void setId(ID id);

}
