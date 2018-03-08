package com.sam.app.dto;


import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"companyid",
"loginid",
"passwd",
"username",
"role",
"id",
"isLogin"
})
public class AppCommonBean {

@JsonProperty("companyid")
private Integer companyid;
@JsonProperty("loginid")
private String loginid;
@JsonProperty("passwd")
private String passwd;
@JsonProperty("username")
private String userName;
@JsonProperty("role")
private String role;
@JsonProperty("id")
private Integer id;
@JsonProperty("isLogin")
private Boolean isLogin;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("companyid")
public Integer getCompanyid() {
return companyid;
}

@JsonProperty("companyid")
public void setCompanyid(Integer companyid) {
this.companyid = companyid;
}

@JsonProperty("loginid")
public String getLoginid() {
return loginid;
}

@JsonProperty("loginid")
public void setLoginid(String loginid) {
this.loginid = loginid;
}

@JsonProperty("passwd")
public String getPasswd() {
return passwd;
}

@JsonProperty("passwd")
public void setPasswd(String passwd) {
this.passwd = passwd;
}

@JsonProperty("username")
public String getUserName() {
return userName;
}

@JsonProperty("username")
public void setUserName(String userName) {
this.userName = userName;
}

@JsonProperty("role")
public String getRole() {
return role;
}

@JsonProperty("role")
public void setRole(String role) {
this.role = role;
}

@JsonProperty("id")
public Integer getId() {
return id;
}

@JsonProperty("id")
public void setId(Integer id) {
this.id = id;
}

@JsonProperty("isLogin")
public Boolean getIsLogin() {
return isLogin;
}

@JsonProperty("isLogin")
public void setIsLogin(Boolean isLogin) {
this.isLogin = isLogin;
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