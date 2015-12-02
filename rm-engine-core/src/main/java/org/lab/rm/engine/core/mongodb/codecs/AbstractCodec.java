package org.lab.rm.engine.core.mongodb.codecs;

import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DocumentCodec;
import org.bson.types.ObjectId;
import org.lab.rm.engine.model.HasId;

public abstract class AbstractCodec<E extends HasId> implements CollectibleCodec<E> {

	protected Codec<Document> documentCodec;

	public AbstractCodec() {
		this.documentCodec = new DocumentCodec();
	}

	public AbstractCodec(Codec<Document> codec) {
		this.documentCodec = codec;
	}

	@Override
	public boolean documentHasId(E document) {
		return document.getId() != null;
	}

	@Override
	public BsonValue getDocumentId(E document) {
		if (!documentHasId(document)) {
			throw new IllegalStateException("The document does not contain an identifier");
		}
		return new BsonString(document.getId().toHexString());
	}

	@Override
	public E generateIdIfAbsentFromDocument(E entity) {
		if (documentHasId(entity)) {
			return entity;
		} else {
			entity.setId(new ObjectId());
			return entity;
		}
	}

	protected void addIfNotNull(Document document, String key, Object value) {
		if (value != null) {
			document.put(key, value);
		}
	}
}
