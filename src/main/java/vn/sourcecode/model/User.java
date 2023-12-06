package vn.sourcecode.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "tbl_user")
public class User extends BaseModel implements UserDetails {
	
	@Column(name = "username", length = 120, nullable = false)
	private String username;

	@Column(name = "password", length = 120, nullable = false)
	private String password;

	@Column(name = "name", length = 120, nullable = true)
	private String name;

	@Column(name = "email", length = 200, nullable = true)
	private String email;

	@Column(name = "mobile", length = 60, nullable = true)
	private String mobile;

	@Column(name = "address", length = 300, nullable = true)
	private String address;

	@Column(name = "description", length = 500, nullable = true)
	private String description;
	
	//-----------------------------------------tbl_user-to-tbl_product(Create_by and update_by)---------------------------------------
		//---------------Mapping one-to-many:user-to-product(for user create product)
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userCreateProduct")
		private Set<Product> userCreateProducts = new HashSet<Product>();
		
		public Set<Product> getUserCreateProducts() {
			return userCreateProducts;
		}
		public void setUserCreateProducts(Set<Product> userCreateProducts) {
			this.userCreateProducts = userCreateProducts;
		}
		
		//---------------Mapping one-to-many:user-to-product(for user update product)
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userUpdateProduct")
		private Set<Product> userUpdateProducts = new HashSet<Product>();
		
		public Set<Product> getUserUpdateProducts() {
			return userUpdateProducts;
		}
		public void setUserUpdateProducts(Set<Product> userUpdateProducts) {
			this.userUpdateProducts = userUpdateProducts;
		}
		
	//-------------------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------tbl_user-to-tbl_category(Create_by and update_by)---------------------------------------
		//---------------Mapping one-to-many:user-to-product(for user create category)
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userCreateCategory")
		private Set<Category> userCreateCategories = new HashSet<Category>();
			
		public Set<Category> getUserCreateCategories() {
			return userCreateCategories;
		}
		public void setUserCreateCategories(Set<Category> userCreateCategories) {
			this.userCreateCategories = userCreateCategories;
		}

		//---------------Mapping one-to-many:user-to-product(for user update category)
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userUpdateCategory")
		private Set<Category> userUpdateCategories = new HashSet<Category>();
		
		public Set<Category> getUserUpdateCategories() {
			return userUpdateCategories;
		}
		public void setUserUpdateCategories(Set<Category> userUpdateCategories) {
			this.userUpdateCategories = userUpdateCategories;
		}
		
		//-------------------------------------------------------------------------------------------------------------------------------

		//-----------------------------------------tbl_user-to-tbl_user(Create_by and Update_by)-----------------------------------------
		// ---------------Mapping many-to-One: user-create_by-user----------------
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "create_by")
		private User userCreateUser;

		// ---------------Mapping many-to-One: user-update_by-user----------------
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "update_by")
		private User userUpdateUser;

		// --------------Mapping one-to-many: user-to-user(for user create user)
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userCreateUser")
		private Set<User> userCreateUsers = new HashSet<User>();
		public Set<User> getUserCreateUsers() {
			return userCreateUsers;
		}

		public void setUserCreateUsers(Set<User> userCreateUsers) {
			this.userCreateUsers = userCreateUsers;
		}

		// --------------Mapping one-to-many: user-to-user(for user update user)
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userUpdateUser")
		private Set<User> userUpdateUsers = new HashSet<User>();
		public Set<User> getUserUpdateUsers() {
			return userUpdateUsers;
		}

		public void setUserUpdateUsers(Set<User> userUpdateUsers) {
			this.userUpdateUsers = userUpdateUsers;
		}
	//-------------------------------------------------------------------------------------------------------------------------------
		
	// ------------------Mapping many-to-many: tbl_user-to-tbl_role----------------------------
		@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "users")
		private List<Role> roles = new ArrayList<Role>();
		// Methods add and remove Elements in relational tbl_user_role
				public void addRelationalUserRole(Role role) {
					role.getUsers().add(this);
					roles.add(role);
				}
				public void removeRelationalUserRole(Role role) {
					role.getUsers().add(this);
					roles.remove(role);
				}
	// -----------------------------------------------------------------------------------------
//-----------------------------------------tbl_user-to-tbl_role(Create_by and Update_by)-----------------------------------------
	// --------------Mapping many-to-many: user-to-role(for user create role)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userCreateRole")
	private Set<Role> userCreateRoles = new HashSet<Role>();

	public Set<Role> getUserCreateRoles() {
		return userCreateRoles;
	}
	public void setUserCreateRoles(Set<Role> userCreateRoles) {
		this.userCreateRoles = userCreateRoles;
	}

	// --------------Mapping many-to-many: user-to-role(for user update role)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userUpdateRole")
	private Set<Role> userUpdateRoles = new HashSet<Role>();
	
	public Set<Role> getUserUpdateRoles() {
		return userUpdateRoles;
	}
	public void setUserUpdateRoles(Set<Role> userUpdateRoles) {
		this.userUpdateRoles = userUpdateRoles;
	}
// -----------------------------------------------------------------------------------------
	// ------------------Mapping one-to-many: tbl_user-to-tbl_sale_order-------------------------
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
		private Set<SaleOrder> saleorders = new HashSet<SaleOrder>();
		// Methods add and remove Elements in relational tbl_sale_order
			public void addRelationalSaleOrder(SaleOrder saleorder) {
				saleorders.add(saleorder);
				saleorder.setUser(this);
			}
			public void removeRelationalSaleOrder(SaleOrder saleorder) {
				saleorders.remove(saleorder);
				saleorder.setUser(null);
			}
	//--------------------------------------------------------------------------------------------
	
		
			
	public User getUserCreateUser() {
		return userCreateUser;
	}

	public void setUserCreateUser(User userCreateUser) {
		this.userCreateUser = userCreateUser;
	}

	public User getUserUpdateUser() {
		return userUpdateUser;
	}

	public void setUserUpdateUser(User userUpdateUser) {
		this.userUpdateUser = userUpdateUser;
	}


	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.roles;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
