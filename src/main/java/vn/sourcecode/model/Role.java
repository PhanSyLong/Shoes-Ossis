package vn.sourcecode.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;


@Entity
@Table(name = "tbl_role")
public class Role extends BaseModel implements GrantedAuthority {

	@Column(name = "name", length = 200, nullable = false)
	private String name;

	@Column(name = "description", length = 300, nullable = true)
	private String description;
	
	//--------------- Mapping many-to-many: tbl_roles-to-tbl_user-----------------
		// First side: owner (user has some roles)
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "tbl_user_role", joinColumns  = @JoinColumn(name = "role_id"),
				inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users = new ArrayList<User>();
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	//----------------------------------------------------------------------------------
	//-----------------------------------------tbl_Role-to-tbl_User(Create_by and Update_by)--------------------------------------------
		//---------------Mapping many-to-many: role-create_by-user----------------------------------
			@ManyToOne(fetch = FetchType.EAGER)
			@JoinColumn(name =	"create_by")
			private User userCreateRole;
			public User getUserCreateRole() {
				return userCreateRole;
			}
			public void setUserCreateRole(User userCreateRole) {
				this.userCreateRole = userCreateRole;
			}
		//---------------Mapping many-to-many: Role-update_by-user----------------------------------
			@ManyToOne(fetch = FetchType.EAGER)
			@JoinColumn(name =	"update_by")
			private User userUpdateRole;
			public User getUserUpdateRole() {
				return userUpdateRole;
			}
			public void setUserUpdateRole(User userUpdateRole) {
				this.userUpdateRole = userUpdateRole;
			}
		//-------------------------------------------------------------------------------------------------------------------------------------

	public Role() {
		super();
	}

	public Role(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getAuthority() {
		// Tra ve ten role
			return this.name;
	}
	
}
