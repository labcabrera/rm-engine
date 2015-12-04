package org.lab.rm.engine.test;

import java.util.ArrayList;

import javax.inject.Provider;

import org.junit.Test;
import org.lab.rm.engine.core.guice.CoreModule;
import org.lab.rm.engine.core.pj.PjCreationService;
import org.lab.rm.engine.model.Campaign;
import org.lab.rm.engine.model.items.Item;
import org.lab.rm.engine.model.items.Weapon;
import org.lab.rm.engine.model.items.WeaponType;
import org.lab.rm.engine.model.pj.Gender;
import org.lab.rm.engine.model.pj.Inventory;
import org.lab.rm.engine.model.pj.Pj;
import org.lab.rm.engine.model.pj.PjContext;
import org.lab.rm.engine.model.pj.Profession;
import org.lab.rm.engine.model.pj.ProfessionRealm;
import org.lab.rm.engine.model.pj.Race;
import org.lab.rm.engine.model.user.User;
import org.mongodb.morphia.Datastore;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestModel {

	@Test
	public void test() {
		Injector injector = Guice.createInjector(new CoreModule());
		PjCreationService creationService = injector.getInstance(PjCreationService.class);
		Provider<Datastore> datastoreProvider = injector.getProvider(Datastore.class);
		Datastore datastore = datastoreProvider.get();

		User owner = datastore.find(User.class, "name", "lab.cabrera").iterator().next();

		Pj pj01 = creationService.prepare(owner, "Kiove", Race.HALF_ELF, Profession.ROGUE, ProfessionRealm.CHANNELING);
		pj01.setAge(35);
		pj01.setCurrentLevel(100);
		pj01.setMaxLevel(100);
		pj01.setXp(42384723L);
		pj01.setMaxHitPoints(245);
		pj01.setGender(Gender.FEMALE);
		datastore.save(pj01);

		Pj pj02 = creationService.prepare(owner, "Shiova", Race.HALF_ELF, Profession.LOCK, ProfessionRealm.ESSENCE);
		datastore.save(pj02);

		WeaponType bastardSword = datastore.find(WeaponType.class, "name", "Bastard Sword").iterator().next();

		PjContext context01 = new PjContext();
		context01.setActor(pj01);
		context01.setInventory(new Inventory());
		context01.getInventory().setFirstHandEquipedWeapon(new Weapon(bastardSword));
		context01.getInventory().setBags(new ArrayList<Item>());
		context01.getInventory().getBags().add(new Item("Silver coin", 23));
		context01.getInventory().getBags().add(new Item("Copper coin", 33));
		context01.getInventory().getBags().add(new Item("Gold coin", 33));
		context01.setCurrentHitPoints(pj01.getMaxHitPoints());
		datastore.save(context01);

		PjContext context02 = new PjContext();
		context01.setActor(pj02);
		datastore.save(context02);

		Campaign campaign = new Campaign();
		campaign.setName("Dummy campaign");
		campaign.setOwner(owner);
		campaign.setActors(new ArrayList<PjContext>());
		campaign.getActors().add(context01);
		campaign.getActors().add(context02);
		datastore.save(campaign);
	}

}
