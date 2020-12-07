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

import java.math.BigDecimal;
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
            hoaDon.setKhachHangId(khachHang.getId());
            hoaDon.setStatus(HOADON.NOTPAY.ordinal());
            hoaDon.setTime(new Date());
            hoaDonRepository.save(hoaDon);
            hoaDonChiTiet.setHoaDonId(hoaDon.getId());
            hoaDonChiTietRepository.save(hoaDonChiTiet);
            List<HoaDonChiTiet> hoaDonChiTiets=new ArrayList<>();
            hoaDonChiTiets.add(hoaDonChiTiet);
            hoaDon.setHoaDonChiTiet(hoaDonChiTiets);
            hoaDon.setTongTien(totalMoney(hoaDon.getHoaDonChiTiet()));
            hoaDonRepository.save(hoaDon);
            return hoaDon;
        }
        HoaDon hoaDon =hoaDonRepository.findById(id).get();
        List<Long> hoaDonChiTiets =hoaDon.getHoaDonChiTiet().stream().map(hoaDonChiTiet1 ->hoaDonChiTiet1.getSanPham().getId() ).collect(Collectors.toList());
        if (hoaDonChiTiets.contains(hoaDonChiTiet.getSanPham().getId())){
            List<HoaDonChiTiet> hdct=hoaDon.getHoaDonChiTiet().stream().filter(hoaDonChiTiet1 -> hoaDonChiTiet1.getSanPham().getId()==hoaDonChiTiet.getSanPham().getId()).collect(Collectors.toList());
            hdct.get(0).setSoLuong(hdct.get(0).getSoLuong()+1);
            hoaDonChiTietRepository.save(hdct.get(0));
            HoaDon saveHd=hoaDonRepository.findById(id).get();
            saveHd.setTongTien(totalMoney(saveHd.getHoaDonChiTiet()));
            hoaDonRepository.save(saveHd);
            return hoaDon;
        }
        hoaDonChiTiet.setHoaDonId(hoaDon.getId());
        hoaDonChiTietRepository.save(hoaDonChiTiet);
        hoaDon.getHoaDonChiTiet().add(hoaDonChiTiet);
        hoaDon.setTongTien(totalMoney(hoaDon.getHoaDonChiTiet()));
        hoaDonRepository.save(hoaDon);
        return hoaDon;
    }
    private BigDecimal totalMoney(List<HoaDonChiTiet> hoaDonChiTiets){
       BigDecimal bd=new BigDecimal(0);
       for (HoaDonChiTiet hd:hoaDonChiTiets){
           BigDecimal a=hd.getSanPham().getGia().multiply(new BigDecimal(hd.getSoLuong()));
           bd= a.add(bd);
           System.out.println(a);
       }
       return bd;
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
        HoaDon hoaSave= hoaDonRepository.findById(idHd).get();
        hoaSave.setTongTien(totalMoney(hoaSave.getHoaDonChiTiet()));
        return hoaDonRepository.findById(idHd).get();

    }

    @Override
    public HoaDon thanhtoandon(long id) {
        HoaDon hoaDon=hoaDonRepository.findById(id).get();
        hoaDon.setStatus(HOADON.PAY.ordinal());
        hoaDonRepository.save(hoaDon);
        return hoaDon;
    }

    @Override
    public List<HoaDon> getAllHoaDonByDate(Integer ngay,Integer thang,Integer nam) {
        List<HoaDon> hoaDons =hoaDonRepository.findHoaDonByDate(ngay,thang,nam);
        return hoaDons;
    }

    @Override
    public List<HoaDon> getAllHoaDonByMonth(Integer thang, Integer nam) {
        List<HoaDon> hoaDons =hoaDonRepository.findHoaDonByMonth(thang,nam);
        return hoaDons;
    }
}
