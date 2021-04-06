package com.baxance.songr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testSomething(){
		Album test = new Album("The Bees Made Honey in the Lions Skull",
				"Earth",
				7,
				3206,
				"https://southernlord" +
						".com/media/2018/03/Sunn90_Earth_Bees-666x666.jpg");
		String expected = "The Bees Made Honey in the Lions Skull";
		String actual = test.getTitle();
		Assert.isTrue(expected.equals(actual), "new album from constructor");
	}

}
