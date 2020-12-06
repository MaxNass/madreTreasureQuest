package com.peruvian.gouv.madreTreasureQuest.input.service;

import com.peruvian.gouv.madreTreasureQuest.input.model.InformationLine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderService {

    public static List<InformationLine> getInformationLineListFromInputFile(final String inputFilePath) {

        List<InformationLine> informationLines = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(inputFilePath))) {

            informationLines = stream
                            .map(line -> new InformationLine(line, ExtractInformationService.extractInformationType(line)))
                            .collect(Collectors.toList());

        } catch (IOException e) {
            System.out.println(" We got an In/Out Exception, please verify the input file path used " + e);
        }

        return informationLines;
    }



}
