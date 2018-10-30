

package edu.ccsu.datamail.jobtracker.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Persistent_Logins", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "PERSISTENT_LOGINS_UK", columnNames = "username")}) //
public class PersistentLogins
{

    @Id
    @GeneratedValue
    @Column(name = "series", length = 64, nullable = false)
    private String series;

    @Column(name = "username", length = 64, nullable = false)
    private String username;

    @Column(name = "token", length = 64, nullable = false)
    private String token;

    @Column(name = "last_used", length = 32, nullable = false)
    private LocalDate lastUsed ;

    public String getSeries(){return series;}

    public void setSeries(String series){this.series = series;}

    public String getUserName(){return username;}

    public void setUserName(String username){this. username = username;}

    public String getToken() {return token;}

    public void setToken(String token){this.token = token;}




}


