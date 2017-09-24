package com.scopeweaver.auth.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.domain.Persistable;

/**
 * Any auditable persistable entity must implement this interface.
 * 
 * @author vineet
 *
 */
public interface AuditablePersistable extends Persistable<UUID> {

    Date getModifiedOn();

    User getModifiedBy();
}
