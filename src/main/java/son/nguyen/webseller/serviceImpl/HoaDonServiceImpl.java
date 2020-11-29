package son.nguyen.webseller.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import son.nguyen.webseller.config.HOADON;
import son.nguyen.webseller.model.HoaDon;
import son.nguyen.webseller.model.HoaDonChiTiet;
import son.nguyen.webseller.model.KhachHang;
import son.nguyen.webseller.model.User;
import son.nguyen.webseller.repository.HoaDonChiTietRepository;
import son.nguyen.webseller.repository.HoaDonRepository;
import son.nguyen.webseller.service.HoaDonService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    private HoaDonRepository hoaDonRepository;
    private HoaDonChiTietRepository hoaDonChiTietRepository;
   @Autowired
    public HoaDonServiceImpl(HoaDonRepository hoaDonRepository,HoaDonChiTietRepository hoaDonChiTietRepository) {
        this.hoaDonRepository = hoaDonRepository;
        this.hoaDonChiTietRepository =hoaDonChiTietRepository;
    }

    @Override
    public HoaDon addHoaDon(User user,Long id, HoaDonChiTiet hoaDonChiTiet, KhachHang khachHang) {
       hoaDonChiTiet.setSoLuong(1);
        if (id==null||id==0){
            HoaDon hoaDon =new HoaDon();
            hoaDon.setUser(user);
            hoaDon.setKhachHang(khachHang);
            hoaDon.setStatus(HOADON.NOTPAY.ordinal());
            hoaDon.setTime(new Date());
            hoaDonRepository.save(hoaDon);
            hoaDonChiTiet.setHoaDonId(hoaDon.getId());
            hoaDonChiTietRepository.save(hoaDonChiTiet);
            List<HoaDonChiTiet> hoaDonChiTiets=new ArrayList<>();
            hoaDonChiTiets.add(hoaDonChiTiet);
            hoaDon.setHoaDonChiTiet(hoaDonChiTiets);
            hoaDonRepository.save(hoaDon);
            return hoaDon;
        }
        HoaDon hoaDon =hoaDonRepository.findById(id).get();
        List<Long> hoaDonChiTiets =hoaDon.getHoaDonChiTiet().stream().map(hoaDonChiTiet1 ->hoaDonChiTiet1.getSanPham().getId() ).collect(Collectors.toList());
        if (hoaDonChiTiets.contains(hoaDonChiTiet.getSanPham().getId())){
            List<HoaDonChiTiet> hdct=hoaDon.getHoaDonChiTiet().stream().filter(hoaDonChiTiet1 -> hoaDonChiTiet1.getSanPham().getId()==hoaDonChiTiet.getSanPham().getId()).collect(Collectors.toList());
            hdct.get(0).setSoLuong(hdct.get(0).getSoLuong()+1);
            hoaDonChiTietRepository.save(hdct.get(0));
            return hoaDon;
        }
        hoaDonChiTiet.setHoaDonId(hoaDon.getId());
        hoaDonChiTietRepository.save(hoaDonChiTiet);
        hoaDon.getHoaDonChiTiet().add(hoaDonChiTiet);
        hoaDonRepository.save(hoaDon);
        return hoaDon;
    }

    @Override
    public HoaDon findHoaDonById(Long id) {
       Optional<HoaDon> hoaDon = hoaDonRepository.findById(id);
       if (!hoaDon.isPresent()){
           return null;
       }
       return hoaDon.get();
    }

    @Override
    public List<HoaDon> findHoaDonNotFund() {
       List<HoaDon> hoaDon =hoaDonRepository.findHoaDonByStatus(HOADON.NOTPAY.ordinal());
       return hoaDon;
    }

    @Override
    public HoaDon findHoaDonBySdt(String  sdt) {
        HoaDon hoaDon =hoaDonRepository.findHoaDonBySdt(sdt);
        return  hoaDon;
    }

    @Override
    public HoaDon deleteHdctInHd(long idHd, long idhdCt) {
        Optional<HoaDon> hoaDon =hoaDonRepository.findById(idHd);
        if (!hoaDon.isPresent()) return null;
        for (HoaDonChiTiet hdct:hoaDon.get().getHoaDonChiTiet()){
            if (hdct.getId()==idhdCt){
                if (hdct.getSoLuong()==1){
                    hoaDonChiTietRepository.deleteById(idhdCt);
                    break;
                }else {
                    hdct.setSoLuong( hdct.getSoLuong()-1);
                    hoaDonChiTietRepository.save(hdct);
                    break;

                }
            }
        }
        return hoaDonRepository.findById(idHd).get();

    }
}
