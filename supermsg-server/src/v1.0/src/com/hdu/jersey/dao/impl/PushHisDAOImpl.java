package com.hdu.jersey.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hdu.jersey.model.PushHisModel;
import com.hdu.mybatis.utils.MybatisUtils;

public class PushHisDAOImpl {
	
	private final static String STATEMENT_ADD_PUSH_HIS = "com.hdu.jersey.model.addPushHisModel";
	private final static String STATEMENT_QUERY_ALL_HIS = "com.hdu.jersey.model.queryAll";
	

	/**
	 * @param model �û�model
	 * 
	 * @return ���� ������������Ϊ0�����ǲ���ʧ��
	 * */
	public int add(PushHisModel model){
		SqlSession session = MybatisUtils.getSession();
		int n = session.insert(STATEMENT_ADD_PUSH_HIS, model);
		session.commit();
		session.close();
		return n;
		
	}
	
	/**
	 *  ��ѯ���е�������ʷ
	 */
	public List<PushHisModel> selectAll(){
		SqlSession session = MybatisUtils.getSession();
		List<PushHisModel> list = session.selectList(STATEMENT_QUERY_ALL_HIS);
		
		return list;
//		System.out.println(list.get(0).getCreateTime());
//		session.select(STATEMENT_QUERY_ALL_HIS, null);
		
	}
	public static void main(String[] args) {
//		new PushHisDAOImpl().add(new PushHisModel("123456789", "1033614108438", "tags", "ctx", false));
		new PushHisDAOImpl().selectAll();
	}

}
