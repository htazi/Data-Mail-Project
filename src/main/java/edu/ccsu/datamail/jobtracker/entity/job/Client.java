package edu.ccsu.datamail.jobtracker.entity.job;

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

    /**
     * Default Constructor:
     */
    public Client()
    {
    }

    /**
     * Alternate Constructor
     * Creates a client with the specified name and address
     *
     * @param clientName the name of the client
     * @param address    the address of the client
     */
    public Client(String clientName, String address)
    {
        this.clientName = clientName;
        this.address = address;
    }

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

    /**
     * Determines if this object is equal to another object
     *
     * @param o the object this object is being compared to
     * @return true if the two objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Client)) {
            return false;
        }

        Client client = (Client) o;

        if (clientId != client.clientId) {
            return false;
        }
        if (clientName != null ? !clientName.equals(client.clientName) : client.clientName != null) {
            return false;
        }
        return address != null ? address.equals(client.address) : client.address == null;
    }

    /**
     * Returns a hashCode value for this object
     *
     * @return an integer hash code for this object
     */
    @Override
    public int hashCode()
    {
        int result = clientId;
        result = 31 * result + (clientName != null ? clientName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}

