package inventory.products.services;

import inventory.products.dto.BrandRequestModel;
import inventory.products.entities.BrandEntity;

import java.util.List;

public interface BrandService {
    List<BrandEntity> getAllBrands();

    BrandEntity storeBrand(BrandRequestModel brandRequestModel);
}
