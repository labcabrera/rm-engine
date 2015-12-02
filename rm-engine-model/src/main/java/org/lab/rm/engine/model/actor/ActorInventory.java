package org.lab.rm.engine.model.actor;

import java.util.List;

import org.lab.rm.engine.model.items.ArmorType;
import org.lab.rm.engine.model.items.Coin;
import org.lab.rm.engine.model.items.Item;

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
