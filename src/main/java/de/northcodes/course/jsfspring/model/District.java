package de.northcodes.course.jsfspring.model;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "district")
public class District {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "area")
    private Double area;
    @Column(name = "population")
    private Double population;
    @Column(name = "foreigner_pct")
    private Double foreignerPct;
    @Column(name = "age_lt18pct")
    private Double ageLt18Pct;
    @Column(name = "age_gt75pct")
    private Double ageGt75Pct;
    @Column(name = "area_settle_pct")
    private Double areaSettlePct;
    @Column(name = "area_nature_pct")
    private Double areaNaturePct;
    @Column(name = "living_space")
    private Double livingSpace;
    @Column(name = "cars")
    private Double cars;
    @Column(name = "income")
    private Double income;
    @Column(name = "bip")
    private Double bip;
    @Column(name = "unemployment_rate")
    private Double unemploymentRate;
    @Column(name = "lat")
    private Double lat;
    @Column(name = "lon")
    private Double lon;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    private List<Vote> votes = List.of();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPopulation() {
        return population;
    }

    public void setPopulation(Double population) {
        this.population = population;
    }

    public Double getForeignerPct() {
        return foreignerPct;
    }

    public void setForeignerPct(Double foreignerPct) {
        this.foreignerPct = foreignerPct;
    }

    public Double getAgeLt18Pct() {
        return ageLt18Pct;
    }

    public void setAgeLt18Pct(Double ageLt18Pct) {
        this.ageLt18Pct = ageLt18Pct;
    }

    public Double getAgeGt75Pct() {
        return ageGt75Pct;
    }

    public void setAgeGt75Pct(Double ageGt75Pct) {
        this.ageGt75Pct = ageGt75Pct;
    }

    public Double getAreaSettlePct() {
        return areaSettlePct;
    }

    public void setAreaSettlePct(Double areaSettlePct) {
        this.areaSettlePct = areaSettlePct;
    }

    public Double getAreaNaturePct() {
        return areaNaturePct;
    }

    public void setAreaNaturePct(Double areaNaturePct) {
        this.areaNaturePct = areaNaturePct;
    }

    public Double getLivingSpace() {
        return livingSpace;
    }

    public void setLivingSpace(Double livingSpace) {
        this.livingSpace = livingSpace;
    }

    public Double getCars() {
        return cars;
    }

    public void setCars(Double cars) {
        this.cars = cars;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getBip() {
        return bip;
    }

    public void setBip(Double bip) {
        this.bip = bip;
    }

    public Double getUnemploymentRate() {
        return unemploymentRate;
    }

    public void setUnemploymentRate(Double unemploymentRate) {
        this.unemploymentRate = unemploymentRate;
    }

    public Double getLat() {
        return lat == null ? 0 : lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon == null ? 0 : lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void addVote(Vote vote) {
        this.votes.add(vote);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        District district = (District) o;
        return id != null && Objects.equals(id, district.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}


