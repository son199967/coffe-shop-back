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
@RequestMapping("/sanpham")
public class SanPhamController {

    private SanPhamService sanPhamService;

    private JwtTokenUtil jwtTokenUtil;

    private JwtUserDetailsService userDetailsService;

    @Autowired
    public SanPhamController(SanPhamService sanPhamService, JwtTokenUtil jwtTokenUtil, JwtUserDetailsService userDetailsService) {
        this.sanPhamService = sanPhamService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;

    }

    @PostMapping("/createNewSanPham")
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
    @GetMapping("/getSanPhamById")
    private ResponseEntity<?> getSanPhamLoai(@RequestParam Long id){
        SanPham sanPham =sanPhamService.getSanPhamById(id);
        return ResponseEntity.ok(sanPham);

    }
    @GetMapping("/getAllLoai")
    private ResponseEntity<?> getSanPhamLoai(){
        List<String> sanPhams= sanPhamService.getAllLoaiSanPham();
        return ResponseEntity.ok(sanPhams);
    }
    @GetMapping("/getAllSanPham")
    private ResponseEntity<?> getAllSanPham(){
        List<SanPham> sanPhams= sanPhamService.getAllSanPham();
        return ResponseEntity.ok(sanPhams);
    }
    @DeleteMapping("/deteleSanPham")
    private ResponseEntity<?> deleteSanPham(){
        return null;
    }




}
