package son.nguyen.webseller.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import son.nguyen.webseller.model.HoaDon;
import son.nguyen.webseller.model.KhachHang;
import son.nguyen.webseller.repository.KhachHangRepository;
import son.nguyen.webseller.service.KhachHangService;

import java.util.List;
@Service
public class KhachHangServiceImpl implements KhachHangService {
    private KhachHangRepository khachHangRepository;
    @Autowired
    public KhachHangServiceImpl(KhachHangRepository khachHangRepository) {
        this.khachHangRepository = khachHangRepository;
    }

    @Override
    public KhachHang addKhachHang(KhachHang khachHang) {
       khachHangRepository.save(khachHang);
       return khachHang;
    }

    @Override
    public KhachHang findBySdt(String sdt) {
      KhachHang khachHang= khachHangRepository.findKhBySdt(sdt);
      return khachHang;
    }

    @Override
    public List<String> findSdtNear(String sdt) {
        List<String> strings =khachHangRepository.findSdtNear(sdt);
        return strings;
    }


}
