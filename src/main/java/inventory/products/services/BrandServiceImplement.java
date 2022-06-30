package inventory.products.services;

import inventory.products.dto.BrandDto;
import inventory.products.request.BrandRequestModel;
import inventory.products.entities.BrandEntity;
import inventory.products.repositories.BrandRepository;
import inventory.products.response.BrandResponseModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BrandServiceImplement implements BrandService{

    @Autowired
    BrandRepository brandRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<BrandResponseModel> getAllBrands() {
        return brandRepository.findAll().stream()
                .map(BrandResponseModel.class) // I assume you could also do this .map(AdminDto::convertDaoToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BrandDto storeBrand(BrandDto brandDto) {
        BrandEntity brandEntity = new BrandEntity();
        UUID brandUUID = UUID.randomUUID();
        brandDto.setUuid(brandUUID);
        brandDto.setCreatedAt(new Date());
        BeanUtils.copyProperties(brandDto, brandEntity);
        BrandEntity createdBrand = brandRepository.save(brandEntity);
        BrandDto brandCreatedDto = new BrandDto();
        BeanUtils.copyProperties(createdBrand, brandCreatedDto);
        return brandCreatedDto;
    }
}
