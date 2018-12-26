package edu.utcluj.track.position;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author radu.miron
 * @since 18.10.2016
 */
@Entity
public class Position {
    @Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long id;


    @NotNull
    @Size(min = 5, max = 10, message = "terminalId must be between 5 and 10 characters long")
    private String terminalid;

    @Column(name = "createtime", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Date createtime;

    @NotNull
//    @Pattern(regexp = "\\d+\\.\\d+")
    private String latitude;

    @NotNull
    private String longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTerminalId() {
        return terminalid;
    }


    public void setTerminalId(String terminalid) {
        this.terminalid = terminalid;
    }


    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


}
