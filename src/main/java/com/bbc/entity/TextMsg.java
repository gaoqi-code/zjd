package com.bbc.entity;

public class TextMsg {
	private String ToUserName;    //������΢�ź�
    private String FromUserName;  //���ͷ��ʺţ�һ��OpenID��
    private long CreateTime;      //��Ϣ����ʱ�� �����ͣ�
    private String MsgType;       //text
    private String Content;       //�ı���Ϣ����
    private String MsgId;         //��Ϣid��64λ����
    
    //getter and setter
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long l) {
		CreateTime = l ;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
}
