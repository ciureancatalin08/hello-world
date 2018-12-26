package edu.utcluj.track.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author radu.miron
 * @since 18.10.2016
 */
@RestController
@RequestMapping(value = "/position")
public class PositionController {


 //    }
    @Autowired
    private PositionService positionService;

    @RequestMapping(method = RequestMethod.POST)
    public Position save(@RequestBody Position position,HttpServletResponse response) {
        if (position.getId() != null) {
            throw new IllegalArgumentException("Invalid 'id' value. It should be empty");
        }
        return positionService.savePosition(position);
    }




    @RequestMapping(method = RequestMethod.GET)
    public List<Position> find(@RequestParam String terminalId, @RequestParam @DateTimeFormat (pattern="yyyy-MM-dd HH:mm:ss") Date startDate,@RequestParam @DateTimeFormat (pattern="yyyy-MM-dd HH:mm:ss") Date endDate,
                                HttpServletRequest request,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
        return positionService.getPosition(terminalId,startDate,endDate);
    }

    @PutMapping("{id}")
    public Position update(@RequestBody Position position ,@PathVariable long id,@PathVariable String latitude) {

        if (position.getId() != null) {
            throw new IllegalArgumentException("Invalid 'id' value. It should be empty");
        }
        position.setId(id);
        position.setLatitude(latitude);
        return positionService.updatePosition(position);
    }
    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable long id) {
        positionService.deletePosition(id);
    }
}