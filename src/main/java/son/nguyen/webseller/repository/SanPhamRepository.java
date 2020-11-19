package son.nguyen.webseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import son.nguyen.webseller.model.SanPham;
@Repository
public interface SanPhamRepository extends JpaRepository<SanPham,Long> {
}
