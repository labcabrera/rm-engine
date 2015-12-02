package org.lab.rm.engine.core.mongodb.codecs;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.lab.rm.engine.model.actor.Actor;

public class ActorCodec extends AbstractCodec<Actor> {

	public ActorCodec() {
		super();
	}

	public ActorCodec(Codec<Document> codec) {
		super(codec);
	}

	@Override
	public void encode(BsonWriter writer, Actor value, EncoderContext encoderContext) {
		Document document = new Document();
		addIfNotNull(document, "_id", value.getId());
		addIfNotNull(document, "name", value.getName());
		addIfNotNull(document, "currentLevel", value.getCurrentLevel());
		addIfNotNull(document, "maxLevel", value.getMaxLevel());
		addIfNotNull(document, "xp", value.getXp());
		addIfNotNull(document, "race", value.getRace());
		addIfNotNull(document, "gender", value.getGender());
		addIfNotNull(document, "class", value.getActorClass());
		addIfNotNull(document, "attributes", value.getAttributes());
		addIfNotNull(document, "_owner", value.getOwner().getId());
		documentCodec.encode(writer, document, encoderContext);
	}

	@Override
	public Actor decode(BsonReader reader, DecoderContext decoderContext) {
		Document document = documentCodec.decode(reader, decoderContext);
		Actor entity = new Actor();
		entity.setId(document.getObjectId("_id"));
		entity.setName(document.getString("name"));
		return entity;
	}

	@Override
	public Class<Actor> getEncoderClass() {
		return Actor.class;
	}

}
