package edu.utcluj.track.position;

import javafx.geometry.Pos;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Query;;
import java.time.LocalDateTime;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

/**
 * @author radu.miron
 * @since 18.10.2016
 */
@Service
public class PositionService {
    @Autowired
    private PositionRepository positionRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public Position savePosition(Position position) {
        return positionRepository.save(position);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Position> getPosition(String id, Date startDate, Date endDate) {

        return positionRepository.findByTerminalIdAndStartDateAndEndDate(id,startDate,endDate);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Position updatePosition(Position position ) {
        return positionRepository.save(position);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deletePosition(Long id ) {
         positionRepository.delete(id);
    }
}
