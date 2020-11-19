package son.nguyen.webseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import son.nguyen.webseller.model.SanPham;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham,Long> {
    @Query("SELECT * from san_pham sp where sp.loai=?1")
    List<SanPham> findByLoai(String loai);
    @Query("SELECT sp.loai from san_pham sp group by sp.loai")
    List<String> findAllLoaiSanPham();
}
