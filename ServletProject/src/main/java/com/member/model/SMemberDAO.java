package com.member.model;

import java.util.ArrayList;

public interface SMemberDAO {
    public void memberJoin(SMemberDTO member);//�߰�
	public ArrayList<SMemberDTO> getMember();//��ü����
	public void memberDelete(String userid);//����
	public void memberUpdate(SMemberDTO member);//����
	public SMemberDTO findById(String userid);//�󼼺���
	public int memberCount();//ȸ����
	public String memberIdCheck(String userid);//���̵��ߺ�Ȯ��
	public SMemberDTO memberLoginCheck(String userid, String pwd);//�α���
}
  