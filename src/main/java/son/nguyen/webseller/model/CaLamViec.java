package son.nguyen.webseller.model;

import org.apache.commons.net.ntp.TimeStamp;

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
    private TimeStamp gioBatDau;
    @Column
    private TimeStamp gioKetThuc;
    @Column
    private Date ngay;
    @ManyToMany()
    @JoinTable(name = "caLamViec_nhanVien",
            joinColumns = @JoinColumn(name = "caLamViec_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> user;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenClV() {
        return tenClV;
    }

    public void setTenClV(String tenClV) {
        this.tenClV = tenClV;
    }


    public TimeStamp getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(TimeStamp gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public TimeStamp getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(TimeStamp gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public List<User> getNhanVien() {
        return user;
    }

    public void setNhanVien(List<User> nhanVien) {
        this.user = nhanVien;
    }
}
