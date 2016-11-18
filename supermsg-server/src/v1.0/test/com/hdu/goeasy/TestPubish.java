package com.hdu.goeasy;

import io.goeasy.GoEasy;

public class TestPubish {
	public static void main(String[] args) {
		GoEasy goEasy = new GoEasy(Config.APP_KEY);
		goEasy.publish("14108414", "hello goeasy");
	}

}
