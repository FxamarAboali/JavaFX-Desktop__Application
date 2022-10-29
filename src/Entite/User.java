
package Entite;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;


public class User {
    
    private int id;
       private String username;
    private String usernameCanonical;
    private String email;
    private String emailCanonical;
    private Integer enabled;
    private String salt;
    private String password;
    private String lastLogin;
    private String confirmationToken;
    private LocalDate passwordRequestedAt;
    private String roles;
    
    
    
    private String userName;
    private String lastname;
    private String pseudoName;
    private String userMail;
    private String userPassword;
    private String userPhone;
    private String userCin;
    private String userAddress;
    private String userPhoto;
    private Date userDayOfBirth;
    private String userSite;
    private Date createdAt;
    private String nationality;
    private String speciality;
    private String bio;

    public User(int id, String username, String usernameCanonical, String email, String emailCanonical, Integer enabled, String salt, String password, String lastLogin, String confirmationToken, LocalDate passwordRequestedAt, String roles, String userName, String lastname, String pseudoName, String userMail, String userPassword, String userPhone, String userCin, String userAddress, String userPhoto, Date userDayOfBirth, String userSite, Date createdAt, String nationality, String speciality, String bio) {
        this.id = id;
        this.username = username;
        this.usernameCanonical = usernameCanonical;
        this.email = email;
        this.emailCanonical = emailCanonical;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.lastLogin = lastLogin;
        this.confirmationToken = confirmationToken;
        this.passwordRequestedAt = passwordRequestedAt;
        this.roles = roles;
        this.userName = userName;
        this.lastname = lastname;
        this.pseudoName = pseudoName;
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userCin = userCin;
        this.userAddress = userAddress;
        this.userPhoto = userPhoto;
        this.userDayOfBirth = userDayOfBirth;
        this.userSite = userSite;
        this.createdAt = createdAt;
        this.nationality = nationality;
        this.speciality = speciality;
        this.bio = bio;
    }

                                                                     
 
    public User( String userName, String pseudoName, String userMail, String userPassword, String userPhone, String userCin, String userAddress, String userPhoto, Date userDayOfBirth, String userSite, Date createdAt, String nationality, String speciality, String bio, String roles) {
        
        this.userName = userName;
        this.pseudoName = pseudoName;
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userCin = userCin;
        this.userAddress = userAddress;
        this.userPhoto = userPhoto;
        this.userDayOfBirth = userDayOfBirth;
        this.userSite = userSite;
        this.createdAt = createdAt;
        this.nationality = nationality;
        this.speciality = speciality;
        this.bio = bio;
        this.roles = roles;
    }
    public User( int id,String userName, String pseudoName, String userMail, String userPassword,String roles) {
                this.id = id;

        this.userName = userName;
        this.pseudoName = pseudoName;
        this.userMail = userMail;
        this.userPassword = userPassword;

        this.roles = roles;
    }
                                                                     
      
    public User( String userName, String pseudoName, String userMail ,String userPhone, String userCin, String userAddress, Date userDayOfBirth, String userSite, Date createdAt, String nationality, String speciality, String bio, String role) {
        
        this.userName = userName;
        this.pseudoName = pseudoName;
        this.userMail = userMail;
        this.userPhone = userPhone;
        this.userCin = userCin;
        this.userAddress = userAddress;
        this.userDayOfBirth = userDayOfBirth;
        this.userSite = userSite;
        this.createdAt = createdAt;
        this.nationality = nationality;
        this.speciality = speciality;
        this.bio = bio;
        this.roles = roles;
    }                                                               
         
      public User(String username, String usernameCanonical, String email, String emailCanonical, String password, String roles, String userName, String pseudoName, String userMail ,String userPhone, String userCin, String userAddress, Date userDayOfBirth, String userSite, Date createdAt, String nationality, String speciality, String bio) {
        this.username = username;
        this.usernameCanonical = usernameCanonical;
        this.email = email;
        this.emailCanonical = emailCanonical;
        this.password = password;
        this.roles = roles;
          this.userName = userName;
        this.pseudoName = pseudoName;
        this.userMail = userMail;
        this.userPhone = userPhone;
        this.userCin = userCin;
        this.userAddress = userAddress;
        this.userDayOfBirth = userDayOfBirth;
        this.userSite = userSite;
        this.createdAt = createdAt;
        this.nationality = nationality;
        this.speciality = speciality;
        this.bio = bio;
    }
                                                                     
                                                                     
       public User(){
       };

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPseudoName() {
        return pseudoName;
    }

    public String getUserMail() {
        return userMail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserCin() {
        return userCin;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public Date getUserDayOfBirth() {
        return userDayOfBirth;
    }

    public String getUserSite() {
        return userSite;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getNationality() {
        return nationality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getBio() {
        return bio;
    }

    public String getRoles() {
        return roles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPseudoName(String pseudoName) {
        this.pseudoName = pseudoName;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setUserCin(String userCin) {
        this.userCin = userCin;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public void setUserDayOfBirth(Date userDayOfBirth) {
        this.userDayOfBirth = userDayOfBirth;
    }

    public void setUserSite(String userSite) {
        this.userSite = userSite;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernameCanonical() {
        return usernameCanonical;
    }

    public void setUsernameCanonical(String usernameCanonical) {
        this.usernameCanonical = usernameCanonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailCanonical() {
        return emailCanonical;
    }

    public void setEmailCanonical(String emailCanonical) {
        this.emailCanonical = emailCanonical;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public LocalDate getPasswordRequestedAt() {
        return passwordRequestedAt;
    }

    public void setPasswordRequestedAt(LocalDate passwordRequestedAt) {
        this.passwordRequestedAt = passwordRequestedAt;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName=" + userName + ", pseudoName=" + pseudoName + ", userMail=" + userMail + ", userPassword=" + userPassword + ", userPhone=" + userPhone + ", userCin=" + userCin + ", userAddress=" + userAddress + ", userPhoto=" + userPhoto + ", userDayOfBirth=" + userDayOfBirth + ", userSite=" + userSite + ", createdAt=" + createdAt + ", nationality=" + nationality + ", speciality=" + speciality + ", bio=" + bio + ", role=" + roles + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.pseudoName, other.pseudoName)) {
            return false;
        }
        if (!Objects.equals(this.userMail, other.userMail)) {
            return false;
        }
        if (!Objects.equals(this.userPassword, other.userPassword)) {
            return false;
        }
        if (!Objects.equals(this.userPhone, other.userPhone)) {
            return false;
        }
        if (!Objects.equals(this.userCin, other.userCin)) {
            return false;
        }
        if (!Objects.equals(this.userAddress, other.userAddress)) {
            return false;
        }
        if (!Objects.equals(this.userPhoto, other.userPhoto)) {
            return false;
        }
        if (!Objects.equals(this.userSite, other.userSite)) {
            return false;
        }
        if (!Objects.equals(this.nationality, other.nationality)) {
            return false;
        }
        if (!Objects.equals(this.speciality, other.speciality)) {
            return false;
        }
        if (!Objects.equals(this.bio, other.bio)) {
            return false;
        }
        if (!Objects.equals(this.roles, other.roles)) {
            return false;
        }
        if (!Objects.equals(this.userDayOfBirth, other.userDayOfBirth)) {
            return false;
        }
        if (!Objects.equals(this.createdAt, other.createdAt)) {
            return false;
        }
        return true;
    }
       
       
       
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                                     
    
    
    
    
    
    
    
    
    
}