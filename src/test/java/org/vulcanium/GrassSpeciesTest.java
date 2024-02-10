package org.vulcanium;

import static org.vulcanium.support.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.jupiter.api.Test;

public class GrassSpeciesTest {
    @Test
    public void getByData() {
        for (GrassSpecies grassSpecies : GrassSpecies.values()) {
            assertThat(GrassSpecies.getByData(grassSpecies.getData()), is(grassSpecies));
        }
    }
}
