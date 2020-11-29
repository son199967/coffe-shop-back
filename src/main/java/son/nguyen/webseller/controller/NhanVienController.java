package son.nguyen.webseller.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import son.nguyen.webseller.config.sercurity.JwtTokenUtil;
import son.nguyen.webseller.model.CaLamViec;
import son.nguyen.webseller.model.User;
import son.nguyen.webseller.service.JwtUserDetailsService;
import son.nguyen.webseller.service.NhanVienService;

import java.util.List;

@RestController
public class NhanVienController {
    private NhanVienService nhanVienService;
    private JwtTokenUtil jwtTokenUtil;
    private JwtUserDetailsService jwtUserDetailsService;


    public NhanVienController(NhanVienService nhanVienService, JwtTokenUtil jwtTokenUtil, JwtUserDetailsService jwtUserDetailsService) {
        this.nhanVienService = nhanVienService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.jwtUserDetailsService = jwtUserDetailsService;
    }

    @RequestMapping(value = "/getAllCalamInWeeK", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCalamInWeek() {
//        String email = jwtTokenUtil.getUsernameFromToken(Authorization);
//        UserDto userDto =jwtUserDetailsService.getUserByEmail(email);
//        if (userDto.getRole().equals("ROLE_START")){
//            return ResponseEntity.ok("not author");
//        }
        List<CaLamViec> caLamViecList = nhanVienService.nhanVienGetAllCaLamViecTiep();
        return ResponseEntity.ok(caLamViecList);
    }
    @RequestMapping(value = "/getAllCalamNextWeek", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCalamNextWeeK() {
//        String email = jwtTokenUtil.getUsernameFromToken(Authorization);
//        UserDto userDto =jwtUserDetailsService.getUserByEmail(email);
//        if (userDto.getRole().equals("ROLE_START")){
//            return ResponseEntity.ok("not author");
//        }
        List<CaLamViec> caLamViecList = nhanVienService.nhanVienGetAllCaLamViecNextWeek();
        return ResponseEntity.ok(caLamViecList);
    }
    @GetMapping(value = "/register")
    public ResponseEntity<?> registerCaLamViec(@RequestHeader String Authorization, @RequestParam Long id) {
        String email = jwtTokenUtil.getUsernameFromToken(Authorization);
        User user =jwtUserDetailsService.getUseDaorByEmail(email);
        if (user.getRole().equals("ROLE_START")){
            return ResponseEntity.ok("not author");
        }
        CaLamViec caLamViec = nhanVienService.registerCalamViec(user,id);
        return ResponseEntity.ok(caLamViec);
    }


}