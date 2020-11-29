package son.nguyen.webseller.service;

import son.nguyen.webseller.model.CaLamViec;
import son.nguyen.webseller.model.User;

import java.util.List;

public interface NhanVienService {
    List<CaLamViec> nhanVienGetAllCaLamViecTiep();
    List<CaLamViec> nhanVienGetAllCaLamViecNextWeek();
    CaLamViec registerCalamViec( User user,Long id);

}
