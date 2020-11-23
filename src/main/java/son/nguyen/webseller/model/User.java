package son.nguyen.webseller.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "user")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        resolver = EntityIdResolver.class,
        scope=User.class)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String fistName;
    @Column
    private String lastName;
    @Column
    private String address;
    @Column
    private String province;
    @Column
    private String district;
    @Column
    private String phone;
    @Column
    private String role;
    @Column
    @NonNull
    private String identification;
    @Column
    @JsonIgnore
    private String password;
    @Column
    private BigDecimal indexSalarys;
    @ManyToMany(mappedBy = "user")
    private List<CaLamViec> caLamViec;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<HoaDon> hoaDonBanHang;

    public BigDecimal getIndexSalarys() {
        return indexSalarys;
    }

    public void setIndexSalarys(BigDecimal indexSalarys) {
        this.indexSalarys = indexSalarys;
    }

    public List<CaLamViec> getCaLamViecList() {
        return caLamViec;
    }

    public void setCaLamViecList(List<CaLamViec> caLamViecList) {
        this.caLamViec = caLamViecList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @NonNull
    public String getIdentification() {
        return identification;
    }

    public void setIdentification(@NonNull String identification) {
        this.identification = identification;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}


