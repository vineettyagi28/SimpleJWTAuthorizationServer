//package com.scopeweaver.auth.model;
//
//import java.util.Date;
//import java.util.UUID;
//
//import javax.persistence.PrePersist;
//import javax.persistence.PreUpdate;
//
//import org.springframework.data.annotation.Id;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
///**
// * @author vineet
// *
// */
//public abstract class AuditablePersistableEntity implements AuditablePersistable {
//
//	@Id
//	private UUID id;
//	private Date modifiedOn;
//	private User modifiedBy;
//
//	@Override
//	public UUID getId() {
//		return this.id;
//	}
//
//	@Override
//	public Date getModifiedOn() {
//		return this.modifiedOn;
//	}
//
//	@Override
//	public User getModifiedBy() {
//		return this.modifiedBy;
//	}
//
//	/**
//	 * @param id
//	 *            the id to set
//	 */
//	public void setId(UUID id) {
//		this.id = id;
//	}
//
//	/**
//	 * @param modifiedOn
//	 *            the modifiedOn to set
//	 */
//	@PrePersist
//	@PreUpdate
//	public void setModifiedOn() {
//		this.modifiedOn = new Date();
//	}
//
//	@JsonIgnore
//	@Override
//	public boolean isNew() {
//		if (id != null) {
//			return false;
//		} else {
//			return true;
//		}
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((modifiedOn == null) ? 0 : modifiedOn.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) {
//			return true;
//		}
//		if (obj == null) {
//			return false;
//		}
//		if (!(obj instanceof AuditablePersistableEntity)) {
//			return false;
//		}
//		AuditablePersistableEntity other = (AuditablePersistableEntity) obj;
//		if (id == null) {// TODO Need to re-check this logic. Having doubt about this.
//			if (other.id != null) {
//				return false;
//			}
//		} else if (!id.equals(other.id)) {
//			return false;
//		}
//		if (modifiedOn == null) {
//			if (other.modifiedOn != null) {
//				return false;
//			}
//		} else if (!modifiedOn.equals(other.modifiedOn)) {
//			return false;
//		}
//		return true;
//	}
//
//}
