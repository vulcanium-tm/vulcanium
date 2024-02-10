package org.vulcanium;

import static org.vulcanium.support.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.jupiter.api.Test;

public class InstrumentTest {
    @Test
    public void getByType() {
        for (Instrument instrument : Instrument.values()) {
            if (instrument.getType() < 0) {
                continue;
            }

            assertThat(Instrument.getByType(instrument.getType()), is(instrument));
        }
    }
}
