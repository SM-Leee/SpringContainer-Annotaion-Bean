package config.mixing.videosystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({DVDConfig.class, DVDPlayerConfig.class}) //Java Config를 땡겨올때
@ImportResource("classpath:config/mixing/videosystem/DVDConfig.xml") //XML Config를 떙겨올때
public class VideoSystemConfig02 {

}
