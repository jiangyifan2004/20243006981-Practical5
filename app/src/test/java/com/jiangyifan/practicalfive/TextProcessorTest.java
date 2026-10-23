package com.jiangyifan.practicalfive;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TextProcessorTest {

    private final TextProcessor processor = new TextProcessor();

    @Test
    public void acceptsAllFourMunicipalities() {
        assertEquals("Beijing", processor.processMunicipality("Beijing"));
        assertEquals("Shanghai", processor.processMunicipality("Shanghai"));
        assertEquals("Tianjin", processor.processMunicipality("Tianjin"));
        assertEquals("Chongqing", processor.processMunicipality("Chongqing"));
    }

    @Test
    public void acceptsLowercaseNames() {
        assertEquals("Beijing", processor.processMunicipality("beijing"));
        assertEquals("Shanghai", processor.processMunicipality("shanghai"));
        assertEquals("Tianjin", processor.processMunicipality("tianjin"));
        assertEquals("Chongqing", processor.processMunicipality("chongqing"));
    }

    @Test
    public void acceptsUppercaseNames() {
        assertEquals("Beijing", processor.processMunicipality("BEIJING"));
        assertEquals("Shanghai", processor.processMunicipality("SHANGHAI"));
        assertEquals("Tianjin", processor.processMunicipality("TIANJIN"));
        assertEquals("Chongqing", processor.processMunicipality("CHONGQING"));
    }

    @Test
    public void acceptsMixedCaseNames() {
        assertEquals("Beijing", processor.processMunicipality("bEiJiNg"));
        assertEquals("Shanghai", processor.processMunicipality("sHaNgHaI"));
        assertEquals("Tianjin", processor.processMunicipality("tIaNjIn"));
        assertEquals("Chongqing", processor.processMunicipality("ChOnGqInG"));
    }

    @Test
    public void removesSurroundingWhitespace() {
        assertEquals("Beijing", processor.processMunicipality("  beijing  "));
        assertEquals("Shanghai", processor.processMunicipality("\tSHANGHAI\t"));
        assertEquals("Tianjin", processor.processMunicipality(" tianjin\n"));
        assertEquals("Chongqing", processor.processMunicipality("\nChongqing\r"));
    }

    @Test
    public void rejectsNullInput() {
        assertNull(processor.processMunicipality(null));
    }

    @Test
    public void rejectsEmptyAndWhitespaceOnlyInput() {
        assertNull(processor.processMunicipality(""));
        assertNull(processor.processMunicipality("   "));
        assertNull(processor.processMunicipality("\t\n\r"));
    }

    @Test
    public void rejectsUnsupportedAndIncompleteNames() {
        assertNull(processor.processMunicipality("Guangzhou"));
        assertNull(processor.processMunicipality("Beij"));
        assertNull(processor.processMunicipality("Beijing City"));
        assertNull(processor.processMunicipality("Bei jing"));
        assertNull(processor.processMunicipality("Beijing\nShanghai"));
    }
}
