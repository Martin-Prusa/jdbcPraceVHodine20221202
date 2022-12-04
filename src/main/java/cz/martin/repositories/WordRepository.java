package cz.martin.repositories;

import cz.martin.models.Country;
import cz.martin.models.CountryFilter;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class WordRepository {

    public List<Country> getCountries(CountryFilter filter) {
        List<Country> countries = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost/word?user=root&password=password");
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT W.name, W.continent, W.area, W.population, W.gdp, W.capital,W.tld FROM world AS W WHERE W.name LIKE ? AND W.continent LIKE ? AND W.population >= ? AND W.population <= ? AND W.area >= ? AND W.area <= ? AND W.gdp >= ? AND W.gdp <= ?"
            );

            preparedStatement.setString(1, "%"+filter.getName()+"%");
            preparedStatement.setString(2, "%"+filter.getContinent());
            preparedStatement.setLong(3, filter.getPopulationFrom());
            preparedStatement.setLong(4, filter.getValidPopulationTo());
            preparedStatement.setInt(5, filter.getAreaFrom());
            preparedStatement.setInt(6, filter.getValidAreaTo());
            preparedStatement.setLong(7, filter.getHdpFrom());
            preparedStatement.setLong(8, filter.getValidHDPTo());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                countries.add(new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getLong(4), resultSet.getLong(5), resultSet.getString(6), resultSet.getString(7)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return countries;
    }

    public List<String> getContinents() {
        List<String> continents = new ArrayList<>();
        continents.add("");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost/word?user=root&password=password");
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT DISTINCT W.continent FROM world AS W"
            );

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                continents.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return continents;
    }
}
