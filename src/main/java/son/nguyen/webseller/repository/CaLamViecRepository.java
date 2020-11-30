package son.nguyen.webseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import son.nguyen.webseller.model.CaLamViec;

import java.util.Date;
import java.util.List;

@Repository
public interface CaLamViecRepository extends JpaRepository<CaLamViec,Long> {
    @Query("select clv from CaLamViec  clv where clv.ngay between ?1 and ?2 order by  clv.tenClV asc,clv.ngay asc ")
    List<CaLamViec> getAllCalamViecInWeek(Date start ,Date end);
    @Query("select clv from CaLamViec  clv where clv.ngay between ?1 and ?2 order by clv.tenClV asc,clv.ngay asc ")
    List<CaLamViec> getAllCalamViecNextWeeK(Date start ,Date end);
    @Query("select clv from CaLamViec  clv join  clv.user u where u.id=?1 and MONTH(clv.ngay)=?2 and YEAR(clv.ngay)=?3 order by clv.ngay asc")
    List<CaLamViec> getAllBangLuongUser(Long idUser,Integer mounh,Integer year);


}
