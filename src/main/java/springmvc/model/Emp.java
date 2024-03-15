package springmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Emp {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int employeeNo;
    private String name;
    private String cnic; // Changed type to String
    private String email;
    private String mobileNo; // Changed type to String
    private String address;

    public Emp() {
        super();
    }

    public Emp(int employeeNo, String name, String cnic, String email, String mobileNo, String address) {
        super();
        this.employeeNo = employeeNo;
        this.name = name;
        this.cnic = cnic;
        this.email = email;
        this.mobileNo = mobileNo;
        this.address = address;
    }

    public int getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

	@Override
	public String toString() {
		return "Emp [employeeNo=" + employeeNo + ", name=" + name + ", cnic=" + cnic + ", email=" + email
				+ ", mobileNo=" + mobileNo + ", address=" + address + "]";
	}
    
    
}
