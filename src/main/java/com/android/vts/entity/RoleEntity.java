package com.android.vts.entity;

import static com.googlecode.objectify.ObjectifyService.ofy;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Cache
@Entity
@EqualsAndHashCode(of = "role")
@NoArgsConstructor
public class RoleEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private String role;

  /** When this record was created or updated */
  @Getter
  Date updated;

  /** Construction function for UserEntity Class */
  public RoleEntity(String roleName) {
    this.role = roleName;
  }

  /** Get role by email */
  public static RoleEntity getRole(String role) {
    return ofy().load()
        .type(RoleEntity.class)
        .id(role)
        .now();
  }

  /** Saving function for the instance of this class */
  public void save() {
    this.updated = new Date();
    ofy().save().entity(this).now();
  }
}