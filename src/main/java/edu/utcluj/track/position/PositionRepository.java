package edu.utcluj.track.position;

import javafx.geometry.Pos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * @author radu.miron
 * @since 18.10.2016
 */
public interface PositionRepository extends CrudRepository<Position, Long> {
    @Query ("SELECT p FROM Position p WHERE p.terminalid= :terminalId AND p.createtime BETWEEN :startDate AND :endDate")

    List<Position> findByTerminalIdAndStartDateAndEndDate(@Param("terminalId") String terminalId,
                                                          @Param("startDate")Date startDate,
                                                          @Param("endDate") Date endDate);

}
