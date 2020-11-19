package son.nguyen.webseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import son.nguyen.webseller.model.KhachHang;
@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang,Long> {
}
