package son.nguyen.webseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import son.nguyen.webseller.model.HoaDon;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon,Long> {

}
