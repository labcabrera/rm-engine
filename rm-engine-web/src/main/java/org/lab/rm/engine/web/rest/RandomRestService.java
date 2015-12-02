package org.lab.rm.engine.web.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("random")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RandomRestService {

	private final Random random;

	public RandomRestService() {
		random = new Random();
	}

	@GET
	@Path("d10")
	public Integer d10() {
		return random.nextInt(10) + 1;
	}

	@GET
	@Path("d100")
	public Integer d100() {
		return random.nextInt(100) + 1;
	}

	@GET
	@Path("d100/{count}")
	public List<Integer> d100(@PathParam("count") Integer count) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			result.add(d100());
		}
		return result;
	}

}
