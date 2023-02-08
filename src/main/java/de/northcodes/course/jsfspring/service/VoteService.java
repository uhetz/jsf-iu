package de.northcodes.course.jsfspring.service;

import de.northcodes.course.jsfspring.commons.WebAppException;
import de.northcodes.course.jsfspring.model.Vote;
import de.northcodes.course.jsfspring.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VoteService {
    private final VoteRepository repository;
    public VoteService(VoteRepository repository) {
        this.repository = repository;
    }

    public List<Vote> getAllVotes() {
        return repository.findAll();
    }

    public List<Vote> findVotesByName(String name) throws WebAppException {
        List<Vote> vote = repository.findByName(name);
        if (vote.isEmpty()) {
            throw new WebAppException(WebAppException.WEBAPP_ERROR.VOTE_NOT_FOUND);
        }

        return vote;
    }

    public Map<String, Integer> findTop10PoliticalParty() {
        List<Vote> vote = repository.findByName("Partei");
        return vote.stream()
                .collect(Collectors.groupingBy(Vote::getPartyType, Collectors.summingInt(Vote::getCount)))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
