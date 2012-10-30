/**
* This file is part of Spritzer.
 
Spritzer is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
 
Spritzer is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.
 
You should have received a copy of the GNU General Public License
along with Spritzer.  If not, see http://www.gnu.org/licenses/.
 
* Copyright 2012 Brooke Smith, tintuna.com.
**/
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
@Table(name = "sprinklerdevice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sprinklerdevice.findAll", query = "SELECT s FROM Sprinklerdevice s"),
    @NamedQuery(name = "Sprinklerdevice.findById", query = "SELECT s FROM Sprinklerdevice s WHERE s.id = :id"),
    @NamedQuery(name = "Sprinklerdevice.findByName", query = "SELECT s FROM Sprinklerdevice s WHERE s.name = :name"),
    @NamedQuery(name = "Sprinklerdevice.findByModelNo", query = "SELECT s FROM Sprinklerdevice s WHERE s.modelNo = :modelNo"),
    @NamedQuery(name = "Sprinklerdevice.findByFlowRate", query = "SELECT s FROM Sprinklerdevice s WHERE s.flowRate = :flowRate"),
    @NamedQuery(name = "Sprinklerdevice.findByRadiusSpray", query = "SELECT s FROM Sprinklerdevice s WHERE s.radiusSpray = :radiusSpray"),
    @NamedQuery(name = "Sprinklerdevice.findByConfigItems", query = "SELECT s FROM Sprinklerdevice s WHERE s.configItems = :configItems")})
public class Sprinklerdevice extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 22)
    @Column(name = "modelNo", nullable = false, length = 22)
    private String modelNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flowRate", nullable = false)
    private double flowRate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "radiusSpray", precision = 22)
    private Double radiusSpray;
    @Size(max = 128)
    @Column(name = "configItems", length = 128)
    private String configItems;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sprinklerDeviceID")
    private Collection<Sprinkler> sprinklersCollection;
    @JoinColumn(name = "sprinklerType_ID", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Sprinklertype sprinklerTypeID;

    public Sprinklerdevice() {
    }

    public Sprinklerdevice(Integer id) {
        this.id = id;
    }

    public Sprinklerdevice(Integer id, String name, String modelNo, double flowRate) {
        this.id = id;
        this.name = name;
        this.modelNo = modelNo;
        this.flowRate = flowRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public double getFlowRate() {
        return flowRate;
    }

    public void setFlowRate(double flowRate) {
        this.flowRate = flowRate;
    }

    public Double getRadiusSpray() {
        return radiusSpray;
    }

    public void setRadiusSpray(Double radiusSpray) {
        this.radiusSpray = radiusSpray;
    }

    public String getConfigItems() {
        return configItems;
    }

    public void setConfigItems(String configItems) {
        this.configItems = configItems;
    }

    @XmlTransient
    public Collection<Sprinkler> getSprinklersCollection() {
        return sprinklersCollection;
    }

    public void setSprinklersCollection(Collection<Sprinkler> sprinklersCollection) {
        this.sprinklersCollection = sprinklersCollection;
    }

    public Sprinklertype getSprinklerTypeID() {
        return sprinklerTypeID;
    }

    public void setSprinklerTypeID(Sprinklertype sprinklerTypeID) {
        this.sprinklerTypeID = sprinklerTypeID;
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
        if (!(object instanceof Sprinklerdevice)) {
            return false;
        }
        Sprinklerdevice other = (Sprinklerdevice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tintuna.zpersistencetest.Sprinklerdevice[ id=" + id + " ]";
    }
    
}
