package vn.sourcecode.dto;

public class Customer {
		private String txtAccount;
		private String password;
		private String txtName;
		private String txtMobile;
		private String txtEmail;
		private String txtAddress;
		private boolean remember;
		
		public Customer() {
			super();
		}
		public Customer(String txtAccount, String password, String txtName, String txtMobile, String txtEmail,
				String txtAddress, boolean remember) {
			super();
			this.txtAccount = txtAccount;
			this.password = password;
			this.txtName = txtName;
			this.txtMobile = txtMobile;
			this.txtEmail = txtEmail;
			this.txtAddress = txtAddress;
			this.remember = remember;
		}
		public String getTxtAccount() {
			return txtAccount;
		}
		public void setTxtAccount(String txtAccount) {
			this.txtAccount = txtAccount;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getTxtName() {
			return txtName;
		}
		public void setTxtName(String txtName) {
			this.txtName = txtName;
		}
		public String getTxtMobile() {
			return txtMobile;
		}
		public void setTxtMobile(String txtMobile) {
			this.txtMobile = txtMobile;
		}
		public String getTxtEmail() {
			return txtEmail;
		}
		public void setTxtEmail(String txtEmail) {
			this.txtEmail = txtEmail;
		}
		public String getTxtAddress() {
			return txtAddress;
		}
		public void setTxtAddress(String txtAddress) {
			this.txtAddress = txtAddress;
		}
		public boolean isRemember() {
			return remember;
		}
		public void setRemember(boolean remember) {
			this.remember = remember;
		}
		
}
