package son.nguyen.webseller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import son.nguyen.webseller.model.HoaDon;
import son.nguyen.webseller.service.HoaDonService;

@RestController
public class HoaDonController {
    private HoaDonService hoaDonService;

    @Autowired
    public HoaDonController(HoaDonService hoaDonService) {
        this.hoaDonService = hoaDonService;
    }

    @RequestMapping(value = "/addHoaDon", method = RequestMethod.GET)
    public ResponseEntity<?> addHoaDon(@RequestHeader String Authorization, @RequestBody HoaDon hoaDon, @RequestParam String phoneCustomer){
        return  null;
    }

}
