package cn.com.fangself.dao;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.omg.CORBA.portable.InputStream;

import cn.com.fangself.mapper.UserMapper;

public class SqlSessionManager {

	String resource = "mybatis-config.xml";
	
	SqlSessionFactory sqlSessionFactory = null;
	
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
	private Message fillMemberEntryThenReturnMessage(String names ,String value , Member member){
		Message message = new Message();
		String messtr = new String("并没有留下什么");
		message.setMsg(messtr);
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
		 break;}
		default:{break;}
		}
		message.setMsg(messtr);
		return message;
	}
	public void insertAMemberAndMessage(HashMap<String,String> memberHash){
		Member member = new Member();
		Message message =null;
		SqlSession sqlsession = this.sqlSessionFactory.openSession();
		sqlsession.getMapper(UserMapper.class);
		for(java.util.Iterator<Entry<String, String>> it = memberHash.entrySet().iterator();it.hasNext();){
			Map.Entry<String, String> entry = it.next();
			String names = entry.getKey();
			String value = entry.getValue();
			if(names==null||names.equals("")){
				throw new RuntimeException();
			}
			message = this.fillMemberEntryThenReturnMessage(names, value, member);
		}
			member.setMemberuuid("uuid");
			member.setPhonenum("10");
			member.setPostcode("123456");
		System.out.println(member);
		Integer memberID = sqlsession.insert("insertAMember",member);
		message.setMemberid(memberID);
		System.out.println(message);
		sqlsession.insert("insertAMessage",message);
		sqlsession.commit();
		sqlsession.clearCache();
		sqlsession.close();
	}
	
}
