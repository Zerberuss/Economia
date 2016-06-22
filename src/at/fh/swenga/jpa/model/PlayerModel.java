package at.fh.swenga.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.data.annotation.Persistent;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "player")
@Transactional
public class PlayerModel implements java.io.Serializable {

	@Id
	@Column(name = "username")
	private String username;

	@Column(nullable = false, length = 70)
	String email;

	@Column(nullable = false, length = 30)
	String password;

	@Column(nullable = false, length = 10)
	String role;
	

    @Column(nullable = false)
    private int wood = 70;
    
    @Column(nullable = false)
    private int stone = 40;
    
    @Column(nullable = false)
    private int food = 20;
    
    @Column(nullable = false)
    private int gold = 0;
	


	/*@OneToMany(mappedBy = "player", fetch = FetchType.LAZY)
	private Set<BuildingModel> buildings;
	*/
    
	@OneToMany(mappedBy="player",targetEntity=BuildingModel.class, fetch=FetchType.LAZY)
	private Set<BuildingModel> buildings;
	
	@OneToMany(mappedBy="player",targetEntity=RecruitModel.class, fetch=FetchType.LAZY)
	private Set<RecruitModel> recruits;

	@OneToMany(mappedBy = "player",targetEntity=ActionModel.class, fetch = FetchType.LAZY)
	private Set<ActionModel> actions;
	
	@OneToMany(mappedBy = "player",targetEntity=ActionModel.class, fetch = FetchType.LAZY)
	private Set<HistoryModel> historys;


	@Version
	long version;

	public PlayerModel() {
	}

	public PlayerModel(String username, String email, String password, String role, int wood, int stone, int food,
			int gold) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.wood = wood;
		this.stone = stone;
		this.food = food;
		this.gold = gold;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getWood() {
		return wood;
	}

	public void setWood(int wood) {
		this.wood = wood;
	}

	public int getStone() {
		return stone;
	}

	public void setStone(int stone) {
		this.stone = stone;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	
	public Set<ActionModel> getActions() {
		return actions;
	}
																	//fehlt die remove funktion!!!!
	public void setActions(Set<ActionModel> actions) {
		this.actions = actions;
	}

	public void addAction(ActionModel action) {
		if (actions == null) {
			actions = new HashSet<ActionModel>();
		}
		actions.add(action);
	}


	public  Set<BuildingModel> getBuildings() {
		return buildings;
	}

	public void setBuildings(Set<BuildingModel> buildings) {
		this.buildings = buildings;
	}

	public void addBuilding(BuildingModel building) {
		if (buildings == null) {
			buildings = new HashSet<BuildingModel>();
		}
		buildings.add(building);
	}
	
	public  Set<RecruitModel> getRecruits() {
		return recruits;
	}
	
	public void setRecruits(Set<RecruitModel> recruits) {
		this.recruits = recruits;
	}

	public void addRecruit(RecruitModel recruit) {
		if (recruits == null) {
			recruits = new HashSet<RecruitModel>();
		}
		recruits.add(recruit);
	}
	
	public  Set<HistoryModel> getHistorys() {
		return historys;
	}
	
	public void setHistorys(Set<HistoryModel> historys) {
		this.historys = historys;
	}

	public void addHistory(HistoryModel history) {
		if (historys == null) {
			historys = new HashSet<HistoryModel>();
		}
		historys.add(history);
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {


	return "User [name=" + username + ", email=" + email + ", passwd=" + password + ", role="+role + ", wood " + " ]"; //resources.wood + " ]";


	}

}