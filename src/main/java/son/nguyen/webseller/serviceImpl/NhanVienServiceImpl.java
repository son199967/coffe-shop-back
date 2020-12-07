package son.nguyen.webseller.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import son.nguyen.webseller.model.CaLamViec;
import son.nguyen.webseller.model.User;
import son.nguyen.webseller.repository.CaLamViecRepository;
import son.nguyen.webseller.service.NhanVienService;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    CaLamViecRepository caLamViecRepository;

    @Autowired
    public NhanVienServiceImpl(CaLamViecRepository caLamViecRepository) {
        this.caLamViecRepository = caLamViecRepository;
    }

    @Override
    public List<CaLamViec> nhanVienGetAllCaLamViecTiep() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate today = LocalDate.now( defaultZoneId );
        LocalDate previousMonday = today.with( TemporalAdjusters.previousOrSame( DayOfWeek.MONDAY ) );
        Date dateStart =new Date( Date.from(previousMonday.atStartOfDay(defaultZoneId).toInstant()).getTime());

        Date dateEnd =new Date( Date.from(previousMonday.atStartOfDay(defaultZoneId).toInstant()).getTime()+ 1000*60*60*24*6);
        List<CaLamViec> caLamViecs = caLamViecRepository.getAllCalamViecInWeek(dateStart,dateEnd);
        return caLamViecs;
    }


    public static void main(String[] args) {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate today = LocalDate.now( defaultZoneId );
        LocalDate previousMonday = today.with( TemporalAdjusters.previousOrSame( DayOfWeek.MONDAY ) );
        System.out.println(previousMonday);

    }

    @Override
    public List<CaLamViec> nhanVienGetAllCaLamViecNextWeek() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate today = LocalDate.now( defaultZoneId );
        LocalDate previousMonday = today.with( TemporalAdjusters.previousOrSame( DayOfWeek.MONDAY ) );
        Date dateStart =new Date( Date.from(previousMonday.atStartOfDay(defaultZoneId).toInstant()).getTime()+ 1000*60*60*24*7);

        Date dateEnd =new Date( Date.from(previousMonday.atStartOfDay(defaultZoneId).toInstant()).getTime()+ 1000*60*60*24*13);

        List<CaLamViec> caLamViecs = caLamViecRepository.getAllCalamViecNextWeeK(dateStart,dateEnd);
        if (caLamViecs==null||caLamViecs.size()==0){
            setCalamViecNextWeek();
            caLamViecs = caLamViecRepository.getAllCalamViecNextWeeK(dateStart,dateEnd);
        }
        Date d =new Date();
        return caLamViecs;
    }
    private void setCalamViecNextWeek(){
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate today = LocalDate.now( defaultZoneId );
        LocalDate previousMonday = today.with( TemporalAdjusters.previousOrSame( DayOfWeek.MONDAY ) );

        Date MONDAY =new Date( Date.from(previousMonday.atStartOfDay(defaultZoneId).toInstant()).getTime()+ 1000*60*60*24*7);
        setCalamViec(MONDAY,1);

        Date TUESDAY =new Date( Date.from(previousMonday.atStartOfDay(defaultZoneId).toInstant()).getTime()+ 1000*60*60*24*8);
        setCalamViec(TUESDAY,1);


        Date WEDNESDAY =new Date( Date.from(previousMonday.atStartOfDay(defaultZoneId).toInstant()).getTime()+ 1000*60*60*24*9);
        setCalamViec(WEDNESDAY,1);

        Date THURSDAY =new Date( Date.from(previousMonday.atStartOfDay(defaultZoneId).toInstant()).getTime()+ 1000*60*60*24*10);
        setCalamViec(THURSDAY,1);


        Date FRIDAY =new Date( Date.from(previousMonday.atStartOfDay(defaultZoneId).toInstant()).getTime()+ 1000*60*60*24*11);
        setCalamViec(FRIDAY,1);


        Date SATURDAY =new Date( Date.from(previousMonday.atStartOfDay(defaultZoneId).toInstant()).getTime()+ 1000*60*60*24*12);
        setCalamViec(SATURDAY,1.5);


        Date SUNDAY =new Date( Date.from(previousMonday.atStartOfDay(defaultZoneId).toInstant()).getTime()+ 1000*60*60*24*13);
        setCalamViec(SUNDAY,1.5);

    }
    private void setCalamViec(Date date,double hs){

        CaLamViec ca1 =new CaLamViec();
        ca1.setCa1();
        ca1.setNgay(date);
        ca1.setHs(hs);
        caLamViecRepository.save(ca1);
        CaLamViec ca2 =new CaLamViec();
        ca2.setCa2();
        ca2.setHs(hs);
        ca2.setNgay(date);
        caLamViecRepository.save(ca2);
        CaLamViec ca3 =new CaLamViec();
        ca3.setCa3();
        ca3.setHs(hs);
        ca3.setNgay(date);
        caLamViecRepository.save(ca3);

    }



    @Override
    public CaLamViec registerCalamViec(User user, Long id) {
        Optional<CaLamViec> caLamViec = caLamViecRepository.findById(id);
        if (!caLamViec.isPresent()) {
            return null;
        }
        List<User> users = caLamViec.get().getNhanVien();
        List<User> ids =users.stream().filter(user1 -> user1.getId()==user.getId()).collect(Collectors.toList());
        if (users == null || users.isEmpty() || users.size() == 0) {
            users = new ArrayList<>(Arrays.asList(user));
        } else if (users.size()==3){
            return null;
        }else if (ids.size()!=0){
            return null;
        }else {
            users.add(user);
        }

        caLamViec.get().setNhanVien(users);
        caLamViecRepository.save(caLamViec.get());
        return caLamViec.get();
    }

    @Override
    public List<CaLamViec> getAllBangLuong(User user,Integer month,Integer year) {
     List<CaLamViec> caLamViecs =  caLamViecRepository.getAllBangLuongUser(user.getId(),month,year);
     return caLamViecs;
    }
}
