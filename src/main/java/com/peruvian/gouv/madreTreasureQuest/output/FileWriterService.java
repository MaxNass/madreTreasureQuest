package com.peruvian.gouv.madreTreasureQuest.output;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterService {

    public static FileWriter getFileWriterFromPath(final String filePathToWrite) throws IOException {
        return new FileWriter(filePathToWrite);
    }

    public static void writeInformationIntoFileWriter(final FileWriter fileWriter,
                                                      final String information) throws IOException {
        fileWriter.write(information);
    }

}
