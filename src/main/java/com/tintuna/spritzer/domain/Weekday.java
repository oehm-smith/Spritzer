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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bsmith
 */
@Entity
@Table(name = "weekdays")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Weekday.findAll", query = "SELECT w FROM Weekday w"),
    @NamedQuery(name = "Weekday.findById", query = "SELECT w FROM Weekday w WHERE w.id = :id"),
    @NamedQuery(name = "Weekday.findByDayName", query = "SELECT w FROM Weekday w WHERE w.dayName = :dayName")})
public class Weekday extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 10)
    @Column(name = "DayName", length = 10)
    private String dayName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dayOfWeekID")
    private Collection<Programme> programmesCollection;

    public Weekday() {
    }

    public Weekday(Integer id) {
        this.id = id;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    @XmlTransient
    public Collection<Programme> getProgrammesCollection() {
        return programmesCollection;
    }

    public void setProgrammesCollection(Collection<Programme> programmesCollection) {
        this.programmesCollection = programmesCollection;
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
        if (!(object instanceof Weekday)) {
            return false;
        }
        Weekday other = (Weekday) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tintuna.domain.Weekdays[ id=" + id + " ]";
    }
    
}
