package lt.vianet.toptags.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CheckTime {

    public String getTime() {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        return sdf.format(new Date());
    }
}


