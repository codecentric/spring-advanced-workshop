package de.codecentric.app.repository;

import de.codecentric.app.model.Farmer;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FarmerRepository {

    // TODO

    @Resource
    public void setDataSource(DataSource dataSource) {
        // TODO
    }

    public Farmer findByLastName(String name) {
        // TODO
        return null;
    }

    public List<Farmer> findAll() {
        // TODO
        return null;
    }

    private Farmer mapFarmer(ResultSet rs) throws SQLException {
        Farmer farmer = new Farmer();
        farmer.setFirstName(rs.getString("FARMER_FIRSTNAME"));
        farmer.setLastName(rs.getString("FARMER_LASTNAME"));
        return farmer;
    }
}
