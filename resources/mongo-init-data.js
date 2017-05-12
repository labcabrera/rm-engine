db.player.insert({"name": "lab.cabrera"});

// Races
db.race.insert({"name": "COMMON_MAN", "attributes": {"ST": 5, "SD": -5}});

db.race.insert({"name": "HIGH_MAN", "attributes": {
  "ST": 10, "QU": -10, "PR": 10, "CO": 10, "AG": -5}});

db.race.insert({"name": "HIGH_ELF", "attributes": {
  "QU": 10, "PR": 10, "EM": 5, "SD": -20, "AG": 5}});

db.race.insert({"name": "WOOD_ELF", "attributes": {
  "QU": 5, "PR": 5, "EM": 5, "SD": -20, "AG": 10}});

db.race.insert({"name": "GREY_ELF", "attributes": {
  "QU": 15, "PR": 15, "EM": 5, "SD": -20, "AG": 5}});

db.race.insert({"name": "HALF_ELF", "attributes": {
  "QU": 10, "PR": 10, "EM": 5, "SD": -20, "AG": 5}});

db.race.insert({"name": "DWARF", "attributes": {
  "ST": 5, "QU": 15}});

db.race.insert({"name": "HOBBIT", "attributes": {
  "ST": -20}});

db.race.insert({"name": "ORK", "attributes": {
  "ST": 5, "PR": -5, "IN": -10, "EM": -5, "CO": 5, "SD": -10, "ME": -5, "RE": -5}});

db.race.insert({"name": "URUK", "attributes": {
  "ST": 10, "PR": -5, "IN": -5, "EM": -5, "CO": 10, "SD": -5, "ME": -5, "RE": -5}});

db.race.insert({"name": "TROLL", "attributes": {
  "ST": 15, "QU": -10, "PR": -10, "IN": -10, "EM": -10, "CO": 15, "SD": -10, "AG": -10, "ME": -10, "RE": -10}});

// Realms
db.realm.insert({"_id": "ARMS", "name": "ARMS"});
db.realm.insert({"_id": "ESSENCE", "name": "ESSENCE"});
db.realm.insert({"_id": "CHANNELING", "name": "CHANNELING"});
db.realm.insert({"_id": "MENTALISM:", "name": "MENTALISM"});
db.realm.insert({"_id": "ESSENCE_CHANNELING", "name": "ESSENCE_CHANNELING"});
db.realm.insert({"_id": "ESSENCE_MENTALISM", "name": "ESSENCE_MENTALISM"});
db.realm.insert({"_id": "CHANNELING_MENTALISM", "name": "CHANNELING_MENTALISM"});
db.realm.insert({"_id": "ARMS_MAGIC", "name": "ARMS_MAGIC"});


// Professions
db.profession.insert({"_id": "FIGHTER", "name": "FIGHTER", "realms": [{"_id": "ARMS"}]});
db.profession.insert({"_id": "THIEF", "name": "THIEF", "realms": [{"_id": "ARMS"}]});
db.profession.insert({"_id": "ROGUE", "name": "ROGUE", "realms": [{"_id": "ARMS"}]});
db.profession.insert({"_id": "WARRIOR_MONK", "name": "WARRIOR_MONK", "realms": [{"_id": "ARMS"}]});
db.profession.insert({"_id": "MAGE", "name": "MAGE", "realms": [{"_id": "ESSENCE"}]});
db.profession.insert({"_id": "ILUSIONIST", "name": "ILUSIONIST", "realms": [{"_id": "ESSENCE"}]});
db.profession.insert({"_id": "ALQUIMIST", "name": "ALQUIMIST", "realms": [{"_id": "ESSENCE"}]});
db.profession.insert({"_id": "CLERIC", "name": "CLERIC", "realms": [{"_id": "CHANNELING"}]});
db.profession.insert({"_id": "DRUID", "name": "DRUID", "realms": [{"_id": "CHANNELING"}]});
db.profession.insert({"_id": "HEALER", "name": "HEALER", "realms": [{"_id": "CHANNELING"}]});
db.profession.insert({"_id": "MENTALIST", "name": "MENTALIST", "realms": [{"_id": "MENTALISM"}]});
db.profession.insert({"_id": "LAY_HEALER", "name": "LAY_HEALER", "realms": [{"_id": "MENTALISM"}]});
db.profession.insert({"_id": "SEER", "name": "SEER", "realms": [{"_id": "ARMS"}]});
db.profession.insert({"_id": "LOCK", "name": "LOCK", "realms": [{"_id": "CHANNELING"}]});
db.profession.insert({"_id": "MISTIC", "name": "MISTIC", "realms": [{"_id": "ESSENCE",},{"_id": "ESSENCE_MENTALISM"}]});
db.profession.insert({"_id": "ASTROLOGO", "name": "ASTROLOGO", "realms": [{"_id": "CHANNELING"}, {"_id": "MENTALISM"}]});
db.profession.insert({"_id": "MONK", "name": "MONK", "realms": [{"_id":"ARMS_MAGIC"}]}),
db.profession.insert({"_id": "GUARDABOSQUES", "name": "GUARDABOSQUES", "realms": [{"_id":"ARMS_MAGIC"}]});
db.profession.insert({"_id": "BARD", "name": "BARD", "realms": [{"_id": "ARMS_MAGIC"}]});
db.profession.insert({"_id": "PALADIN","name":"PALADIN"});
db.profession.insert({"_id": "ARMSMASTER","name":"ARMSMASTER"});
db.profession.insert({"_id": "ARCANIST","name":"ARCANIST"});

// Weapon types
db.weaponType.insert({"name": "Bastard Sword"});

db.singleEntryTable.insert({
	"name":"character.movement.bonus",
	"desc":"Bonificacion por rapidez",
	"min": "1",
	"max": "102",
	"values":{
		"1": "-25",
		"2": "-20",
		"3:4": "-15",
		"5:9": "-10",
		"10:24": "-5",
		"25:74": "0",
		"75:89": "5",
		"90:94": "10",
		"95:97": "15",
		"98:99": "20",
		"100": "25",
		"101": "30",
		"102": "35"
	}
});
db.singleEntryTable.insert({
	"name":"character.movement.base",
	"desc":"Bonificacion de movimiento (m)",
	"min": "1",
	"max": "102",
	"values":{
		"1": "8",
		"2": "9",
		"3:4": "11",
		"5:9": "12",
		"10:24": "14",
		"25:74": "15",
		"75:89": "17",
		"90:94": "18",
		"95:97": "20",
		"98:99": "21",
		"100": "23",
		"101": "24",
		"102": "26"
	}
});

db.tableMovementManeuverEntry.insert({"min": null, "max": -201, "difficulty": "RUTINA", "desc": "Caida. 3 asaltos inconsciente", "hp": -2});
db.tableMovementManeuverEntry.insert({"min": -200, "max": -151, "difficulty": "RUTINA", "desc": "Sin actuar"});
db.tableMovementManeuverEntry.insert({"min": -150, "max": -101, "difficulty": "RUTINA", "percent": "10"});
db.tableMovementManeuverEntry.insert({"min": -100, "max": -51, "difficulty": "RUTINA", "percent": "30"});
db.tableMovementManeuverEntry.insert({"min": -50, "max": -26, "difficulty": "RUTINA", "percent": "50"});
db.tableMovementManeuverEntry.insert({"min": -25, "max": 0, "difficulty": "RUTINA", "percent": "70"});
db.tableMovementManeuverEntry.insert({"min": 1, "max": 20, "difficulty": "RUTINA", "percent": "80"});
db.tableMovementManeuverEntry.insert({"min": 21, "max": 40, "difficulty": "RUTINA", "percent": "90"});
db.tableMovementManeuverEntry.insert({"min": 41, "max": 95, "difficulty": "RUTINA", "percent": "100"});
db.tableMovementManeuverEntry.insert({"min": 96, "max": 115, "difficulty": "RUTINA", "percent": "110"});
db.tableMovementManeuverEntry.insert({"min": 116, "max": 135, "difficulty": "RUTINA", "percent": "120"});
db.tableMovementManeuverEntry.insert({"min": 136, "max": 155, "difficulty": "RUTINA", "percent": "130"});
db.tableMovementManeuverEntry.insert({"min": 156, "max": 185, "difficulty": "RUTINA", "percent": "140"});
db.tableMovementManeuverEntry.insert({"min": 186, "max": 275, "difficulty": "RUTINA", "percent": "150"});
db.tableMovementManeuverEntry.insert({"min": 276, "max": null, "difficulty": "RUTINA", "desc": "Movimiento increíble. Notas gran mejoría", "hp": 3});



/*
db.movementManeuverTable.insert({
	"values": {
		
	}
});
*/