package de.northcodes.course.jsfspring.bean;

import de.northcodes.course.jsfspring.model.District;
import de.northcodes.course.jsfspring.model.Vote;
import de.northcodes.course.jsfspring.service.DistrictService;
import de.northcodes.course.jsfspring.service.VoteService;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@RequestScoped
@Component
@ManagedBean
public class Listing {
    private final DistrictService districtService;
    private final VoteService voteService;


    public Listing(DistrictService districtService, VoteService voteService) {
        this.districtService = districtService;
        this.voteService = voteService;
    }

    public List<District> getDistricts() {
        return districtService.getAllDistricts();
    }

    public List<Vote> getVotes() {
        return voteService.getAllVotes();
    }
}
