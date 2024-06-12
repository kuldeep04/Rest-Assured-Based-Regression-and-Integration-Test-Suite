package org.inflectionIo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.inflectionIo.utils.TestUtils.getDateAndTime;

public class TestUtils {

    public static String serializeObject(Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getDateAndTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return 0;
        }
        ZoneId zone = ZoneId.of("UTC");
        ZonedDateTime zonedDateTime = dateTime.atZone(zone);
        return (int) zonedDateTime.toEpochSecond();
    }
}
