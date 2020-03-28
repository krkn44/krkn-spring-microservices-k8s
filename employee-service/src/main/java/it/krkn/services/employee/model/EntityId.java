package it.krkn.services.employee.model;

import java.io.Serializable;

public interface EntityId<ID> extends Serializable {

    public ID getId();

    public void setId(ID id);

}
