package DAO;

import Models.ConnectionSQL;
import entities.Member;

public class Repositories {

	public void createMember(Member newMember) {

		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "INSERT INTO Member values(?,?,?,?,?,?,?)";
		String[] parameters = { newMember.getFullName(), String.valueOf(newMember.getAge()),
				String.valueOf(newMember.getGender()), newMember.getPhoneNum(), newMember.getAddress(),
				String.valueOf(newMember.getNumOf_BorrBook()), String.valueOf(newMember.getStatus()) };
		conn.Create(str, parameters);
	}

	public void deleteMemberByID(int id) {
		ConnectionSQL conn = new ConnectionSQL();
		conn.Connect();
		String str = "Delete from Member where id =?";
		String[] parameters = { String.valueOf(id) };
		conn.DeleteById(str, parameters);

	}
}
