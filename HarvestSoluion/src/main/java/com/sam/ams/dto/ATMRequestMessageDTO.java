package com.sam.ams.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"inputmsgid",
"termid",
"msgtype",
"msgxdate",
"msgxtime",
"msgdata",
"msglen"
})
public class ATMRequestMessageDTO implements Serializable
{

@JsonProperty("inputmsgid")
private Integer inputmsgid;
@JsonProperty("termid")
private String termid;

@JsonProperty("category")
private String category;
@JsonProperty("msgtype")
private String msgtype;
@JsonProperty("msgxdate")
private String msgxdate;
@JsonProperty("msgxtime")
private String msgxtime;
@JsonProperty("msgdata")
private String msgdata;
@JsonProperty("msglen")
private Integer msglen;
@JsonIgnore
@Valid
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private final static long serialVersionUID = -6901426642902166803L;

@Override
public String toString()
{
	return "termid:"+termid+"|msgtype:"+msgtype+
			"msgxdate:"+msgxdate+"|msgxtime:"+msgxtime+
			"msglen:"+msglen+"|msgdata:"+msgdata;
}

@JsonProperty("inputmsgid")
public Integer getInputmsgid() {
return inputmsgid;
}

@JsonProperty("inputmsgid")
public void setInputmsgid(Integer inputmsgid) {
this.inputmsgid = inputmsgid;
}

@JsonProperty("category")
public String getCategory() {
return category;
}

@JsonProperty("category")
public void setCategory(String category) {
this.category = category;
}

@JsonProperty("termid")
public String getTermid() {
return termid;
}

@JsonProperty("termid")
public void setTermid(String termid) {
this.termid = termid;
}

@JsonProperty("msgtype")
public String getMsgtype() {
return msgtype;
}

@JsonProperty("msgtype")
public void setMsgtype(String msgtype) {
this.msgtype = msgtype;
}

@JsonProperty("msgxdate")
public String getMsgxdate() {
return msgxdate;
}

@JsonProperty("msgxdate")
public void setMsgxdate(String msgxdate) {
this.msgxdate = msgxdate;
}

@JsonProperty("msgxtime")
public String getMsgxtime() {
return msgxtime;
}

@JsonProperty("msgxtime")
public void setMsgxtime(String msgxtime) {
this.msgxtime = msgxtime;
}

@JsonProperty("msgdata")
public String getMsgdata() {
return msgdata;
}

@JsonProperty("msgdata")
public void setMsgdata(String msgdata) {
this.msgdata = msgdata;
}

@JsonProperty("msglen")
public Integer getMsglen() {
return msglen;
}

@JsonProperty("msglen")
public void setMsglen(Integer msglen) {
this.msglen = msglen;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
