package de.northcodes.course.jsfspring.service;

import de.northcodes.course.jsfspring.commons.WebAppException;
import de.northcodes.course.jsfspring.model.District;
import de.northcodes.course.jsfspring.repository.DistrictRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictService {
    private final DistrictRepository repository;

    public DistrictService(DistrictRepository repository) {
        this.repository = repository;
    }

    public List<District> getAllDistricts() {
        return repository.findAll();
    }

    public District getDistrictById(int id) throws WebAppException {
        Optional<District> districtOpt = repository.findById(id);
        if (districtOpt.isEmpty()) {
            throw new WebAppException(WebAppException.WEBAPP_ERROR.DISTRICT_NOT_FOUND);
        }

        return districtOpt.get();
    }
}
