package cn.com.fangself.web;

public class Member {

	private int id;
	private String memberuuid;
	private String username;
	private String userpwd;
	private String email;
	private String phonenum;
	private int    sex;
	private String realname;
	private String address;
	private String postcode ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMemberuuid() {
		return memberuuid;
	}
	public void setMemberuuid(String memberuuid) {
		this.memberuuid = memberuuid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", memberuuid=" + memberuuid + ", username=" + username + ", userpwd=" + userpwd
				+ ", email=" + email + ", phonenum=" + phonenum + ", sex=" + sex + ", realname=" + realname
				+ ", address=" + address + ", postcode=" + postcode + "]";
	}
	
}
