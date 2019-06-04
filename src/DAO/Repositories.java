package DAO;

import Models.ConnectionSQL;
import entities.Member;

public class Repositories {

	public void createMember(Member newMember) {

		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		byte stus = newMember.getStatus();
		String str = "INSERT INTO Member values(?,?,?,?,?,?,?)";
		String[] parameters = { newMember.getFullName(), String.valueOf(newMember.getAge()), newMember.getPhoneNum(),
				newMember.getAddress(), String.valueOf(newMember.getNumOf_BorrBook()) };
		conn.Create(str, parameters);
	}
}
