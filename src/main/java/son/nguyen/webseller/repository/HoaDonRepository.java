package son.nguyen.webseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import son.nguyen.webseller.model.HoaDon;

import java.util.List;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon,Long> {
    @Query("select hd from HoaDon hd where hd.status=?1")
   List<HoaDon> findHoaDonByStatus(int status);

    @Query("select  hd from HoaDon  hd inner join KhachHang  kh" +
            " on kh.id=hd.khachHangId where kh.sdt=?1 and hd.status=0")
    HoaDon findHoaDonBySdt(String sdt);



    @Query("select  hd from HoaDon  hd where DAY(hd.time)=?1 and MONTH(hd.time)=?2 and YEAR(hd.time)=?3 and hd.status=1")
   List <HoaDon> findHoaDonByDate(Integer ngay,Integer thang,Integer nam);
    @Query("select  hd from HoaDon  hd where  MONTH(hd.time)=?1 and YEAR(hd.time)=?2 and hd.status=1")
    List <HoaDon> findHoaDonByMonth(Integer thang,Integer nam);


}
