package com.example.demo;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("Europe/Zurich"));

        System.out.println("now \t \t \t" + now);
        System.out.println("zonedDateTime  \t \t \t \t" + zonedDateTime);
        System.out.println("zonedDateTime.toLocalDateTime  \t" + zonedDateTime.toLocalDateTime());
        System.out.println("zonedDateTime.withZoneSameInstant  \t" + zonedDateTime.withZoneSameInstant(ZoneId.of("Europe/Zurich")));
    }
}
