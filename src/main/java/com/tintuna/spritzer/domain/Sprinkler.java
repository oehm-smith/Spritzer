/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tintuna.spritzer.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bsmith
 */
@Entity
@Table(name = "sprinklers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sprinkler.findAll", query = "SELECT s FROM Sprinkler s"),
    @NamedQuery(name = "Sprinkler.findById", query = "SELECT s FROM Sprinkler s WHERE s.id = :id"),
    @NamedQuery(name = "Sprinkler.findByName", query = "SELECT s FROM Sprinkler s WHERE s.name = :name"),
    @NamedQuery(name = "Sprinkler.findByConfiguration", query = "SELECT s FROM Sprinkler s WHERE s.configuration = :configuration")})
public class Sprinkler implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Size(max = 128)
    @Column(name = "configuration", length = 128)
    private String configuration;
    @ManyToMany(mappedBy = "sprinklersCollection")
    private Collection<Programme> programmesCollection;
    @JoinColumn(name = "sprinklerSet_ID", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Sprinklerset sprinklerSetID;
    @JoinColumn(name = "sprinklerDevice_ID", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Sprinklerdevice sprinklerDeviceID;
    @JoinColumn(name = "location_ID", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Location locationID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sprinklersID")
    private Collection<Run> runCollection;

    public Sprinkler() {
    }

    public Sprinkler(Integer id) {
        this.id = id;
    }

    public Sprinkler(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    @XmlTransient
    public Collection<Programme> getProgrammesCollection() {
        return programmesCollection;
    }

    public void setProgrammesCollection(Collection<Programme> programmesCollection) {
        this.programmesCollection = programmesCollection;
    }

    public Sprinklerset getSprinklerSetID() {
        return sprinklerSetID;
    }

    public void setSprinklerSetID(Sprinklerset sprinklerSetID) {
        this.sprinklerSetID = sprinklerSetID;
    }

    public Sprinklerdevice getSprinklerDeviceID() {
        return sprinklerDeviceID;
    }

    public void setSprinklerDeviceID(Sprinklerdevice sprinklerDeviceID) {
        this.sprinklerDeviceID = sprinklerDeviceID;
    }

    public Location getLocationID() {
        return locationID;
    }

    public void setLocationID(Location locationID) {
        this.locationID = locationID;
    }

    @XmlTransient
    public Collection<Run> getRunCollection() {
        return runCollection;
    }

    public void setRunCollection(Collection<Run> runCollection) {
        this.runCollection = runCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sprinkler)) {
            return false;
        }
        Sprinkler other = (Sprinkler) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tintuna.zpersistencetest.Sprinklers[ id=" + id + " ]";
    }
    
}
