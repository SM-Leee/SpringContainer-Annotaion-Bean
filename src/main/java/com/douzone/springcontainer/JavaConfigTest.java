package com.douzone.springcontainer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.douzone.springcontainer.soundsystem.CDPlayer;
import com.douzone.springcontainer.soundsystem.CompactDisc;
import com.douzone.springcontainer.user.User;
import com.douzone.springcontainer.videosystem.DVDPlayer;
import com.douzone.springcontainer.videosystem.DigitalVideoDisc;

import config.mixing.videosystem.DVDPlayerConfig;
import config.mixing.videosystem.VideoSystemConfig01;
import config.mixing.videosystem.VideoSystemConfig02;
import config.mixing.videosystem.VideoSystemConfig03;
import config.user.AppConfig01;

public class JavaConfigTest {

	public static void main(String[] args) {
		// testJavaConfig01();
		// testJavaConfig02();
		// testJavaConfig03();
		// testJavaConfig04();
		// testJavaConfig05();
		// testJavaConfig06();
		// testJavaConfig07();
		testJavaConfig08();
	}

	// Java Config 01
	// 직접 설정 자바 클래스를 전달하는 경우
	// 설정 자바 클래스에 @Configuration 필요없음
	public static void testJavaConfig01() {
		ApplicationContext appCtx = 
				new AnnotationConfigApplicationContext(AppConfig01.class);
	
		User user = appCtx.getBean(User.class);
		System.out.println( user );
		
		((ConfigurableApplicationContext)appCtx).close();
	}
	
	// Java Config 02
	// 설정 자바 클래스가 있는 베이스 패키지를 지정하는 방법
	// 설정 자바 클래스에 @Configuration 반드시 필요하다.
	// config.user 에 anntation이 붙어있어야된다.
	public static void testJavaConfig02() {
		ApplicationContext appCtx = 
				new AnnotationConfigApplicationContext("config.user");
	
		User user = appCtx.getBean(User.class);
		System.out.println( user );
	
		((ConfigurableApplicationContext)appCtx).close();
	}
	
	// Java Config 03 - 자동설정
	// Component Scanning( @Component, @Autowired )
	public static void testJavaConfig03() {
		ApplicationContext appCtx = 
				new AnnotationConfigApplicationContext("config.soundsystem");
	
		CompactDisc cd = appCtx.getBean( CompactDisc.class );
		System.out.println( cd );
		
		//Component Annotation을 id로 가져오는 방법
		cd = (CompactDisc) appCtx.getBean("blueBlood");
		System.out.println(cd);
		
		CDPlayer cdPlayer = appCtx.getBean( CDPlayer.class );
		cdPlayer.play();

		((ConfigurableApplicationContext)appCtx).close();
	}
	
	// Java Config 04 - 명시적 설정
	// ComponentScan을 사용하지 않음
	// Java Config Class의 Method와 @Bean를 사용하는 설정
	public static void testJavaConfig04() {
		ApplicationContext appCtx = 
				new AnnotationConfigApplicationContext("config.videosystem");
		
		DigitalVideoDisc dvd = appCtx.getBean(DigitalVideoDisc.class);
		System.out.println(dvd);
		
		DVDPlayer dvdPlayer = appCtx.getBean(DVDPlayer.class);
		dvdPlayer.play();

		//DVDPlayer dvdPlayer = (DVDPlayer) appCtx.getBean("dvdPlayer1");
		//dvdPlayer.play();
		
		((ConfigurableApplicationContext)appCtx).close();
		
	}
	
	// Java Config 05 - Mixing 01
	// Java Config(Player 설정) <- Java Config (DVD 설정)
	public static void testJavaConfig05() {
		ApplicationContext appCtx = 
				new AnnotationConfigApplicationContext(DVDPlayerConfig.class);
		DVDPlayer dvdPlayer = appCtx.getBean(DVDPlayer.class);
		dvdPlayer.play();
		
		((ConfigurableApplicationContext)appCtx).close();
	}
	
	// Java Config 05 - Mixing 02
	// Java Config(새로운 설정) <- Java Config(DVD 설정) + Java Config(Player 설정)
	public static void testJavaConfig06() {
		ApplicationContext appCtx = 
				new AnnotationConfigApplicationContext(VideoSystemConfig01.class);
		DVDPlayer dvdPlayer = appCtx.getBean(DVDPlayer.class);
		dvdPlayer.play();
		
		((ConfigurableApplicationContext)appCtx).close();
	}
	
	// Java Config 05 - Mixing 03
	// Java Config(새로운 설정) <- Java Config + XML Config
	public static void testJavaConfig07() {
		ApplicationContext appCtx = 
				new AnnotationConfigApplicationContext(VideoSystemConfig02.class);
		DVDPlayer dvdPlayer = appCtx.getBean(DVDPlayer.class);
		dvdPlayer.play();
		
		((ConfigurableApplicationContext)appCtx).close();
	}
	
	// Java Config 05 - Mixing 04
	// Java Config(새로운 설정) <- XML Config
	public static void testJavaConfig08() {
		ApplicationContext appCtx = 
				new AnnotationConfigApplicationContext(VideoSystemConfig03.class);
		DVDPlayer dvdPlayer = appCtx.getBean(DVDPlayer.class);
		dvdPlayer.play();
		
		((ConfigurableApplicationContext)appCtx).close();
	}
}
