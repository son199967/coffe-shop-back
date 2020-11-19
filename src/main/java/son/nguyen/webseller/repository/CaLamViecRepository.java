package son.nguyen.webseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import son.nguyen.webseller.model.CaLamViec;

@Repository
public interface CaLamViecRepository extends JpaRepository<CaLamViec,Long> {

}
