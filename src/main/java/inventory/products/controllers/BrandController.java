package inventory.products.controllers;

import inventory.products.dto.BrandRequestModel;
import inventory.products.entities.BrandEntity;
import inventory.products.services.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService){
        this.brandService = brandService;
    }

    @GetMapping()
    public ResponseEntity<List<BrandEntity>> index(){
        return ResponseEntity.ok(brandService.getAllBrands());
    }

    @PostMapping()
    public ResponseEntity<BrandEntity> store(@RequestBody BrandRequestModel brandRequestModel){
        return new ResponseEntity<>(brandService.storeBrand(brandRequestModel), HttpStatus.CREATED);
    }
}
