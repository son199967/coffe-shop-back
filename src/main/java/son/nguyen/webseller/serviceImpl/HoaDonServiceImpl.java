package son.nguyen.webseller.serviceImpl;

import org.springframework.stereotype.Service;
import son.nguyen.webseller.model.HoaDon;
import son.nguyen.webseller.repository.HoaDonRepository;
import son.nguyen.webseller.repository.KhachHangRepository;
import son.nguyen.webseller.service.HoaDonService;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    private HoaDonRepository hoaDonRepository;
    private KhachHangRepository khachHangRepository;

    @Override
    public HoaDon addHoaDon(HoaDon hoaDon) {
        return null;
    }
}
