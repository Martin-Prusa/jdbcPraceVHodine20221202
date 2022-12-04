package cz.martin.beans;

import cz.martin.models.Country;
import cz.martin.models.CountryFilter;
import cz.martin.services.WordService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("word")
@RequestScoped
public class WordBean implements Serializable {
    @Inject
    private WordService wordService;

    private CountryFilter filter = new CountryFilter();

    public void submitForm() {
    }

    public List<Country> getCountries() {
        return wordService.getCountries(this.filter);
    }

    public List<String> getContinents() {
        return wordService.getContinents();
    }

    public CountryFilter getFilter() {
        return filter;
    }
}
