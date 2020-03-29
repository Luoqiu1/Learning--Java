package school_works;

public class Address {
	protected String country;
	protected String province;
	protected String city;
	protected String street;
	protected String company;
	protected String postcode;
	public Address(String country, String province, String city, String street, String company, String postcode) {
		this.country = country;
		this.province = province;
		this.city = city;
		this.street = street;
		this.company = company;
		this.postcode = postcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String toString() {
		return "Address [country=" + country + ", province=" + province + ", city=" + city + ", street=" + street
				+ ", company=" + company + ", postcode=" + postcode + "]";
	}
	
	public static void main(String[] args) {
		OverseasAddress overseasAddress = new OverseasAddress("中国",
				"湖南省","通道侗族自治县","双江镇城南街83号",
				"国税局","418500");
		System.out.println("国外格式");
		System.out.println(overseasAddress.toString());
		HomeAddress homeAddress = new HomeAddress("中国",
				"湖南省","通道侗族自治县","双江镇城南街83号",
				"国税局","418500");
		System.out.println("国内格式");
		System.out.println(homeAddress.toString());
	}
	
}

class OverseasAddress extends Address{

	public OverseasAddress(String country, String province, String city, String street, String company,
			String postcode) {
		super(country, province, city, street, company, postcode);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}


class HomeAddress extends Address{

	public HomeAddress(String country, String province, String city, String street, String company, String postcode) {
		super(country, province, city, street, company, postcode);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "地址 [国家=" + country + ", 省份=" + province + ", 城市=" + city + ", 街道=" + street
				+ ", 公司=" + company + ", 邮编=" + postcode + "]";
	}
}
