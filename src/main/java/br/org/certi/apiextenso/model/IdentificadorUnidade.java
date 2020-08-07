package br.org.certi.apiextenso.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "unit_identifier")
public class IdentificadorUnidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int rangeMin;
    private int rangeMax;
    private int separatorPoints;
    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRangeMin() {
        return rangeMin;
    }

    public void setRangeMin(int rangeMin) {
        this.rangeMin = rangeMin;
    }

    public int getRangeMax() {
        return rangeMax;
    }

    public void setRangeMax(int rangeMax) {
        this.rangeMax = rangeMax;
    }

    public int getSeparatorPoints() {
        return separatorPoints;
    }

    public void setSeparatorPoints(int separatorPoints) {
        this.separatorPoints = separatorPoints;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IdentificadorUnidade that = (IdentificadorUnidade) o;

        if (rangeMin != that.rangeMin) return false;
        if (rangeMax != that.rangeMax) return false;
        if (separatorPoints != that.separatorPoints) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return createdDate != null ? createdDate.equals(that.createdDate) : that.createdDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + rangeMin;
        result = 31 * result + rangeMax;
        result = 31 * result + separatorPoints;
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        return result;
    }
}
