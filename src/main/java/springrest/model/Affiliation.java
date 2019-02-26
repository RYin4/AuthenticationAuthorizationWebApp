package springrest.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "affiliations")
public class Affiliation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "affiliation_name", nullable = false)
    private String name;
    
    @Column(name = "full_name", nullable = false)
    private String fullname;
    
    
    @Column(name = "affiliation_description", nullable = false)
	private String description;
    
    public Affiliation() 
    {
    }
    
	public Long getId() 
	{
		return id;
	}
	
	public void setId(Long id) 
	{
		this.id = id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getFullname() 
	{
		return fullname;
	}
	
	public void setFullname(String fullname) 
	{
		this.fullname = fullname;
	}
	
	public String getDescription() 
	{
		return description;
	}
	
	public void setDescription(String description) 
	{
		this.description = description;
	}
    
}