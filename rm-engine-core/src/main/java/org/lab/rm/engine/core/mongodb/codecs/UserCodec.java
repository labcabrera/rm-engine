package org.lab.rm.engine.core.mongodb.codecs;

import org.apache.commons.lang3.StringUtils;
import org.bson.BsonReader;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.DocumentCodec;
import org.bson.codecs.EncoderContext;
import org.bson.types.ObjectId;
import org.lab.rm.engine.model.common.User;

public class UserCodec implements CollectibleCodec<User> {

	private Codec<Document> documentCodec;

	public UserCodec() {
		this.documentCodec = new DocumentCodec();
	}

	public UserCodec(Codec<Document> codec) {
		this.documentCodec = codec;
	}

	@Override
	public void encode(BsonWriter writer, User value, EncoderContext encoderContext) {
		Document document = new Document();
		ObjectId id = value.getId();
		String name = value.getName();
		String email = value.getEmail();
		if (id != null) {
			document.put("_id", id);
		}
		if (StringUtils.isNotBlank(name)) {
			document.put("name", name);
		}
		if (StringUtils.isNotBlank(name)) {
			document.put("email", email);
		}
		documentCodec.encode(writer, document, encoderContext);
	}

	@Override
	public Class<User> getEncoderClass() {
		return User.class;
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
	public User generateIdIfAbsentFromDocument(User document) {
		return documentHasId(document) ? document.withNewObjectId() : document;
	}

	@Override
	public boolean documentHasId(User document) {
		return document.getId() != null;
	}

	@Override
	public BsonValue getDocumentId(User document) {
		if (!documentHasId(document)) {
			throw new IllegalStateException("The document does not contain an _id");
		}
		return new BsonString(document.getId().toHexString());
	}

}
