package com.smart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import com.smart.domain.ViewPoint;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class ViewPointDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private LobHandler lobHandler;

    public void addViewPoint(final ViewPoint viewPoint) {
        String sql = " INSERT INTO t_view_point" +
                " (space_id, point_name, ticket_price, img_file, description)" +
                " VALUES(?, ?, ?, ?, ?)";
        jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
            @Override
            protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException,
                    DataAccessException {
                ps.setInt(1, viewPoint.getSpaceId());
                ps.setString(2, viewPoint.getPointName());
                ps.setDouble(3, viewPoint.getTicketPrice());
                lobCreator.setBlobAsBytes(ps, 4, viewPoint.getImgFile());
                lobCreator.setClobAsString(ps, 5, viewPoint.getDescription());
            }
        });
    }
}
