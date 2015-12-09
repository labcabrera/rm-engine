package org.lab.rm.engine.test;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Provider;

import org.junit.Test;
import org.lab.rm.engine.core.characters.PlayerCreationService;
import org.lab.rm.engine.core.guice.CoreModule;
import org.lab.rm.engine.model.Campaign;
import org.lab.rm.engine.model.character.CharacterContext;
import org.lab.rm.engine.model.character.Gender;
import org.lab.rm.engine.model.character.Inventory;
import org.lab.rm.engine.model.character.PlayerCharacter;
import org.lab.rm.engine.model.character.Profession;
import org.lab.rm.engine.model.character.ProfessionRealm;
import org.lab.rm.engine.model.character.Race;
import org.lab.rm.engine.model.items.Item;
import org.lab.rm.engine.model.items.Weapon;
import org.lab.rm.engine.model.items.WeaponType;
import org.lab.rm.engine.model.user.User;
import org.mongodb.morphia.Datastore;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestModel {

	@Test
	public void test() {
		Injector injector = Guice.createInjector(new CoreModule());
		PlayerCreationService creationService = injector.getInstance(PlayerCreationService.class);
		Provider<Datastore> datastoreProvider = injector.getProvider(Datastore.class);
		Datastore datastore = datastoreProvider.get();

		User owner = datastore.find(User.class, "name", "lab.cabrera").iterator().next();

		PlayerCharacter pj01 = creationService.prepare(owner, "Kiove", Race.HALF_ELF, Profession.ROGUE, ProfessionRealm.CHANNELING);
		pj01.setAge(35);
		pj01.setCurrentLevel(100);
		pj01.setMaxLevel(100);
		pj01.setXp(42384723L);
		pj01.setMaxHitPoints(245);
		pj01.setGender(Gender.FEMALE);
		datastore.save(pj01);

		List<PlayerCharacter> otherChars = new ArrayList<>();
		otherChars.add(creationService.prepare(owner, "Shiova", Race.HALF_ELF, Profession.LOCK, ProfessionRealm.ESSENCE));
		otherChars.add(creationService.prepare(owner, "Set", Race.GREY_ELF, Profession.MAGE, ProfessionRealm.ESSENCE));
		otherChars.add(creationService.prepare(owner, "Zalen", Race.COMMON_MAN, Profession.CLERIC, ProfessionRealm.CHANNELING));
		otherChars.add(creationService.prepare(owner, "Pieterman", Race.GREY_ELF, Profession.MAGE, ProfessionRealm.ESSENCE));
		otherChars.add(creationService.prepare(owner, "Caticat", Race.GREY_ELF, Profession.GUARDABOSQUES, ProfessionRealm.CHANNELING));
		otherChars.add(creationService.prepare(owner, "Azania", Race.GREY_ELF, Profession.ROGUE, ProfessionRealm.MENTALISM));

		WeaponType bastardSword = datastore.find(WeaponType.class, "name", "Bastard Sword").iterator().next();

		CharacterContext context01 = new CharacterContext();
		context01.setPj(pj01);
		context01.setInventory(new Inventory());
		context01.getInventory().setFirstHandEquipedWeapon(new Weapon(bastardSword));
		context01.getInventory().setBags(new ArrayList<Item>());
		context01.getInventory().getBags().add(new Item("Silver coin", 23));
		context01.getInventory().getBags().add(new Item("Copper coin", 33));
		context01.getInventory().getBags().add(new Item("Gold coin", 33));
		context01.setCurrentHitPoints(pj01.getMaxHitPoints());
		datastore.save(context01);

		List<CharacterContext> otherContext = new ArrayList<>();
		for (PlayerCharacter i : otherChars) {
			CharacterContext ctx = new CharacterContext(i);
			datastore.save(ctx);
			otherContext.add(ctx);
		}

		Campaign campaign = new Campaign();
		campaign.setName("Dummy campaign");
		campaign.setOwner(owner);
		campaign.setActors(new ArrayList<CharacterContext>());
		campaign.getActors().addAll(otherContext);
		datastore.save(campaign);
	}

}
