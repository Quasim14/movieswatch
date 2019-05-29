package com.movieswatch.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the permissions database table.
 * 
 */
@Entity
@Table(name="permissions")
@NamedQuery(name="Permission.findAll", query="SELECT p FROM Permission p")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PERMISSION", unique=true, nullable=false)
	private int idPermission;

	@Column(name="nom_permission", length=45)
	private String nomPermission;

	//bi-directional many-to-one association to PermissionsRole
	@OneToMany(mappedBy="permission")
	private List<PermissionsRole> permissionsRoles;

	public Permission() {
	}

	public int getIdPermission() {
		return this.idPermission;
	}

	public void setIdPermission(int idPermission) {
		this.idPermission = idPermission;
	}

	public String getNomPermission() {
		return this.nomPermission;
	}

	public void setNomPermission(String nomPermission) {
		this.nomPermission = nomPermission;
	}

	public List<PermissionsRole> getPermissionsRoles() {
		return this.permissionsRoles;
	}

	public void setPermissionsRoles(List<PermissionsRole> permissionsRoles) {
		this.permissionsRoles = permissionsRoles;
	}

	public PermissionsRole addPermissionsRole(PermissionsRole permissionsRole) {
		getPermissionsRoles().add(permissionsRole);
		permissionsRole.setPermission(this);

		return permissionsRole;
	}

	public PermissionsRole removePermissionsRole(PermissionsRole permissionsRole) {
		getPermissionsRoles().remove(permissionsRole);
		permissionsRole.setPermission(null);

		return permissionsRole;
	}

}