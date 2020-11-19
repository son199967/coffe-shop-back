package son.nguyen.webseller.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "sanPham")
public class SanPham implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String hinhAnh;
    @Column
    private String tenSanPham;
    @Column
    private BigDecimal gia;
    @Column
    private String loai;
    @Column
    private String mota;
    @OneToOne(mappedBy = "sanPham",cascade = CascadeType.ALL)
    private HoaDonChiTiet hoaDonCHiTiet;
    @Column
    private double hsDiscount=1;

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public double getHsDiscount() {
        return hsDiscount;
    }

    public void setHsDiscount(double hsDiscount) {
        this.hsDiscount = hsDiscount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @JsonBackReference
    public HoaDonChiTiet getHoaDonCHiTiet() {
        return hoaDonCHiTiet;
    }

    public void setHoaDonCHiTiet(HoaDonChiTiet hoaDonCHiTiet) {
        this.hoaDonCHiTiet = hoaDonCHiTiet;
    }
}
