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
@Table(name = "sprinklersets")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sprinklerset.findAll", query = "SELECT s FROM Sprinklerset s"),
    @NamedQuery(name = "Sprinklerset.findById", query = "SELECT s FROM Sprinklerset s WHERE s.id = :id"),
    @NamedQuery(name = "Sprinklerset.findByName", query = "SELECT s FROM Sprinklerset s WHERE s.name = :name"),
    @NamedQuery(name = "Sprinklerset.findByGarden", query = "SELECT s FROM Sprinklerset s WHERE s.gardenID = :gardenId")})
public class Sprinklerset extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sprinklerSetID")
    private Collection<Sprinkler> sprinklersCollection;
    @JoinColumn(name = "garden_ID", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Garden gardenID;

    public Sprinklerset() {
    }

    public Sprinklerset(Integer id) {
        this.id = id;
    }

    public Sprinklerset(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Sprinkler> getSprinklersCollection() {
        return sprinklersCollection;
    }

    public void setSprinklersCollection(Collection<Sprinkler> sprinklersCollection) {
        this.sprinklersCollection = sprinklersCollection;
    }

    public Garden getGardenID() {
        return gardenID;
    }

    public void setGardenID(Garden gardenID) {
        this.gardenID = gardenID;
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
        if (!(object instanceof Sprinklerset)) {
            return false;
        }
        Sprinklerset other = (Sprinklerset) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tintuna.zpersistencetest.Sprinklersets[ id=" + id + " ]";
    }
    
}
