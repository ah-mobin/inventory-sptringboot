package inventory.products.services;

import inventory.products.dto.BrandRequestModel;
import inventory.products.entities.BrandEntity;
import inventory.products.repositories.BrandRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BrandServiceImplement implements BrandService{

    @Autowired
    BrandRepository brandRepository;


    @Override
    public List<BrandEntity> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public BrandEntity storeBrand(BrandRequestModel brandRequestModel) {
        BrandEntity brandEntity = new BrandEntity();
        BeanUtils.copyProperties(brandRequestModel,brandEntity);
        brandEntity.setCreateAt(new Date());
        return brandRepository.save(brandEntity);
    }
}
