package com.hdu.push;

import java.util.ArrayList;
import java.util.List;

import com.hdu.pusher.api.Pusher;

public class T {
	public static void main(String[] args) {
		Pusher.pushAll("test", "hello world.");
		
		
		List<String> list = new ArrayList<>();
		list.add("ta");
		System.out.println(Pusher.pushByTag("123", "14456", list).toString());
	}

}
