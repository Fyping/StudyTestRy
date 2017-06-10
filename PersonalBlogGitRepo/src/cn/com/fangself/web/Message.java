package cn.com.fangself.web;

public class Message {
	
	private int msgid;
	private int memberid;
	private String msg;
	
	public int getMsgid() {
		return msgid;
	}
	public void setMsgid(int msgid) {
		this.msgid = msgid;
	}
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Message [msgid=" + msgid + ", memberid=" + memberid + ", msg=" + msg + "]";
	}
	
}
