package de.northcodes.course.jsfspring.model;

import javax.persistence.*;

@Entity
@Table(name = "vote")
public class Vote {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "district_id")
    private int districtId;
    @Column(name = "party_type")
    private String partyType;
    @Column(name = "name")
    private String name;
    @Column(name = "rank")
    private Integer rank;
    @Column(name = "vote_type")
    private String voteType;
    @Column(name = "count")
    private Integer count;
    @Column(name = "pct")
    private Double pct;

    public String getPartyType() {
        return partyType;
    }

    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getVoteType() {
        return voteType;
    }

    public void setVoteType(String voteType) {
        this.voteType = voteType;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPct() {
        return pct;
    }

    public void setPct(Double pct) {
        this.pct = pct;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getId() {
        return id;
    }
}
