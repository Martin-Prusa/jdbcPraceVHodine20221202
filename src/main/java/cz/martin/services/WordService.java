package cz.martin.services;

import cz.martin.models.Country;
import cz.martin.models.CountryFilter;
import cz.martin.repositories.WordRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class WordService {

    @Inject
    private WordRepository wordRepository;

    public List<Country> getCountries(CountryFilter filter) {
        return wordRepository.getCountries(filter);
    }

    public List<String> getContinents() {
        return wordRepository.getContinents();
    }
}
