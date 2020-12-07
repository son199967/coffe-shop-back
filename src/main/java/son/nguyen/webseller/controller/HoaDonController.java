package son.nguyen.webseller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import son.nguyen.webseller.config.sercurity.JwtTokenUtil;
import son.nguyen.webseller.dto.UserDto;
import son.nguyen.webseller.model.HoaDon;
import son.nguyen.webseller.model.HoaDonChiTiet;
import son.nguyen.webseller.model.KhachHang;
import son.nguyen.webseller.model.User;
import son.nguyen.webseller.service.HoaDonService;
import son.nguyen.webseller.service.JwtUserDetailsService;
import son.nguyen.webseller.service.KhachHangService;
import son.nguyen.webseller.service.SanPhamService;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class HoaDonController {

    private HoaDonService hoaDonService;

    private SanPhamService sanPhamService;

    private JwtTokenUtil jwtTokenUtil;

    private JwtUserDetailsService jwtUserDetailsService;

    private JwtUserDetailsService userDetailsService;

    private KhachHangService khachHangService;
     @Autowired
    public HoaDonController(HoaDonService hoaDonService, SanPhamService sanPhamService, JwtTokenUtil jwtTokenUtil, JwtUserDetailsService jwtUserDetailsService, JwtUserDetailsService userDetailsService, KhachHangService khachHangService) {
        this.hoaDonService = hoaDonService;
        this.sanPhamService = sanPhamService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.jwtUserDetailsService = jwtUserDetailsService;
        this.userDetailsService = userDetailsService;
        this.khachHangService = khachHangService;
    }


    @PostMapping(value = "/addSpHoaDon")
    public ResponseEntity<?> addHoaDon(@RequestHeader String Authorization,@RequestParam(required = false) Long id , @RequestBody HoaDonChiTiet hoaDonChiTiet, @RequestParam(required = true) String phoneCustomer){
        String email = jwtTokenUtil.getUsernameFromToken(Authorization);
        UserDto userDto =userDetailsService.getUserByEmail(email);
        if (userDto.getRole().equals("ROLE_START")){
            return ResponseEntity.ok("not author");
        }
        User user =jwtUserDetailsService.convertDtoToDao(userDto);
        KhachHang khachHang= khachHangService.findBySdt(phoneCustomer);
        if (khachHang==null){
            return ResponseEntity.ok(null);
        }
       HoaDon hoaDon1= hoaDonService.addHoaDon(user,id,hoaDonChiTiet,khachHang);

       return ResponseEntity.ok(hoaDon1);
    }
    @GetMapping("/getHoaDonSdt")
    private  ResponseEntity<?> getHoaDonSdt(@RequestHeader String Authorization,@RequestParam String sdtNear){
        String email = jwtTokenUtil.getUsernameFromToken(Authorization);
        UserDto userDto =userDetailsService.getUserByEmail(email);
        if (userDto.getRole().equals("ROLE_START")){
            return ResponseEntity.ok("not author");
        }

        HoaDon hoaDon= hoaDonService.findHoaDonBySdt(sdtNear);
        return ResponseEntity.ok(hoaDon);
    }
    @GetMapping("/getHoaDonDate")
    private  ResponseEntity<?> getHoaDonDate(@RequestHeader String Authorization,@RequestParam Integer ngay,@RequestParam Integer thang,@RequestParam Integer nam){
        String email = jwtTokenUtil.getUsernameFromToken(Authorization);
        UserDto userDto =userDetailsService.getUserByEmail(email);
        if (userDto.getRole().equals("ROLE_START")){
            return ResponseEntity.ok("not author");
        }

        List<HoaDon> hoaDon= hoaDonService.getAllHoaDonByDate(ngay,thang,nam);
        return ResponseEntity.ok(hoaDon);
    }
    @GetMapping("/getHoaDonMonth")
    private  ResponseEntity<?> getHoaDonMonth(@RequestHeader String Authorization,@RequestParam Integer thang,@RequestParam Integer nam){
        String email = jwtTokenUtil.getUsernameFromToken(Authorization);
        UserDto userDto =userDetailsService.getUserByEmail(email);
        if (userDto.getRole().equals("ROLE_START")){
            return ResponseEntity.ok("not author");
        }

        List<HoaDon> hoaDon= hoaDonService.getAllHoaDonByMonth(thang,nam);
        return ResponseEntity.ok(hoaDon);
    }
    @GetMapping("/doanhThuThang")
    private  ResponseEntity<?> doanhThuThang(@RequestHeader String Authorization,@RequestParam Integer thang,@RequestParam Integer nam){
        String email = jwtTokenUtil.getUsernameFromToken(Authorization);
        UserDto userDto =userDetailsService.getUserByEmail(email);
        if (userDto.getRole().equals("ROLE_START")){
            return ResponseEntity.ok("not author");
        }

        List<HoaDon> hoaDon= hoaDonService.getAllHoaDonByMonth(thang,nam);
        BigDecimal bigDecimal =new BigDecimal(0);
        for(HoaDon hd:hoaDon){
            bigDecimal =bigDecimal.add(hd.getTongTien());
        }
        return ResponseEntity.ok(bigDecimal);
    }
    @GetMapping("/doanhThuNgay")
    private  ResponseEntity<?> doanhThuNgay(@RequestHeader String Authorization,@RequestParam Integer ngay,@RequestParam Integer thang,@RequestParam Integer nam){
        String email = jwtTokenUtil.getUsernameFromToken(Authorization);
        UserDto userDto =userDetailsService.getUserByEmail(email);
        if (userDto.getRole().equals("ROLE_START")){
            return ResponseEntity.ok("not author");
        }

        List<HoaDon> hoaDon= hoaDonService.getAllHoaDonByDate(ngay,thang,nam);
        BigDecimal bigDecimal =new BigDecimal(0);
        for(HoaDon hd:hoaDon){
            bigDecimal =bigDecimal.add(hd.getTongTien());
        }
        return ResponseEntity.ok(bigDecimal);
    }

    @PostMapping("/addKhachHang")
    private ResponseEntity<?> addKhachHang(@RequestHeader String Authorization, @RequestBody KhachHang khachHang){
        String email = jwtTokenUtil.getUsernameFromToken(Authorization);
        UserDto userDto =userDetailsService.getUserByEmail(email);
        if (userDto.getRole().equals("ROLE_START")){
            return ResponseEntity.ok("not author");
        }
        khachHangService.addKhachHang(khachHang);
        return ResponseEntity.ok(khachHang);
    }
    @DeleteMapping("/deleteSpInHdct")
    private ResponseEntity<?> deleteSanPham(@RequestHeader String Authorization,@RequestParam long idCt ,@RequestParam long idHd){
        String email = jwtTokenUtil.getUsernameFromToken(Authorization);
        UserDto userDto =userDetailsService.getUserByEmail(email);
        if (userDto.getRole().equals("ROLE_START")){
            return ResponseEntity.ok("not author");
        }
       HoaDon hoaDon = hoaDonService.deleteHdctInHd(idHd,idCt);
        return ResponseEntity.ok(hoaDon);

    }
    @GetMapping("/thanhtoanDon")
    private ResponseEntity<?> thanhtoanDon(@RequestParam Long id){
        HoaDon hoaDon =hoaDonService.thanhtoandon(id);
        return ResponseEntity.ok(hoaDon);
    }
    @GetMapping("/findKhachHang")
    private ResponseEntity<?> findKhachHangBySdt(@RequestParam String sdt){
     KhachHang khachHang = khachHangService.findBySdt(sdt);
     return ResponseEntity.ok(khachHang);
    }
    @GetMapping("/findSdtNear")
    private  ResponseEntity<?> findSdtNear(@RequestParam String sdtNear){
        List<String> strings =khachHangService.findSdtNear(sdtNear);
        if (strings.size()>10){
            strings.subList(0,9);
        }
        return ResponseEntity.ok(strings);
    }
    @GetMapping("/findHoaDonById")
    private ResponseEntity<?> findHoaDonById(@RequestParam Long id){
        HoaDon hoaDon=hoaDonService.findHoaDonById(id);
        return  ResponseEntity.ok(hoaDon);
    }



}
