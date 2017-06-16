package cn.com.fangself.dao;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.omg.CORBA.portable.InputStream;

import cn.com.fangself.mapper.UserMapper;

public class SqlSessionManager {

	String resource = "mybatis-config.xml";
	
	public SqlSessionFactory sqlSessionFactory = null;
	
	public SqlSessionManager(){
		try {
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
			this.sqlSessionFactory  =sqlSessionFactory;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void insertAUser(String remoteIp){
		SqlSession sqlsession = this.sqlSessionFactory.openSession();
		sqlsession.getMapper(UserMapper.class);
		sqlsession.insert("insertUipIntoUserTable",remoteIp);
		sqlsession.commit();
		sqlsession.clearCache();
		sqlsession.close();
	}
	public int CountAUser(String remoteIp){
		SqlSession sqlsession = this.sqlSessionFactory.openSession();
		sqlsession.getMapper(UserMapper.class);
		int result = sqlsession.selectOne("countUipFromUserrTable",remoteIp);
		sqlsession.commit();
		sqlsession.clearCache();
		sqlsession.close();
		return result;
	}
	private void fillMemberEntryThenReturnMessage(Message message,String names ,String value , Member member){
		String messtr = null;
		switch(names){
		case "memberuuid":{
				if(value==null){value="null";}else{
					member.setMemberuuid(value);
				}break;
			}
		case "username":{
				if(value==null){value="null";}else{
					member.setUsername(value);
				}break;
			}
		case "userpwd":{
				if(value==null){value="null";}else{
					member.setUserpwd(value);
				}break;
			}
		case "email":{
				if(value==null){value="null";}else{
					member.setEmail(value);
				}break;
			}
		case "phonenum":{
				if(value==null){value="null";}else{
					member.setPhonenum(value);
				}
			break;
			}
		case "sex":{
				if(value==null){value="null";}else{
					Integer sexInt  = 0;
					try{
						sexInt= Integer.parseInt(value);
					}catch(ClassCastException e){
					}
					member.setSex(sexInt);
				}
			break;}
		case "realname":{
				if(value == null){value="null";}else{
					member.setRealname(value);
				}
			break;
		}
		case "address":{
				if(value==null){value="null";}else{
					member.setAddress(value);
				}
			break;
		}
		case "postcode":{
			System.out.println("guo lv post code");
				if(value==null){value="null";}else{
					member.setPostcode(value);
				}
			break;
			}
		case "message":{ 
			System.out.println("value ==="+ value);
			messtr =new String(value);
			message.setMsg(messtr);
		 break;}
		default:{break;}
		}
	}
	public void insertAMemberAndMessage(Hashtable<String,String> memberHash){
		Member member = new Member();
		Message message =new Message();
		SqlSession sqlsession = this.sqlSessionFactory.openSession();
		sqlsession.getMapper(UserMapper.class);
		for(java.util.Iterator<Entry<String, String>> it = memberHash.entrySet().iterator();;){
			Map.Entry<String, String> entry = it.next();
			String names = entry.getKey();
			String value = entry.getValue();
			try {
				value = new String(value.getBytes("ISO-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
			}
			if(names==null||names.equals("")){
				throw new RuntimeException();
			}
			this.fillMemberEntryThenReturnMessage(message,names, value, member);
			if(!it.hasNext()){
				break;
			}
		}
		
		UUID uuid = UUID.randomUUID();
		member.setMemberuuid(uuid.toString());
		if(member.getPhonenum()==null)member.setPhonenum("000-000-000");
		if(member.getUsername()==null)member.setUsername("未命名");
		if(member.getUserpwd()==null)member.setUserpwd("none");
		if(member.getEmail()==null)member.setEmail("---111-000-111-000@110.com---");
		if(message.getMsg()==null)message.setMsg("并没有留下什么");
		Integer memberID = sqlsession.insert("insertAMember",member);
		//System.out.println(member);
		message.setMemberid(memberID);
		sqlsession.insert("insertAMessage",message);
		sqlsession.commit();
		sqlsession.clearCache();
		sqlsession.close();
	}
	
}
