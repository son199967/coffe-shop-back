package son.nguyen.webseller.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hoaDonChitTiet")
public class HoaDonChiTiet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hoaDon_id")
    private HoaDon hoaDon;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sanPham_id")
    private SanPham sanPham;


    @Column
    private int soLuong;

    @Column
    private String mota;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonBackReference
    public HoaDon getHoaDonBanHang() {
        return hoaDon;
    }

    public void setHoaDonBanHang(HoaDon hoaDonBanHang) {
        this.hoaDon = hoaDonBanHang;
    }
    @JsonManagedReference
    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
