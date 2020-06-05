package com.jackrutorial.models;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

//rowmapper for setting fields of chart  data
public class chartrowmapper1 implements RowMapper<chart> {
    @Override
    public chart mapRow(ResultSet rs, int rowNum) throws SQLException {
        chart c = new chart();
        c.setCount(rs.getInt("count"));
        c.setTitle(rs.getString("location"));
        return c;
    }
}
