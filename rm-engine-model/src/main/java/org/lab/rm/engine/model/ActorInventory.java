package org.lab.rm.engine.model;

import java.util.List;

public class ActorInventory {

	private Item firstHandEquipedWeapon;

	private Item secondHandEquipedWeapon;

	private ArmorType equipedArmor;

	private List<Item> bagItems;

	private List<Coin> coints;

	public Item getFirstHandEquipedWeapon() {
		return firstHandEquipedWeapon;
	}

	public void setFirstHandEquipedWeapon(Item firstHandEquipedWeapon) {
		this.firstHandEquipedWeapon = firstHandEquipedWeapon;
	}

	public Item getSecondHandEquipedWeapon() {
		return secondHandEquipedWeapon;
	}

	public void setSecondHandEquipedWeapon(Item secondHandEquipedWeapon) {
		this.secondHandEquipedWeapon = secondHandEquipedWeapon;
	}

	public ArmorType getEquipedArmor() {
		return equipedArmor;
	}

	public void setEquipedArmor(ArmorType equipedArmor) {
		this.equipedArmor = equipedArmor;
	}

	public List<Item> getBagItems() {
		return bagItems;
	}

	public void setBagItems(List<Item> bagItems) {
		this.bagItems = bagItems;
	}

	public List<Coin> getCoints() {
		return coints;
	}

	public void setCoints(List<Coin> coints) {
		this.coints = coints;
	}

}
