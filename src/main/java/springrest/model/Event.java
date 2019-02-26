package springrest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "event_name", nullable = false, unique = true)
	private String name;

	@Column(name = "event_description", nullable = false)
	private String description;

	@Column(name = "event_location", nullable = false)
	private String location;

	@Column(name = "start_time")
	private Date startTime;

	@Column( name = "end_time")
	private Date endTime;

	@Column(nullable = false)
	private boolean approved;
	
	//one administrator to approve an event 
	@ManyToOne
	@JoinColumn(name = "administrator_id")
	private User administrator;

	//one event organizer who can post without approval
	@ManyToOne
	@JoinColumn(name = "organizer_id")
	private User organizer;

	//list of tags an event consist of 
	@ManyToMany
	@JoinTable(name = "event_tags", 
	joinColumns = @JoinColumn(name = "event_id"),
	inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Tag> tags;

	//list of users who attended
	@ManyToMany
	@JoinTable(name = "event_attendance", 
	joinColumns = @JoinColumn(name = "event_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> attendance;
	
	//event default = approved FALSE
	public Event()
	{
		approved = false;
		tags = new ArrayList<Tag>();
		attendance = new ArrayList<User>();
	}

//	public boolean isAdministrator() 
//	{	
//		return approved = true;
//	}
	
//	public boolean isOrganizer()
//	{
//		return approved = true;
//	}
	
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

	public String getDecription() 
	{
		return description;
	}

	public void setDecription(String description) 
	{
		this.description = description;
	}

	public String getLocation() 
	{
		return location;
	}

	public void setLocation(String location) 
	{
		this.location = location;
	}

	public Date getStartTime() 
	{
		return startTime;
	}

	public void setStartTime(Date startTime) 
	{
		this.startTime = startTime;
	}

	public Date getEndTime() 
	{
		return endTime;
	}

	public void setEndTime(Date endTime ) 
	{
		this.endTime = endTime;
	}

	public boolean isApproved() 
	{
		return approved;
	}

	public void setApproved(boolean approved) 
	{
		this.approved = approved;
	}

	public User getAdministrators()
	{
		return administrator;
	}

	public void setAdministrators( User administrator )
	{
		this.administrator = administrator;
	}

	public User getOrganizer()
	{
		return organizer;
	}

	public void setOrganizers( User organizer )
	{
		this.organizer = organizer;
	}

	public List<Tag> getTags()
	{
		return tags;
	}

	public void setTags( List<Tag> tags )
	{
		this.tags = tags;
	}

	public List<User> getAttendance()
	{
		return attendance;
	}

	public void setAttendance( List<User> attendance )
	{
		this.attendance = attendance;
	}


}