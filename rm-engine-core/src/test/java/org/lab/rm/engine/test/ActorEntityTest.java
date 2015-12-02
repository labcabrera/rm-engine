package org.lab.rm.engine.test;

import org.junit.Test;

public class ActorEntityTest {

	@Test
	public void test() {
		// Injector injector = Guice.createInjector(new RmEngineModule());
		//
		// MongoEntityService entityService = injector.getInstance(MongoEntityService.class);
		// // Serializer serializer = injector.getInstance(Serializer.class);
		// MongoDatabase mongoDatabase = injector.getProvider(MongoDatabase.class).get();
		//
		// SearchResults<User> users = entityService.find(User.class, User.COLLECTION_NAME, "{\"name\":\"lab.cabrera\"}", 1, 1);
		// Validate.isTrue(!users.getResults().isEmpty());
		// User user = users.getResults().iterator().next();
		//
		// Actor actor = new Actor();
		// actor.setOwner(new DBRef(User.COLLECTION_NAME, user.getId()));
		// actor.setName("Kiove");
		// // actor.setActorClass(ActorClass.ROGUE);
		// // actor.setRace(Race.GREY_ELF);
		// actor.setAge(35);
		// actor.setCurrentLevel(100);
		// actor.setMaxLevel(100);
		// actor.setXp(42384723L);
		// actor.setMaxHitPoints(245);
		// // actor.setGender(Gender.FEMALE);
		// // actor.setAttributes(new ArrayList<ActorAttribute>());
		// // actor.getAttributes().add(new ActorAttribute(AttributeType.REASONING, 92));
		// // actor.getAttributes().add(new ActorAttribute(AttributeType.AGILITY, 89));
		// // actor.getAttributes().add(new ActorAttribute(AttributeType.CONSTITUTION, 25));
		// // actor.getAttributes().add(new ActorAttribute(AttributeType.APPEARANCE, 75));
		// // actor.getAttributes().add(new ActorAttribute(AttributeType.INTUITION, 55));
		// // actor.getAttributes().add(new ActorAttribute(AttributeType.QUICKNESS, 91));
		// // actor.getAttributes().add(new ActorAttribute(AttributeType.SANITY, 32));
		// // actor.getAttributes().add(new ActorAttribute(AttributeType.MEMORY, 87));
		//
		// // entityService.persist(actor);
		// MongoCollection<Actor> actorCollection = mongoDatabase.getCollection("actor", Actor.class);
		// actorCollection.insertOne(actor);
		//
		// // MongoCollection<Document> collection = mongoDatabase.getCollection("actor");
		// // Document readed = collection.find(new BasicDBObject("name", "Kiove")).first();
		// // System.out.println("Readed:");
		// // System.out.println(readed.toJson());
		// Actor readed = actorCollection.find().first();
		//
		// System.out.println(readed.getOwner().getCollectionName());
		// System.out.println(readed.getOwner().getId());
	}

}
