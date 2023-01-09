package monprojet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.City;
import monprojet.entity.Country;
import monprojet.dto.PopPays;

// This will be AUTO IMPLEMENTED by Spring 

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query (value = "Select SUM(population) "
            + "From city"
            + " Where country_id = :paysId", nativeQuery = true)

    public Integer popPourPays(Integer paysId);

    @Query (value = "Select contry.name as name, Count(city.population) as population"
            + "From country country"
            + "Inner Join city city"
            + "On(country.id=ci.country_id)"
            + "Group by co.name", nativeQuery = true)

    public List<PopPays> popParPays();
}
