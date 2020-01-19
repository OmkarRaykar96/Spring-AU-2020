package JDBC;

public class Doctor {
	
	int d_id, p_id, p_d_id;
	String d_name,p_name;
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public int getP_d_id() {
		return p_d_id;
	}
	public void setP_d_id(int p_d_id) {
		this.p_d_id = p_d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	@Override
	public String toString() {
		return "Doctor [d_id=" + d_id + ", p_id=" + p_id + ", p_d_id=" + p_d_id + ", d_name=" + d_name + ", p_name="
				+ p_name + "]";
	}
	
}