package com.member.model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DBConnection;


public class SMemberDAOImpl  implements SMemberDAO{
	private static SMemberDAO instance = new SMemberDAOImpl();
	public static SMemberDAO getInstance() {
		return instance;
	}
	
	//�Է�
	@Override
	public void memberJoin(SMemberDTO member) {
		Connection con = null;
		PreparedStatement ps = null;
	  	
		try {
			con =DBConnection.getConnection();
			String sql="insert into memberdb values(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getName());
			ps.setString(2, member.getUserid());
			ps.setString(3, member.getPwd());
			ps.setString(4, member.getEmail());
			ps.setString(5, member.getPhone());
			ps.setInt(6, member.getAdmin());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, ps, null, null);
		}
		
	} 

	//��ü����
	@Override
	public ArrayList<SMemberDTO> getMember() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<SMemberDTO> arr = new ArrayList<>();
		
		try {
			con = DBConnection.getConnection();
			String sql="select * from memberdb";
			st = con.createStatement();
			rs= st.executeQuery(sql);
			while(rs.next()) {
				SMemberDTO dto = new SMemberDTO();
				dto.setAdmin(rs.getInt("admin"));
				dto.setEmail(rs.getString("email"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setPwd(rs.getString("pwd"));
				dto.setUserid(rs.getString("userid"));
				arr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null,st, rs);
		}
		return arr;
	}

	//����
	@Override
	public void memberDelete(String userid) {
		Connection con = null;
		Statement st = null;
		
		try {
			con = DBConnection.getConnection();
			String sql = "delete from memberdb where userid = '"+userid+"'";
			st = con.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//����
	@Override
	public void memberUpdate(SMemberDTO member) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DBConnection.getConnection();
			String sql = "update memberdb set name=?, pwd=?, admin=?, email=?, phone=? where userid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, member.getName());
			ps.setString(2, member.getPwd());
			ps.setInt(3, member.getAdmin());
			ps.setString(4, member.getEmail());
			ps.setString(5, member.getPhone());
			ps.setString(6, member.getUserid());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//�󼼺���
	@Override
	public SMemberDTO findById(String userid) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		SMemberDTO member = null;
		
		try {
			con = DBConnection.getConnection();
			String sql = "select * from memberdb where userid = '"+userid+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				member = new SMemberDTO();
				member.setAdmin(rs.getInt("admin"));
				member.setEmail(rs.getString("email"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setPwd(rs.getString("pwd"));
				member.setUserid(rs.getString("userid"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
		return member;
	}

	//����
	@Override
	public int memberCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			con = DBConnection.getConnection();
			String sql = "select count(*) from memberdb";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs); 
		}
		return count;
	}

	//���̵�üũ
	@Override
	public String memberIdCheck(String userid) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String flag = "yes";
		
		try {
			con = DBConnection.getConnection();
			String sql = "select * from memberdb where userid='"+userid+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				flag = "no";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	//�α���üũ
	@Override
	public SMemberDTO memberLoginCheck(String userid, String pwd) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		SMemberDTO member = new SMemberDTO();
		//��ȸ�� : -1
		member.setAdmin(-1);
		//ȸ�� : �Ϲ�ȸ��(1), ������(1)
		// ȸ�������� �������(2)
		
		try {
			con = DBConnection.getConnection();
			String sql = "select * from memberdb where userid = '"+userid+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) { // id ���� (ȸ���� ����)
			   if(rs.getString("pwd").equals(pwd)) { //��� ����
				   member.setAdmin(rs.getInt("admin"));
				   member.setEmail(rs.getString("email"));
				   member.setName(rs.getString("name"));
				   member.setPhone(rs.getString("phone"));
				   member.setPwd(rs.getString("pwd"));
				   member.setUserid(rs.getString("userid"));
			   }else { //��� Ʋ��
				   member.setAdmin(2);
			   }
				
			}
		} catch (Exception e) {
					e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
		return member;
	}
	//�ݱ�
		private void closeConnection(Connection con, 
				PreparedStatement ps, 	Statement st, ResultSet rs) {
			try {
				 if(rs!=null) rs.close();
				 if(st!=null) st.close();
				 if(ps!=null) ps.close();
				 if(con!=null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}

}
