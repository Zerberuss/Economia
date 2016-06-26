package at.fh.swenga.jpa.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "player")


public class PlayerModel implements java.io.Serializable {

	@Id
	@Column(name = "username")
	private String username;

	@Column(nullable = false, length = 70)
	String email;

	@Column(nullable = false, length = 60)
	String password;

	@Column(nullable = false)
	private int wood = 70;

	@Column(nullable = false)
	private int stone = 40;

	@Column(nullable = false)
	private int food = 20;

	@Column(nullable = false)
	private int gold = 10;

	@Column(nullable = false)
	private int attackPowerUnits = 0;

	@Column(nullable = false)
	private int deffPowerUnits = 0;

	@Column(nullable = false)
	private int accuracyUnits = 0;



	@OneToMany(mappedBy = "player", targetEntity = BuildingModel.class, fetch = FetchType.LAZY)
	private Set<BuildingModel> buildings = new HashSet<BuildingModel>(0);

	@OneToMany(mappedBy = "player", targetEntity = RecruitModel.class, fetch = FetchType.LAZY)
	private List<RecruitModel> recruit;

	@OneToMany(mappedBy = "player", targetEntity = TradeModel.class, fetch = FetchType.LAZY)
	private Set<TradeModel> tradeOffers = new HashSet<TradeModel>(0);

	@OneToMany(mappedBy = "player", targetEntity = PlayerRole.class, fetch = FetchType.LAZY)
	private Set<PlayerRole> playerRole = new HashSet<PlayerRole>(0);

	@OneToMany(mappedBy = "player",targetEntity=HistoryModel.class, fetch = FetchType.LAZY)
	private Set<HistoryModel> historys = new HashSet<HistoryModel>(0);
	
	@Version
	long version;

	public PlayerModel() {
	}

	public PlayerModel(String username, String email, String password, int wood, int stone, int food, int gold, int atk,
			int deff, int acc) {
		super();
		this.username = username;
		this.email = email;
		setBCryptedPassword(password);
		this.wood = wood;
		this.stone = stone;
		this.food = food;
		this.gold = gold;
		this.accuracyUnits = acc;
		this.attackPowerUnits = atk;
		this.deffPowerUnits = deff;
	}
	public void setBCryptedPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	//commit comment
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
		setBCryptedPassword(new BCryptPasswordEncoder().encode(password));

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

	public Set<TradeModel> getTradeOffer() {
		return tradeOffers;
	}

	// fehlt die remove funktion!!!!
	public void setTradeOffer(Set<TradeModel> offers) {
		this.tradeOffers = offers;
	}

	public void addTradeOffer(TradeModel offer) {
		if (tradeOffers == null) {
			tradeOffers = new HashSet<TradeModel>();
		}
		tradeOffers.add(offer);
	}

	public Set<BuildingModel> getBuildings() {
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

	public List<RecruitModel> getRecruits() {
		return recruit;
	}

	public void setRecruits(List<RecruitModel> recruits) {
		this.recruit = recruits;
	}

	public int getAttackPowerUnits() {
		return attackPowerUnits;
	}

	public void setAttackPowerUnits(int attackPowerUnits) {
		this.attackPowerUnits = attackPowerUnits;
	}

	public int getDeffPowerUnits() {
		return deffPowerUnits;
	}

	public void setDeffPowerUnits(int deffPowerUnits) {
		this.deffPowerUnits = deffPowerUnits;
	}

	public int getAccuracyUnits() {
		return accuracyUnits;
	}

	public void setAccuracyUnits(int accuracyUnits) {
		this.accuracyUnits = accuracyUnits;
	}

	public Set<PlayerRole> getPlayerRole() {
		return playerRole;
	}

	public void setUserRole(Set<PlayerRole> playerRole) {
		this.playerRole = playerRole;
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
	

/*
	@Override getPlayerlist2Fight
	public String toString() {

		return "User [name=" + username + ", email=" + email + ", passwd=" + password;

	} */

}