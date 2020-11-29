package son.nguyen.webseller.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "hoaDon")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class HoaDon implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "khachHang_id")
    private KhachHang khachHang;
    @Column
    private int soNguoi;
    @Column
    private Date time;
    @Column
    private BigDecimal tongTien;
    @Column
    private int giamGia;
    @Column
    private BigDecimal chiPhiKhac;
    @Column
    private int status;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "hoaDonId")
    @JsonManagedReference
    private List<HoaDonChiTiet> hoaDonChiTiet;

    public long getId() {
        return id;
    }

    public int getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        this.soNguoi = soNguoi;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonBackReference(value = "user")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JsonBackReference(value = "khachHang")
    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }


    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

    public BigDecimal getChiPhiKhac() {
        return chiPhiKhac;
    }

    public void setChiPhiKhac(BigDecimal chiPhiKhac) {
        this.chiPhiKhac = chiPhiKhac;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<HoaDonChiTiet> getHoaDonChiTiet() {
        return hoaDonChiTiet;
    }

    public void setHoaDonChiTiet(List<HoaDonChiTiet> hoaDonCHiTiet) {
        this.hoaDonChiTiet = hoaDonCHiTiet;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }


}