package com.jackrutorial.models;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

//rowmapper for setting  skills chart data
public class chartrowmapper implements RowMapper<chart> {
    @Override
    public chart mapRow(ResultSet rs, int rowNum) throws SQLException {
        chart c = new chart();
        c.setCount(rs.getInt("count"));
        c.setTitle(rs.getString("skills"));
        return c;
    }
}
