package inventory.products.services;

import inventory.products.dto.BrandDto;
import inventory.products.request.BrandRequestModel;
import inventory.products.entities.BrandEntity;
import inventory.products.response.BrandResponseModel;

import java.util.List;

public interface BrandService {
    List<BrandResponseModel> getAllBrands();

    BrandDto storeBrand(BrandDto brandDto);
}
