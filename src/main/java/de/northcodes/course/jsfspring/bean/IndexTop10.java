package de.northcodes.course.jsfspring.bean;

import de.northcodes.course.jsfspring.service.DistrictService;
import de.northcodes.course.jsfspring.service.VoteService;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestScoped
@Component
@ManagedBean

public class IndexTop10 {
    private final VoteService voteService;

    public IndexTop10(VoteService voteService) {
        this.voteService = voteService;
    }

    public List<String> getTop10ByParty() {
        return voteService.findTop10PoliticalParty().entrySet().stream()
                .map(e -> String.format("%s is leading with %d votes", e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }
}
