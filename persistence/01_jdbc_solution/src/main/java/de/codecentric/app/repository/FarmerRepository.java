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

    // Lösung 1.2
    private JdbcTemplate jdbcTemplate;

    @Resource
    public void setDataSource(DataSource dataSource) {
        // Lösung 1.3
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Farmer findByLastName(String name) {
        // Lösung 1.4
        String sql = "select * from FARMERS where FARMER_LASTNAME = ?";
        RowMapper<Farmer> rowMapper = new RowMapper<Farmer>() {

            @Override
            public Farmer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return mapFarmer(rs);
            }
        };
        return this.jdbcTemplate.queryForObject(sql, rowMapper, name);
    }

    public List<Farmer> findAll() {
        // Lösung 1.5
        String sql = "select * from FARMERS";
        RowMapper<Farmer> rowMapper = new RowMapper<>() {
            @Override
            public Farmer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return mapFarmer(rs);
            }
        };
        return this.jdbcTemplate.query(sql, rowMapper);

    }

    private Farmer mapFarmer(ResultSet rs) throws SQLException {
        Farmer farmer = new Farmer();
        farmer.setFirstName(rs.getString("FARMER_FIRSTNAME"));
        farmer.setLastName(rs.getString("FARMER_LASTNAME"));
        return farmer;
    }
}
