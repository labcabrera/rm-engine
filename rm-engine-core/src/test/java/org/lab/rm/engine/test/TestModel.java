package org.lab.rm.engine.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab.rm.engine.core.characters.PlayerCreationService;
import org.lab.rm.engine.core.config.RmEngineCoreConfig;
import org.lab.rm.engine.core.model.character.CharacterContext;
import org.lab.rm.engine.core.model.character.Gender;
import org.lab.rm.engine.core.model.character.Inventory;
import org.lab.rm.engine.core.model.character.PlayerCharacter;
import org.lab.rm.engine.core.model.character.Profession;
import org.lab.rm.engine.core.model.character.ProfessionRealm;
import org.lab.rm.engine.core.model.character.Race;
import org.lab.rm.engine.core.model.character.repository.CharacterContextRepository;
import org.lab.rm.engine.core.model.character.repository.PlayerCharacterRepository;
import org.lab.rm.engine.core.model.items.Item;
import org.lab.rm.engine.core.model.items.Weapon;
import org.lab.rm.engine.core.model.items.WeaponType;
import org.lab.rm.engine.core.model.items.repository.WeaponTypeRepository;
import org.lab.rm.engine.core.model.player.Campaign;
import org.lab.rm.engine.core.model.player.Player;
import org.lab.rm.engine.core.model.player.repository.CampaignRepository;
import org.lab.rm.engine.core.model.player.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RmEngineCoreConfig.class)
public class TestModel {

	@Autowired
	private PlayerCreationService creationService;
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private PlayerCharacterRepository playerCharacterRepository;
	@Autowired
	private WeaponTypeRepository weaponTypeRepository;
	@Autowired
	private CharacterContextRepository characterContextRepository;
	@Autowired
	private CampaignRepository campaignRepository;

	@Test
	public void test() {

		Player player = playerRepository.findByName("lab.cabrera");

		PlayerCharacter pj01 = creationService.prepare(player, "Kiove", Race.COMMON_MAN, Profession.ROGUE,
				ProfessionRealm.CHANNELING);
		pj01.setAge(35);
		pj01.setCurrentLevel(100);
		pj01.setMaxLevel(100);
		pj01.setXp(42384723L);
		pj01.setMaxHitPoints(245);
		pj01.setGender(Gender.FEMALE);
		playerCharacterRepository.save(pj01);

		List<PlayerCharacter> otherChars = new ArrayList<>();
		otherChars
				.add(creationService.prepare(player, "Shiova", Race.HALF_ELF, Profession.LOCK, ProfessionRealm.ESSENCE));
		otherChars.add(creationService.prepare(player, "Set", Race.GREY_ELF, Profession.MAGE, ProfessionRealm.ESSENCE));
		otherChars.add(creationService.prepare(player, "Zalen", Race.COMMON_MAN, Profession.CLERIC,
				ProfessionRealm.CHANNELING));
		otherChars.add(
				creationService.prepare(player, "Pieterman", Race.GREY_ELF, Profession.MAGE, ProfessionRealm.ESSENCE));
		otherChars.add(creationService.prepare(player, "Caticat", Race.GREY_ELF, Profession.GUARDABOSQUES,
				ProfessionRealm.CHANNELING));
		otherChars.add(
				creationService.prepare(player, "Azania", Race.GREY_ELF, Profession.ROGUE, ProfessionRealm.MENTALISM));

		WeaponType bastardSword = weaponTypeRepository.findByName("Bastard Sword");

		CharacterContext context01 = new CharacterContext();
		context01.setPj(pj01);
		context01.setInventory(new Inventory());
		context01.getInventory().setFirstHandEquipedWeapon(new Weapon(bastardSword));
		context01.getInventory().setBags(new ArrayList<Item>());
		context01.getInventory().getBags().add(new Item("Silver coin", 23));
		context01.getInventory().getBags().add(new Item("Copper coin", 33));
		context01.getInventory().getBags().add(new Item("Gold coin", 33));
		context01.setCurrentHitPoints(pj01.getMaxHitPoints());
		characterContextRepository.save(context01);

		List<CharacterContext> otherContext = new ArrayList<>();
		for (PlayerCharacter i : otherChars) {
			CharacterContext ctx = new CharacterContext(i);
			characterContextRepository.save(ctx);
			otherContext.add(ctx);
		}

		Campaign campaign = new Campaign();
		campaign.setName("Dummy campaign");
		campaign.setOwner(player);
		campaign.setActors(new ArrayList<CharacterContext>());
		campaign.getActors().addAll(otherContext);
		campaignRepository.save(campaign);
	}

}
