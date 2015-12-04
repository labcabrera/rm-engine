package org.lab.rm.engine.test;

import java.util.ArrayList;

import javax.inject.Provider;

import org.junit.Test;
import org.lab.rm.engine.core.guice.CoreModule;
import org.lab.rm.engine.model.Campaign;
import org.lab.rm.engine.model.items.Item;
import org.lab.rm.engine.model.items.Weapon;
import org.lab.rm.engine.model.items.WeaponType;
import org.lab.rm.engine.model.pj.Pj;
import org.lab.rm.engine.model.pj.PjAttribute;
import org.lab.rm.engine.model.pj.Profession;
import org.lab.rm.engine.model.pj.PjContext;
import org.lab.rm.engine.model.pj.AttributeType;
import org.lab.rm.engine.model.pj.Gender;
import org.lab.rm.engine.model.pj.Inventory;
import org.lab.rm.engine.model.pj.Race;
import org.lab.rm.engine.model.user.User;
import org.mongodb.morphia.Datastore;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestModel {

	@Test
	public void test() {
		Injector injector = Guice.createInjector(new CoreModule());
		Provider<Datastore> datastoreProvider = injector.getProvider(Datastore.class);

		Datastore datastore = datastoreProvider.get();

		User owner = datastore.find(User.class, "name", "lab.cabrera").iterator().next();

		Pj actor01 = new Pj();
		actor01.setName("Kiove");
		actor01.setOwner(owner);
		actor01.setProfession(Profession.ROGUE);
		actor01.setRace(Race.GREY_ELF);
		actor01.setAge(35);
		actor01.setCurrentLevel(100);
		actor01.setMaxLevel(100);
		actor01.setXp(42384723L);
		actor01.setMaxHitPoints(245);
		actor01.setGender(Gender.FEMALE);
		actor01.setAttributes(new ArrayList<PjAttribute>());
		actor01.getAttributes().add(new PjAttribute(AttributeType.REASONING, 92));
		actor01.getAttributes().add(new PjAttribute(AttributeType.AGILITY, 89));
		actor01.getAttributes().add(new PjAttribute(AttributeType.CONSTITUTION, 25));
		actor01.getAttributes().add(new PjAttribute(AttributeType.APPEARANCE, 75));
		actor01.getAttributes().add(new PjAttribute(AttributeType.INTUITION, 55));
		actor01.getAttributes().add(new PjAttribute(AttributeType.QUICKNESS, 91));
		actor01.getAttributes().add(new PjAttribute(AttributeType.SANITY, 32));
		actor01.getAttributes().add(new PjAttribute(AttributeType.MEMORY, 87));
		datastore.save(actor01);

		Pj actor02 = new Pj();
		actor02.setName("Shiova");
		actor02.setOwner(owner);
		actor02.setRace(Race.MIXED_MAN);
		actor02.setProfession(Profession.MAGE);
		datastore.save(actor02);

		WeaponType bastardSword = datastore.find(WeaponType.class, "name", "Bastard Sword").iterator().next();

		PjContext actorContext01 = new PjContext();
		actorContext01.setActor(actor01);
		actorContext01.setInventory(new Inventory());
		actorContext01.getInventory().setFirstHandEquipedWeapon(new Weapon(bastardSword));
		actorContext01.getInventory().setBags(new ArrayList<Item>());
		actorContext01.getInventory().getBags().add(new Item("Silver coin", 23));
		actorContext01.getInventory().getBags().add(new Item("Copper coin", 23));
		actorContext01.setCurrentHitPoints(actor01.getMaxHitPoints());
		datastore.save(actorContext01);

		PjContext actorContext02 = new PjContext();
		actorContext01.setActor(actor02);
		datastore.save(actorContext02);

		Campaign campaign = new Campaign();
		campaign.setName("Dummy campaign");
		campaign.setOwner(owner);
		campaign.setActors(new ArrayList<PjContext>());
		campaign.getActors().add(actorContext01);
		campaign.getActors().add(actorContext02);
		datastore.save(campaign);
	}

}
