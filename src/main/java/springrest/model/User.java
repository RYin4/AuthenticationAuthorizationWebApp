package springrest.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, unique = true)
	private String username;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private boolean enabled;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "email")
	private String email;

	//administrator, Reward Provider, Event Organizer
	@ManyToMany
	@JoinTable(name = "authorities", 
	joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	//positions = Student, Faculty, or Staff
	@ManyToOne
	@JoinColumn(name = "position_id")
	private Position position;

	//organizations = college, department, division, office, or undeclared
	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organization;

	//title = Director or president 
	@ManyToOne
	@JoinColumn(name = "title_id")
	private Title title;

	//program_affiliations table will link users with affiliations
	@ManyToMany
	@JoinTable(name = "program_affiliations", //College, Department, Division, eg. Office of Graduate Studies
	joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "affiliation_id"))
	private Set<Affiliation> affiliations;
	
	public User()
	{
		enabled = true;
		roles = new HashSet<Role>();
		affiliations = new HashSet<Affiliation>();
	}

	public Long getId()
	{
		return id;
	}

	public void setId( Long id )
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername( String username )
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword( String password )
	{
		this.password = password;
	}

	public boolean isEnabled()
	{
		return enabled;
	}

	public void setEnabled( boolean enabled )
	{
		this.enabled = enabled;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName( String firstName )
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName( String lastName )
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail( String email )
	{
		this.email = email;
	}

	public Set<Role> getRoles()
	{
		return roles;
	}

	public void setRoles( Set<Role> roles )
	{
		this.roles = roles;
	}

	public Position getPosition()
	{
		return position;
	}

	public void setPosition( Position position )
	{
		this.position = position;
	}

	public Organization getOrganization()
	{
		return organization;
	}

	public void setOrganization( Organization organization )
	{
		this.organization = organization;
	}

	public Title getTitle()
	{
		return title;
	}

	public void setTitle( Title title )
	{
		this.title = title;
	}

	public Set<Affiliation> getAffiliations()
	{
		return affiliations;
	}

	public void setAffiliations( Set<Affiliation> affiliations )
	{
		this.affiliations = affiliations;
	}


}