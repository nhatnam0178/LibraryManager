package entities;

public class Member {
	private int ID;

// ID
	public void setID(int value) {
		ID = value;
	}

	public int getID() {
		return ID;
	}

	private String FullName;

// FullName
	public void setFullName(String value) {
		FullName = value;
	}

	public String getFullName() {
		return FullName;
	}

	private int Age;

// Age
	public void setAge(int value) {
		Age = value;
	}

	public int getAge() {
		return Age;
	}

	private byte Gender;

// Gender
	public void setGender(byte value) {
		Gender = value;
	}

	public byte getGender() {
		return Gender;
	}

	private String PhoneNum;

// PhoneNum
	public void setPhoneNum(String value) {
		PhoneNum = value;
	}

	public String getPhoneNum() {
		return PhoneNum;
	}

	private String Address;

// Address
	public void setAddress(String value) {
		Address = value;
	}

	public String getAddress() {
		return Address;
	}

	private int NumOf_BorrBook;

// NumOf_BorrBook
	public void setNumOf_BorrBook(int value) {
		NumOf_BorrBook = value;
	}

	public int getNumOf_BorrBook() {
		return NumOf_BorrBook;
	}

	private byte Status;

// Status
	public void setStatus(byte value) {
		Status = value;
	}

	public byte getStatus() {
		return Status;
	}

	public Member(String fullName, int age, byte gender, String phoneNum, String address, int numOf_BorrBook,
			byte status) {
		super();

		FullName = fullName;
		Age = age;
		Gender = gender;
		PhoneNum = phoneNum;
		Address = address;
		NumOf_BorrBook = numOf_BorrBook;
		Status = status;
	}

}
