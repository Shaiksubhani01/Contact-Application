package in.ezeon.capp.domain;

public class Contact {
	private Integer contactId;// pk
	private Integer userId;// fk
	private String name;
	private String email;
	private String address;
	private String phone;
	private String remark;

	public Contact() {

	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", userId=" + userId + ", name=" + name + ", email=" + email
				+ ", address=" + address + ", phone=" + phone + ", remark=" + remark + "]";
	}

	

}
