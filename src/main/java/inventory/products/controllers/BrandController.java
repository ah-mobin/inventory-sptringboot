package inventory.products.controllers;

import inventory.products.dto.BrandDto;
import inventory.products.request.BrandRequestModel;
import inventory.products.entities.BrandEntity;
import inventory.products.response.BrandResponseModel;
import inventory.products.services.BrandService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<BrandResponseModel> store(@RequestBody BrandRequestModel brandRequestModel){
        BrandResponseModel brandResponseModel = new BrandResponseModel();
        BrandDto brandDto = new BrandDto();
        BeanUtils.copyProperties(brandRequestModel, brandDto);
        BrandDto brandCreated = brandService.storeBrand(brandDto);
        BeanUtils.copyProperties(brandCreated, brandResponseModel);
        return new ResponseEntity<>(brandResponseModel, HttpStatus.CREATED);
    }
}
