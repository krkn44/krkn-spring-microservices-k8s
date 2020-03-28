package it.krkn.services.organization.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity<ID> implements EntityId<ID> {
	
	@Transient
	private String uuid = UUID.randomUUID().toString();

    @JsonIgnore
    @Column(name = "CREATED_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date creationTime;

    @JsonIgnore
    @Column(name = "LAST_MODIFIED_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date modificationTime;

    @JsonIgnore
    @Version
    private Long version;

    public Date getCreationTime() {
        return creationTime;
    }

    public BaseEntity<ID> setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
        return this;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public BaseEntity<ID> setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
        return this;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? uuid.hashCode() : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {			
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		BaseEntity other = (BaseEntity) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			} else {
				return other.uuid.equals(this.uuid);
			}
		} else if (!this.getId().equals(other.getId())) {
			return false;
		}
		return true;
	}
	
}
