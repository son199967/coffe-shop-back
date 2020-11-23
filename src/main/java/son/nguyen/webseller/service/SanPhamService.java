package son.nguyen.webseller.service;

import son.nguyen.webseller.model.SanPham;

import java.util.List;

public interface SanPhamService {
    SanPham addSanPham(SanPham sanPham);
    SanPham updateSanPham(SanPham sanPham);
    SanPham getSanPhamById(Long id);
    List<SanPham> getSanPhamByLoai(String loai);
    List<String> getAllLoaiSanPham();
    List<SanPham> getAllSanPham();

}
