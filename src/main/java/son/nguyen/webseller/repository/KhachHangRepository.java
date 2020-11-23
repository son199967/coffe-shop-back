package son.nguyen.webseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import son.nguyen.webseller.model.KhachHang;

import java.util.List;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang,Long> {
    @Query("select kh.sdt from KhachHang kh where kh.sdt LIKE ?1%")
    List<String> findSdtNear(String sdt);
    @Query("select kh from KhachHang kh where kh.sdt=?1")
    KhachHang findKhBySdt(String sdt);

}
