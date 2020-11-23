package son.nguyen.webseller.service;

import org.springframework.stereotype.Service;
import son.nguyen.webseller.model.KhachHang;

import java.util.List;
@Service
public interface KhachHangService {
    KhachHang addKhachHang(KhachHang khachHang);
    KhachHang findBySdt(String sdt);
    List<String> findSdtNear(String sdt);
}
