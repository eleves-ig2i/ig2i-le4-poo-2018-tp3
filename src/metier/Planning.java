package metier;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entité représentant un planning.
 * @author user
 */
@Entity
@Table(name = "PLANNING")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Planning.findAll", query = "SELECT p FROM Planning p")
	, @NamedQuery(name = "Planning.findById", query = "SELECT p FROM Planning p WHERE p.id = :id")
	, @NamedQuery(name = "Planning.findByCout", query = "SELECT p FROM Planning p WHERE p.cout = :cout")})

public class Planning implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)   
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "COUT")
	private double cout;
	
	@JoinColumn(name = "NINSTANCE", referencedColumnName = "ID")	
	@ManyToOne
	private Instance ninstance;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "nplanning")
	private Set<Vehicule> ensVehicules;

	/**
	 * Constructeur par défault.
	 */
	public Planning() {
		this.ensVehicules = new HashSet<>();
	}

	/**
	 * Constructeur par données.
	 * @param cout TODO
	 */
	public Planning(double cout) {
		this();
		if (cout < 0) cout = 0.0;
		this.cout = cout;
	}

	public Integer getId() {
		return id;
	}

	public double getCout() {
		return cout;
	}

	public void setCout(double cout) {
		this.cout = cout;
	}

	public Instance getNinstance() {
		return ninstance;
	}

	public void setNinstance(Instance ninstance) {
		this.ninstance = ninstance;
	}

	@XmlTransient
	public Set<Vehicule> getEnsVehicules() {
		return ensVehicules;
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
		if (!(object instanceof Planning)) {
			return false;
		}
		Planning other = (Planning) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Planning n°" + id + " : coût => " + cout;
	}
	
}