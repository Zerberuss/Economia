package at.fh.swenga.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Building")

//NamedQueries here



public class BuildingModel implements java.io.Serializable{
	
	@Id
	@Column(name = "name")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int name;
	
	
	@Column(nullable = false, length = 30)
    int neededWood = 0;
	
	@Column(nullable = false, length = 30)
    int neededStone = 0;
	
	@Column(nullable = false, length = 30)
    int neededFood = 0;
	
	@Column(nullable = false, length = 30)
    int neededGold = 0;
	
	@Column(nullable = false, length = 30)
    int neededMilitaryUnits = 0;
	
	@ManyToOne (cascade = CascadeType.PERSIST)
	PlayerModel player;

	public BuildingModel(int name, int neededWood, int neededStone, int neededFood, int neededGold,
			int neededMilitaryUnits) {
		super();
		this.name = name;
		this.neededWood = neededWood;
		this.neededStone = neededStone;
		this.neededFood = neededFood;
		this.neededGold = neededGold;
		this.neededMilitaryUnits = neededMilitaryUnits;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public int getNeededWood() {
		return neededWood;
	}

	public void setNeededWood(int neededWood) {
		this.neededWood = neededWood;
	}

	public int getNeededStone() {
		return neededStone;
	}

	public void setNeededStone(int neededStone) {
		this.neededStone = neededStone;
	}

	public int getNeededFood() {
		return neededFood;
	}

	public void setNeededFood(int neededFood) {
		this.neededFood = neededFood;
	}

	public int getNeededGold() {
		return neededGold;
	}

	public void setNeededGold(int neededGold) {
		this.neededGold = neededGold;
	}

	public int getNeededMilitaryUnits() {
		return neededMilitaryUnits;
	}

	public void setNeededMilitaryUnits(int neededMilitaryUnits) {
		this.neededMilitaryUnits = neededMilitaryUnits;
	}
	
	
	public PlayerModel getPlayer() {
		return player;
	}

	public void setPlayer(PlayerModel player) {
		this.player=player;
	}

	
}
