package api.payload;

public class ApiUserModel {
    public Integer UserId;
    public String Name;
    public String Email;
    public String Password;
    public String Location;

    public void setUserId(int userId) {
        this.UserId = userId;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public void setLocation(String location) {
        this.Location = location;
    }
}
