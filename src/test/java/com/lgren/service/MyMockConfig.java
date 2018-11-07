package com.lgren.service;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.mocker.AbstractDateMock;
import com.github.jsonzou.jmockdata.util.RandomUtils;

import java.time.*;

/**
 * TODO
 *
 * @author Lgren
 * @create 2018-11-05 17:03
 **/
public class MyMockConfig extends MockConfig {
    private static final LocalDateTimeMocker LOCAL_DATE_TIME_MOCKER = new LocalDateTimeMocker("1970-01-01", "2100-12-31");
    private static final LocalDateMocker LOCAL_DATE_MOCKER = new LocalDateMocker("1970-01-01", "2100-12-31");
    private static final LocalTimeMocker LOCAL_TIME_MOCKER = new LocalTimeMocker("1970-01-01", "2100-12-31");

    public MyMockConfig() {
        super();
        this.registerMocker(LOCAL_DATE_TIME_MOCKER, LocalDateTime.class);
        this.registerMocker(LOCAL_DATE_MOCKER, LocalDate.class);
        this.registerMocker(LOCAL_TIME_MOCKER, LocalTime.class);
    }

    static class LocalDateTimeMocker extends AbstractDateMock implements Mocker<LocalDateTime> {
        public LocalDateTimeMocker(String startTimePattern, String endTime) {
            super(startTimePattern, endTime);
        }

        public LocalDateTime mock(MockConfig mockConfig) {
            return LocalDateTime.ofInstant(Instant.ofEpochSecond(RandomUtils.nextLong(this.startTime/1000, this.endTime/1000)), ZoneId.systemDefault());
        }
    }

    static class LocalDateMocker extends AbstractDateMock implements Mocker<LocalDate> {
        public LocalDateMocker(String startTimePattern, String endTime) {
            super(startTimePattern, endTime);
        }

        public LocalDate mock(MockConfig mockConfig) {
            return LocalDateTime.ofInstant(Instant.ofEpochSecond(RandomUtils.nextLong(this.startTime/1000, this.endTime/1000)), ZoneId.systemDefault())
                    .toLocalDate();
        }
    }

    static class LocalTimeMocker extends AbstractDateMock implements Mocker<LocalTime> {
        public LocalTimeMocker(String startTimePattern, String endTime) {
            super(startTimePattern, endTime);
        }

        public LocalTime mock(MockConfig mockConfig) {
            return LocalDateTime.ofInstant(Instant.ofEpochSecond(RandomUtils.nextLong(this.startTime/1000, this.endTime/1000)), ZoneId.systemDefault())
                    .toLocalTime();
        }
    }
}
