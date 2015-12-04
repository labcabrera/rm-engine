package org.lab.rm.engine.core.common;

import java.util.Random;

import javax.inject.Singleton;

@Singleton
public class RandomService {

	private final Random random;

	public RandomService() {
		random = new Random();
	}

	public Integer rand(int min, int max) {
		return 1 + random.nextInt(max - min);
	}

	public Integer d10() {
		return rand(1, 10);
	}

	public Integer d100() {
		return rand(1, 100);
	}

}
