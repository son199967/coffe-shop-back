package son.nguyen.webseller.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hoaDonChiTiet")
public class HoaDonChiTiet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "hoaDonId",nullable = true)
    @JsonBackReference
    private Long hoaDonId;


    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "sanPham_id")
    private SanPham sanPham;


    @Column(name = "soLuong",nullable = true)
    private int soLuong;

    @Column(name = "mota",nullable = true)
    private String mota;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getHoaDonId() {
        return hoaDonId;
    }

    public void setHoaDonId(Long hoaDonId) {
        this.hoaDonId = hoaDonId;
    }
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
