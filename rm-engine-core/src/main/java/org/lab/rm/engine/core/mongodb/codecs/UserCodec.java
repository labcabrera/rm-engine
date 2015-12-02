package org.lab.rm.engine.core.mongodb.codecs;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.lab.rm.engine.model.user.User;

public class UserCodec extends AbstractCodec<User> {

	public UserCodec() {
		super();
	}

	public UserCodec(Codec<Document> codec) {
		super(codec);
	}

	@Override
	public void encode(BsonWriter writer, User value, EncoderContext encoderContext) {
		Document document = new Document();
		addIfNotNull(document, "_id", value.getId());
		addIfNotNull(document, "name", value.getName());
		addIfNotNull(document, "email", value.getEmail());
		documentCodec.encode(writer, document, encoderContext);
	}

	@Override
	public User decode(BsonReader reader, DecoderContext decoderContext) {
		Document document = documentCodec.decode(reader, decoderContext);
		User user = new User();
		user.setId(document.getObjectId("_id"));
		user.setName(document.getString("name"));
		user.setEmail(document.getString("email"));
		return user;
	}

	@Override
	public Class<User> getEncoderClass() {
		return User.class;
	}
}
