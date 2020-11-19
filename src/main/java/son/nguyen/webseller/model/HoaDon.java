package son.nguyen.webseller.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "hoaDon")
public class HoaDon implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "khachHang_id")
    private KhachHang khachHang;
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
//    @OneToMany(mappedBy = "hoadonbanhang",cascade = CascadeType.ALL)
//    private List<HoaDonChiTiet> hoaDonChiTiet;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JsonBackReference
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
    //
//    public void setTongTien(BigDecimal tongTien) {
//        BigDecimal tong = new BigDecimal(0);
//        hoaDonCHiTiet.forEach(hoaDonCHiTiet1 -> {
//            tong.add(hoaDonCHiTiet1.getSanPham().getGia().multiply(new BigDecimal(hoaDonCHiTiet1.getSoLuong())).multiply(new BigDecimal(hoaDonCHiTiet1.getSanPham().getHsDiscount())));
//        });
//        this.tongTien = tong;
//
//    }

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

//    @JsonManagedReference
//    public List<HoaDonChiTiet> getHoaDonChiTiet() {
//        return hoaDonChiTiet;
//    }
//
//    public void setHoaDonChiTiet(List<HoaDonChiTiet> hoaDonCHiTiet) {
//        this.hoaDonChiTiet = hoaDonCHiTiet;
//    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}