package org.lab.rm.engine.web.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.lab.rm.engine.core.actor.ActorEntityService;
import org.lab.rm.engine.model.actor.Actor;
import org.lab.rm.engine.model.common.Message;
import org.lab.rm.engine.model.common.SearchResults;

@Path("actor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ActorRestService implements CrudRestService<Actor> {

	@Inject
	private ActorEntityService entityService;

	@GET
	@Path("id/{id}")
	@Override
	public Actor findById(@PathParam("id") String primaryKey) {
		return entityService.findByPrimaryKey(primaryKey);
	}

	@GET
	@Path("find")
	@Override
	public SearchResults<Actor> find(@QueryParam("q") String expression, @QueryParam("P") Integer p, @QueryParam("c") Integer c) {
		return entityService.find(expression, p, c);
	}

	@POST
	@Path("persist")
	@Override
	public Message<Actor> persist(Actor entity) {
		return entityService.persist(entity);
	}

	@POST
	@Override
	@Path("persist")
	public Message<Actor> merge(Actor entity) {
		return entityService.merge(entity);
	}

	@DELETE
	@Override
	public Message<Actor> remove(String primaryKey) {
		return entityService.remove(primaryKey);
	}
}
