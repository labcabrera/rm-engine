package org.lab.rm.engine.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab.rm.engine.core.characters.PlayerCreationService;
import org.lab.rm.engine.core.config.RmEngineCoreConfig;
import org.lab.rm.engine.model.character.CharacterContext;
import org.lab.rm.engine.model.character.Gender;
import org.lab.rm.engine.model.character.Inventory;
import org.lab.rm.engine.model.character.PlayerCharacter;
import org.lab.rm.engine.model.character.Profession;
import org.lab.rm.engine.model.character.Race;
import org.lab.rm.engine.model.character.ext.CharacterCommonData;
import org.lab.rm.engine.model.character.repository.CharacterContextRepository;
import org.lab.rm.engine.model.character.repository.PlayerCharacterRepository;
import org.lab.rm.engine.model.character.repository.ProfessionRepository;
import org.lab.rm.engine.model.character.repository.RaceStatsRepository;
import org.lab.rm.engine.model.items.Item;
import org.lab.rm.engine.model.items.Weapon;
import org.lab.rm.engine.model.items.WeaponType;
import org.lab.rm.engine.model.items.repository.WeaponTypeRepository;
import org.lab.rm.engine.model.player.Campaign;
import org.lab.rm.engine.model.player.Player;
import org.lab.rm.engine.model.player.repository.CampaignRepository;
import org.lab.rm.engine.model.player.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@Ignore("mongodb required")
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
	@Autowired
	private RaceStatsRepository raceStatsRepository;
	@Autowired
	private ProfessionRepository professionRepository;

	@Test
	public void test() {
		Player player = playerRepository.findByName("lab.cabrera");
		Race commonMan = raceStatsRepository.findByName("COMMON_MAN");
		Profession rogue = professionRepository.findByName("ROGUE");
		Profession lock = professionRepository.findByName("LOCK");
		Profession mage = professionRepository.findByName("MAGE");
		Profession cleric = professionRepository.findByName("CLERIC");

		PlayerCharacter kiove = creationService.prepare(player, "Kiove", commonMan, rogue);

		CharacterCommonData kioveCommonData = new CharacterCommonData();
		kioveCommonData.setAge(36);
		kioveCommonData.setGender(Gender.FEMALE);
		kiove.addModule(kioveCommonData);

		playerCharacterRepository.save(kiove);

		List<PlayerCharacter> otherChars = new ArrayList<>();
		otherChars.add(creationService.prepare(player, "Shiova", commonMan, lock));
		otherChars.add(creationService.prepare(player, "Set", commonMan, mage));
		otherChars.add(creationService.prepare(player, "Zalen", commonMan, cleric));
		otherChars.add(creationService.prepare(player, "Pieterman", commonMan, mage));
		otherChars.add(creationService.prepare(player, "Azania", commonMan, rogue));

		playerCharacterRepository.save(otherChars);

		WeaponType bastardSword = weaponTypeRepository.findByName("Bastard Sword");
		if (bastardSword == null) {
			bastardSword = new WeaponType();
			bastardSword.setName("Bastard Sword");
			bastardSword = weaponTypeRepository.insert(bastardSword);
		}

		CharacterContext context01 = new CharacterContext();
		context01.setPj(kiove);
		context01.setInventory(new Inventory());
		context01.getInventory().setFirstHandEquipedWeapon(new Weapon(bastardSword));
		context01.getInventory().setBags(new ArrayList<Item>());
		context01.getInventory().getBags().add(new Item("Silver coin", 23));
		context01.getInventory().getBags().add(new Item("Copper coin", 33));
		context01.getInventory().getBags().add(new Item("Gold coin", 33));
		context01.setCurrentHitPoints(kiove.getMaxHitPoints());
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
