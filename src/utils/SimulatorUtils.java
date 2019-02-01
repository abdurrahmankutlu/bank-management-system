package utils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public final class SimulatorUtils {
    private static Instant currentTime;

    public static void setCurrentTime(Instant instant) {
        currentTime = instant;
    }

    public static Instant getCurrentTime() {
        return currentTime;
    }

    public static void monthForward() {
        currentTime.plus(30, ChronoUnit.DAYS);
    }
}
