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
/* TODO
MONJE(Realm.ARMS_MAGIC),
GUARDABOSQUES(Realm.ARMS_MAGIC),
BARDO(Realm.ARMS_MAGIC);
// PALADIN,
// ARMSMASTER,
// ARCANIST
*/

// Weapon types
db.weaponType.insert({"name": "Bastard Sword"})
