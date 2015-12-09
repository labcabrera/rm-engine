package org.lab.rm.engine.model.character;

import java.util.List;

import org.lab.rm.engine.model.items.Armor;
import org.lab.rm.engine.model.items.Item;
import org.lab.rm.engine.model.items.Weapon;

public class Inventory {

	private Weapon firstHandEquipedWeapon;

	private Weapon secondHandEquipedWeapon;

	private Armor equipedArmor;

	private List<Item> bags;

	public Weapon getFirstHandEquipedWeapon() {
		return firstHandEquipedWeapon;
	}

	public void setFirstHandEquipedWeapon(Weapon firstHandEquipedWeapon) {
		this.firstHandEquipedWeapon = firstHandEquipedWeapon;
	}

	public Weapon getSecondHandEquipedWeapon() {
		return secondHandEquipedWeapon;
	}

	public void setSecondHandEquipedWeapon(Weapon secondHandEquipedWeapon) {
		this.secondHandEquipedWeapon = secondHandEquipedWeapon;
	}

	public Armor getEquipedArmor() {
		return equipedArmor;
	}

	public void setEquipedArmor(Armor equipedArmor) {
		this.equipedArmor = equipedArmor;
	}

	public List<Item> getBags() {
		return bags;
	}

	public void setBags(List<Item> bags) {
		this.bags = bags;
	}

}
