package com.mycompany.mywebapp.com.mycompany.mywebapp.user;
import javax.persistence.*;

@Entity
@Table(name = "farmerrequest")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
    @Column(nullable = false,length = 45)
   private String District;
    @Column(length = 45,nullable = false)
   private String Province;
    @Column(length = 45,nullable = false )
  private String Firstname;
    @Column(length = 45,nullable = false )
  private  String Lastname;
    @Column(length = 45,nullable = false  )
  private String Fertilizer_type;
    @Column(length = 45,nullable = false )
  private String Farming_type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getFertilizer_type() {
        return Fertilizer_type;
    }

    public void setFertilizer_type(String fertilizer_type) {
        Fertilizer_type = fertilizer_type;
    }



    public String getFarming_type() {
        return Farming_type;
    }

    public void setFarming_type(String farming_type) {
        Farming_type = farming_type;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", District='" + District + '\'' +
                ", Province='" + Province + '\'' +
                ", Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", Fertilizer_type='" + Fertilizer_type + '\'' +
                ", Farming_type='" + Farming_type + '\'' +
                '}';
    }
}
