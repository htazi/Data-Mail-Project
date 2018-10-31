package edu.ccsu.datamail.jobtracker.entity;

import javax.persistence.*;

@Entity
@Table(name = "client", uniqueConstraints = {
        @UniqueConstraint(name = "client_pk", columnNames = "client_id")
})
public class Client
{

    @Id
    @GeneratedValue
    @Column(name = "client_id", nullable = false)
    private int clientId;

    @Column(name = "client_name", length = 30)
    private String clientName;

    @Column(name = "address", length = 45)
    private String address;

    public int getClientId()
    {
        return clientId;
    }

    public void setClientId(int clientId)
    {
        this.clientId = clientId;
    }

    public String getClientName()
    {
        return clientName;
    }

    public void setClientName(String clientName)
    {
        this.clientName = clientName;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

}

