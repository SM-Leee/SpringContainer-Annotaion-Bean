package com.douzone.springcontainer.soundsystem;

import javax.inject.Named;

//id를 줄때에는 Component 보다는 Nmaed를 쓰는것이 좋다.

//@Component
@Named("blueBlood")
public class BlueBlood implements CompactDisc {
	private String title = "Endless Rain";
	private String artist = "X Japan";
	
	@Override
	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}

	@Override
	public String toString() {
		return "BlueBlood [title=" + title + ", artist=" + artist + "]";
	}
}
