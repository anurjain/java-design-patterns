package com.aj.java.structural;

interface AudioPlayer {
	public void playSound ();
}

class MP3AudioPlayer implements AudioPlayer {

	@Override
	public void playSound() {
		System.out.println("Playing MP3 audio....");
	}
}

interface MediaPlayer {
	public void playVideo ();
}

class MP4VideoPlayer implements MediaPlayer {

	@Override
	public void playVideo() {
		System.out.println("Playing MP4 video....");
	}
}

class MediaAdapter implements MediaPlayer {

	AudioPlayer audioplayer;
	
	public MediaAdapter (AudioPlayer ap) {
		this.audioplayer = ap;
	}
	
	@Override
	public void playVideo() {
		System.out.println("Inside adapter");
		audioplayer.playSound();
	}
	
}

public class AdaptorExample {
	public static void main(String[] args) {
		MediaPlayer player = new MP4VideoPlayer ();
		player.playVideo();
		
		player = new MediaAdapter (new MP3AudioPlayer ());
		player.playVideo();
	}
}
