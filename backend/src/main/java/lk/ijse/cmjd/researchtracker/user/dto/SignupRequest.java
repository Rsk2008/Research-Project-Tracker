package lk.ijse.cmjd.researchtracker.user.dto;
public class SignupRequest {
    private String username;
    private String password;
    private String fullName;
    public String getUsername(){return username;}
    public void setUsername(String v){this.username=v;}
    public String getPassword(){return password;}
    public void setPassword(String v){this.password=v;}
    public String getFullName(){return fullName;}
    public void setFullName(String v){this.fullName=v;}
}
