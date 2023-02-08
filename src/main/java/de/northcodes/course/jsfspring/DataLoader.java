package de.northcodes.course.jsfspring;

import de.northcodes.course.jsfspring.model.District;
import de.northcodes.course.jsfspring.model.Vote;
import de.northcodes.course.jsfspring.repository.DistrictRepository;
import de.northcodes.course.jsfspring.repository.VoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class DataLoader implements CommandLineRunner {

    private final DistrictRepository districtRepository;
    private final VoteRepository voteRepository;

    public DataLoader(DistrictRepository districtRepository, VoteRepository voteRepository) {
        this.districtRepository = districtRepository;
        this.voteRepository = voteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        districtRepository.<District>saveAll(Objects.requireNonNull(loadDistrictData()));
        voteRepository.<Vote>saveAll(Objects.requireNonNull(loadVoteData()));
    }

    private List<District> loadDistrictData() {
        String DISTRICT_FILENAME_CSV = "btw21_strukturdaten.csv";
        InputStream inputStream = DataLoader.class.getResourceAsStream(String.format("/%s", DISTRICT_FILENAME_CSV));
        InputStreamReader streamReader = new InputStreamReader(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8);

        try (BufferedReader br = new BufferedReader(streamReader)) {
            String[] headers = br.readLine().split(";");

            return br.lines().map(s -> {
                List<String> values = convertValues(headers, s.split(";"));

                District district = new District();
                district.setId(validateInteger(values.get(0)));
                district.setName(values.get(1));
                district.setArea(validateDouble(values.get(2)));
                district.setPopulation(validateDouble(values.get(3)));
                district.setForeignerPct(validateDouble(values.get(4)));
                district.setAgeLt18Pct(validateDouble(values.get(5)));
                district.setAgeGt75Pct(validateDouble(values.get(6)));
                district.setAreaSettlePct(validateDouble(values.get(7)));
                district.setAreaNaturePct(validateDouble(values.get(8)));
                district.setLivingSpace(validateDouble(values.get(9)));
                district.setCars(validateDouble(values.get(10)));
                district.setIncome(validateDouble(values.get(11)));
                district.setBip(validateDouble(values.get(12)));
                district.setUnemploymentRate(validateDouble(values.get(13)));

                return district;
            }).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private List<Vote> loadVoteData() {
        String VOTE_FILENAME_CSV = "btw21_ergebnisse.csv";
        InputStream inputStream = DataLoader.class.getResourceAsStream(String.format("/%s", VOTE_FILENAME_CSV));
        InputStreamReader streamReader = new InputStreamReader(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8);

        try (BufferedReader br = new BufferedReader(streamReader)) {
            String[] headers = br.readLine().split(";");

            return br.lines().map(s -> {
                List<String> values = convertValues(headers, s.split(";"));

                Vote vote = new Vote();
                vote.setDistrictId(validateInteger(values.get(0)));
                vote.setName(values.get(1));
                vote.setPartyType(values.get(2));
                vote.setRank(validateInteger(values.get(3)));
                vote.setVoteType(values.get(4));
                vote.setCount(validateInteger(values.get(5)));
                vote.setPct(validateDouble(values.get(6)));

                return vote;
            }).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private List<String> convertValues(String[] headers, String[] values) {
        return IntStream.range(0, headers.length)
                .mapToObj(i -> {
                    if (i >= values.length) {
                        return "";
                    }

                    return values[i].replace(".", "").replace(",", ".");
                }).collect(Collectors.toList());
    }

    private Long validateLong(String attribute) {
        return Long.parseLong(attribute);
    }

    private Integer validateInteger(String attribute) {
        return attribute.isEmpty() ? 0 : Integer.parseInt(attribute);
    }

    private Double validateDouble(String attribute) {
        return attribute.isEmpty() ? 0 : Double.parseDouble((attribute));
    }
}
