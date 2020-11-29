package son.nguyen.webseller.service;

import son.nguyen.webseller.model.HoaDon;
import son.nguyen.webseller.model.HoaDonChiTiet;
import son.nguyen.webseller.model.KhachHang;
import son.nguyen.webseller.model.User;

import java.util.List;

public interface HoaDonService {
  HoaDon addHoaDon(User user,Long id, HoaDonChiTiet hoaDonChiTiet, KhachHang khachHang);
  HoaDon findHoaDonById(Long id);
  List<HoaDon> findHoaDonNotFund();
  HoaDon findHoaDonBySdt(String sdt);
  HoaDon deleteHdctInHd(long idHd,long idhdCt);



}
