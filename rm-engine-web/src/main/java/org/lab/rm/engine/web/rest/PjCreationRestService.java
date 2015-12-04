package org.lab.rm.engine.web.rest;

import java.util.LinkedHashMap;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.Validate;
import org.lab.rm.engine.core.common.RandomService;
import org.lab.rm.engine.model.common.Message;
import org.lab.rm.engine.model.pj.AttributeType;
import org.lab.rm.engine.model.pj.Attribute;
import org.lab.rm.engine.model.pj.Pj;

@Path("pj/creation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PjCreationRestService {

	@Inject
	private RandomService randomService;

	public Pj prepare() {
		return null;
	}

	public Message<Pj> randomizeAttributes(Pj pj) {
		Validate.notNull(pj.getProfession());
		Validate.notNull(pj.getRace());
		pj.setAttributes(new LinkedHashMap<AttributeType, Attribute>());
		for (AttributeType i : AttributeType.values()) {
			Attribute a = new Attribute();
			a.setValue(randomService.rand(20, 100));
			pj.getAttributes().put(i, a);
		}
		return new Message<Pj>().withPayload(pj);
	}

}
