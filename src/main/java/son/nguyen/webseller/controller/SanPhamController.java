package son.nguyen.webseller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import son.nguyen.webseller.config.sercurity.JwtTokenUtil;
import son.nguyen.webseller.dto.UserDto;
import son.nguyen.webseller.model.SanPham;
import son.nguyen.webseller.service.JwtUserDetailsService;
import son.nguyen.webseller.service.SanPhamService;

import java.util.List;

@RestController
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @PostMapping("/creatNewSanPham")
    private ResponseEntity<?> addSanPham(@RequestHeader String Authorization, @RequestBody SanPham sanPham){
        String email = jwtTokenUtil.getUsernameFromToken(Authorization);
        UserDto userDto =userDetailsService.getUserByEmail(email);
        if (!userDto.getRole().equals("ROLE_ADMIN")){
            return ResponseEntity.ok("not admin");
        }
        sanPhamService.addSanPham(sanPham);
        return ResponseEntity.ok(sanPham);

    }
    @PutMapping("/updateSanPham")
    private ResponseEntity<?> updateSanPham(@RequestHeader String Authorization, @RequestBody SanPham sanPham){
        String email = jwtTokenUtil.getUsernameFromToken(Authorization);
        UserDto userDto =userDetailsService.getUserByEmail(email);
        if (!userDto.getRole().equals("ROLE_ADMIN")){
            return ResponseEntity.ok("not admin");
        }
        sanPhamService.addSanPham(sanPham);
        return ResponseEntity.ok(sanPham);

    }
    @GetMapping("/getSanPhamLoai")
    private ResponseEntity<?> getSanPhamLoai(@RequestParam String loai){
        List<SanPham> sanPhams= sanPhamService.getSanPhamByLoai(loai);
        return ResponseEntity.ok(sanPhams);

    }
    @GetMapping("/getAllLoai")
    private ResponseEntity<?> getSanPhamLoai(){
        List<String> sanPhams= sanPhamService.getAllLoaiSanPham();
        return ResponseEntity.ok(sanPhams);
    }
    @DeleteMapping("/deteleSanPham")
    private ResponseEntity<?> deleteSanPham(){
        return null;
    }
}
