package com.peruvian.gouv.madreTreasureQuest.inputExtraction;

public class InformationLine {

    private String informationLine;
    private InformationType type;

    public InformationLine(final String informationLine, final InformationType type) {
        this.informationLine = informationLine;
        this.type = type;
    }

    public String getInformationLine() {
        return informationLine;
    }

    public void setInformationLine(String informationLine) {
        this.informationLine = informationLine;
    }

    public InformationType getType() {
        return type;
    }

    public void setType(InformationType type) {
        this.type = type;
    }
}
