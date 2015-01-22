package com.hibernateExample.entity;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;

public class EMailList implements UserType {
	
	private List emails;
	
	private static final char SPLITTER = ';';
	
	private static final int[] TYPES = new int[] {Types.VARCHAR};
	
	@Override
	public Object assemble(Serializable arg0, Object arg1) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		List sourcelist = (List)value;
		List targetlist = new ArrayList();
		targetlist.addAll(sourcelist);
		return targetlist;
	}

	@Override
	public Serializable disassemble(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		
		if ( x == y ) {
			return true;
		}
		
		if (x != null && y != null) {
	        List xList = (List)x;
	        List yList = (List)y;
	        
	        if (xList.size() != yList.size()) {
	        	return false;
	        }
	        
	        for (int i = 0; i < xList.size(); i++) {
	            String str1 = (String)xList.get(i);
	            String str2 = (String)yList.get(i);
	            if (!str1.equals(str2)) {
	                return false;
                }
            }
	        return true;
        }
		return false;
	}

	@Override
	public int hashCode(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (非 Javadoc) 
	* <p>Title: nullSafeGet</p> 
	* <p>
	* 	从resultSet中取出Email字段，并将其解析为List类型后返回
	*  /p> 
	* @param arg0
	* @param arg1
	* @param arg2
	* @return
	* @throws HibernateException
	* @throws SQLException 
	* @see org.hibernate.usertype.UserType#nullSafeGet(java.sql.ResultSet, java.lang.String[], java.lang.Object)
	 */
	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException {
		// TODO Auto-generated method stub
		String value = (String) Hibernate.STRING.nullSafeGet(rs, names[0]);
		if (value != null) {
			return parse(value);
		} else {
			return null;
		}
	}
	
	/*
	 * 将String拼装为一个字符串，以“：”分隔
	 */
	private List parse(String value) {
		String[] strs = StringUtils.split(value, SPLITTER);
		List emailList = new ArrayList();
		for (int i = 0; i < strs.length; i++) {
			emailList.add(strs[i]);
        }
		return emailList;
	}

	/*
	 * (非 Javadoc) 
	* <p>Title: nullSafeSet</p> 
	* <p>
	* 	将List型的email信息组装成字符串之后保存到email字段中
	* </p> 
	* @param arg0
	* @param arg1
	* @param arg2
	* @throws HibernateException
	* @throws SQLException 
	* @see org.hibernate.usertype.UserType#nullSafeSet(java.sql.PreparedStatement, java.lang.Object, int)
	 */
	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Set methos executed");
		if (value != null) {
			String str = assemble((List)value);
			Hibernate.STRING.nullSafeSet(st, str, index);
		} else {
			Hibernate.STRING.nullSafeSet(st, value, index);
		}
	}
	
	/*
	 * 将String拼装为一个字符串，以“：”分隔
	 */
	public String assemble(List emailList) {
		StringBuffer strBuf = new StringBuffer();
		for (int i = 0; i < emailList.size(); i++) {
			strBuf.append(emailList.get(i)).append(SPLITTER);
        }
		strBuf.append(emailList.get(emailList.size() - 1));
		return strBuf.toString();
	}

	@Override
	public Object replace(Object arg0, Object arg1, Object arg2) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class returnedClass() {
		// TODO Auto-generated method stub
		return List.class;
	}

	@Override
	public int[] sqlTypes() {
		// TODO Auto-generated method stub
		return TYPES;
	}

}
