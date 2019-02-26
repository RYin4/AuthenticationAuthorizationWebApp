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
@Table(name = "rewards")
public class Reward implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	//person who posts the reward
	@Column(name = "reward_poster", nullable = false)
	private String posterName;

	@Column(name = "reward_organization", nullable = false)
	private String organizationName;

	@Column(name = "start_time")
	private Date startTime;

	@Column( name = "end_time")
	private Date endTime;

	@Column(nullable = false)
	private boolean approved;
	
	//One administrator to approve event
	@ManyToOne
	@JoinColumn( name = "administrator_id")
	private User administrator;

	//one reward provider that can post reward
	@ManyToOne
	@JoinColumn( name = "provider_id")
	private User provider;
	
	//events that can be added to a list of qualifiedEvents
	@ManyToMany
	@JoinTable(name = "qualified_events", 
	joinColumns = @JoinColumn(name = "reward_id"),
	inverseJoinColumns = @JoinColumn(name = "event_id"))
	private List<Event> qualifiedEvents;
	
	//user must attend n events with a specific tag
	@ManyToMany
	@JoinTable(name = "reward_criteria", 
	joinColumns = @JoinColumn(name = "reward_id"),
	inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Tag> rewardCriteria;

	public Reward()
	{
		approved = false;
		qualifiedEvents = new ArrayList<Event>();
		rewardCriteria = new ArrayList<Tag>();
	}
	
//	public boolean isAdministrator() 
//	{	
//		return approved = true;
//	}
	
//	public boolean isProvider()
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

	public String getPosterName() 
	{
		return posterName;
	}

	public void setPosterName(String posterName) 
	{
		this.posterName = posterName;
	}

	public String getOrganizationName() 
	{
		return organizationName;
	}

	public void setOrganizationName(String organizationName) 
	{
		this.organizationName = organizationName;
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

	public User getProvider()
	{
		return provider;
	}

	public void setProviders( User provider )
	{
		this.provider = provider;
	}

	public List<Event> getQualifiedEvents() 
	{
		return qualifiedEvents;
	}

	public void setQualifiedEvents( List<Event> qualifiedEvents) 
	{
		this.qualifiedEvents = qualifiedEvents;
	}

	public List<Tag> getRewardCriteria() 
	{
		return rewardCriteria;
	}

	public void setRewardCriteria( List<Tag> rewardCriteria) 
	{
		this.rewardCriteria = rewardCriteria;
	}


	


}