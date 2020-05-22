package br.org.certi.apiextenso.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "ten")
public class Dezena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double rangeMin;
    private Double rangeMax;
    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();;

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

    public Double getRangeMin() {
        return rangeMin;
    }

    public void setRangeMin(Double rangeMin) {
        this.rangeMin = rangeMin;
    }

    public Double getRangeMax() {
        return rangeMax;
    }

    public void setRangeMax(Double rangeMax) {
        this.rangeMax = rangeMax;
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

        Dezena dezena = (Dezena) o;

        if (id != null ? !id.equals(dezena.id) : dezena.id != null) return false;
        if (name != null ? !name.equals(dezena.name) : dezena.name != null) return false;
        if (rangeMin != null ? !rangeMin.equals(dezena.rangeMin) : dezena.rangeMin != null) return false;
        if (rangeMax != null ? !rangeMax.equals(dezena.rangeMax) : dezena.rangeMax != null) return false;
        return createdDate != null ? createdDate.equals(dezena.createdDate) : dezena.createdDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (rangeMin != null ? rangeMin.hashCode() : 0);
        result = 31 * result + (rangeMax != null ? rangeMax.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        return result;
    }
}
