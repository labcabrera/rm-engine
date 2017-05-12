package org.lab.rm.engine.ms.common.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/random")
@Api(tags = { "Random operations" })
public class RandController {

	private final Random random;

	public RandController() {
		random = new Random();
	}

	@RequestMapping(value = "/d{max}", method = RequestMethod.GET)
	@ApiOperation(value = "Random integer", notes = "Generates a random integer value.", response = Integer.class)
	@ResponseBody
	public Integer d(
			@PathVariable("max") @ApiParam(name = "max", value = "Generates a radom integer between 1 and max") Integer max) {
		return 1 + random.nextInt(max);
	}

	@RequestMapping(value = "/c{count}/d{max}", method = RequestMethod.GET)
	@ApiOperation(value = "Random integers", notes = "Generates N random integer values.", response = Integer.class)
	public Integer[] nd( //
			@PathVariable("count") @ApiParam(name = "count", value = "Number of values") Integer count,
			@PathVariable("max") @ApiParam(name = "max", value = "Generates a radom integer between 1 and max") Integer max) {
		Integer[] result = new Integer[count];
		for (int i = 0; i < count; i++) {
			result[i] = 1 + random.nextInt(max);
		}
		return result;
	}

}
