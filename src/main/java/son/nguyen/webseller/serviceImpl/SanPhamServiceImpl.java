package son.nguyen.webseller.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import son.nguyen.webseller.model.SanPham;
import son.nguyen.webseller.repository.SanPhamRepository;
import son.nguyen.webseller.service.SanPhamService;

import java.util.List;
import java.util.Optional;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    private SanPhamRepository sanPhamRepository;
    @Autowired
    public SanPhamServiceImpl(SanPhamRepository sanPhamRepository) {
        this.sanPhamRepository = sanPhamRepository;
    }

    @Override
    public SanPham addSanPham(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
        return sanPham;
    }

    @Override
    public SanPham updateSanPham(SanPham sanPham) {
        Optional<SanPham> sanPham1 =sanPhamRepository.findById(sanPham.getId());
        if (!sanPham1.isPresent()){
            return null;
        }
        sanPham1.get().setTenSanPham(sanPham.getTenSanPham());
        sanPham1.get().setGia(sanPham.getGia());
        sanPham1.get().setHsDiscount(sanPham.getHsDiscount());
        sanPham1.get().setLoai(sanPham.getLoai());
        sanPham1.get().setMota(sanPham.getMota());
        sanPhamRepository.save(sanPham1.get());
        return sanPham1.get();
    }

    @Override
    public SanPham getSanPhamById(Long id) {
        return  sanPhamRepository.findById(id).get();
    }

    @Override
    public List<SanPham> getSanPhamByLoai(String loai) {
        List<SanPham> sanPhams=sanPhamRepository.findByLoai(loai);
        return sanPhams;
    }

    @Override
    public List<String> getAllLoaiSanPham() {
        List<String> strings =sanPhamRepository.findAllLoaiSanPham();
        return strings;
    }
}
