package com.movieswatch.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the permissions_roles database table.
 * 
 */
@Entity
@Table(name="permissions_roles")
@NamedQuery(name="PermissionsRole.findAll", query="SELECT p FROM PermissionsRole p")
public class PermissionsRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PERMISSON_ROLE", unique=true, nullable=false)
	private int idPermissonRole;

	//bi-directional many-to-one association to Permission
	@ManyToOne
	@JoinColumn(name="ID_PERMISSION", nullable=false)
	private Permission permission;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="ID_ROLE", nullable=false)
	private Role role;

	public PermissionsRole() {
	}

	public int getIdPermissonRole() {
		return this.idPermissonRole;
	}

	public void setIdPermissonRole(int idPermissonRole) {
		this.idPermissonRole = idPermissonRole;
	}

	public Permission getPermission() {
		return this.permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}