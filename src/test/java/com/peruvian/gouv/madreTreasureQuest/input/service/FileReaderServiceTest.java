package com.peruvian.gouv.madreTreasureQuest.input.service;

import com.peruvian.gouv.madreTreasureQuest.input.model.InformationLine;
import com.peruvian.gouv.madreTreasureQuest.input.model.InformationType;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class FileReaderServiceTest {

    @Test
    public void test_get_information_line_list_from_input_file() {

        final String filePath = "src/test/resources/inputFileTest";

        final List<InformationLine> informationLineListFromInputFile = FileReaderService.getInformationLineListFromInputFile(filePath);

        assertEquals(6, informationLineListFromInputFile.size());

        final List<InformationLine> mountainLines = informationLineListFromInputFile
                .stream()
                .filter(e -> InformationType.MOUNTAIN.equals(e.getType()))
                .collect(Collectors.toList());
        assertEquals(2, mountainLines.size());

        final List<InformationLine> treasurerLines = informationLineListFromInputFile
                .stream()
                .filter(e -> InformationType.TREASURER.equals(e.getType()))
                .collect(Collectors.toList());
        assertEquals(2, treasurerLines.size());
    }

    @Test
    public void test_get_information_line_list_from_non_existing_input_file() {

        final String filePath = "src/test/resources/inputFileNotExistingTest";

        final List<InformationLine> informationLineListFromInputFile = FileReaderService.getInformationLineListFromInputFile(filePath);

        assertEquals(0, informationLineListFromInputFile.size());
    }
}