package son.nguyen.webseller.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name = "caLamViec")
@Entity
public class CaLamViec implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String tenClV;
    @Column
    private String gioBatDau;
    @Column
    private String gioKetThuc;
    @Column
    private Date ngay;
    @Column
    private double hs;
    @ManyToMany()
    @JoinTable(name = "caLamViec_nhanVien",
            joinColumns = @JoinColumn(name = "caLamViec_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> user;
    public void setCa1(){
        this.setTenClV("1");
        this.setGioBatDau("7h30");
        this.setGioKetThuc("12h00");
    }
    public void setCa2(){
        this.setTenClV("2");
        this.setGioBatDau("12h00");
        this.setGioKetThuc("17h30");
    }
    public void setCa3(){
        this.setTenClV("3");
        this.setGioBatDau("17h30");
        this.setGioKetThuc("23h00");
    }

    public double getHs() {
        return hs;
    }

    public void setHs(double hs) {
        this.hs = hs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getTenClV() {
        return tenClV;
    }

    private void setTenClV(String tenClV) {
        this.tenClV = tenClV;
    }


    public String getGioBatDau() {
        return gioBatDau;
    }

    private void setGioBatDau(String gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public String getGioKetThuc() {
        return gioKetThuc;
    }

    private void setGioKetThuc(String gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }
    @JsonManagedReference
    public List<User> getNhanVien() {
        return user;
    }

    public void setNhanVien(List<User> nhanVien) {
        this.user = nhanVien;
    }
}
