package com.hdu.jersey.dao;

import java.util.ArrayList;

import com.hdu.jersey.model.SchoolInfo;

/**
 * @author zhuxin
 * ѧУ��ϢDAO������
 *
 */
public interface SchoolInfoDAO {

	/**
	 * ���
	 * @param info school����
	 * @return ִ�н��1,0
	 */
	int add(SchoolInfo info);
	
	/**ɾ��
	 * @param id ѧУid
	 * @return ����1,0
	 */
	int delete(String id);
	
	/**�޸�
	 * @return
	 */
	@Deprecated
	int modify();
	
	/**
	 * ��ȡ����ѧУ��ϢList
	 * @return
	 */
	ArrayList<SchoolInfo> listSchools();
	
	/**
	 * ��ȡ�ض���Ϣ
	 * @param school_num ѧУ���
	 * @return ѧУ����
	 */
	SchoolInfo getInfoByNum(String school_num);
}
