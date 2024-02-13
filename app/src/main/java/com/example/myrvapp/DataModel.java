package com.example.myrvapp;

public class DataModel {
    private String characterName;
    private String characterDescription;
    private int characterImage;

    public DataModel(String characterName, String characterDescription, int characterImage) {
        this.characterName = characterName;
        this.characterDescription = characterDescription;
        this.characterImage = characterImage;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterDescription() {
        return characterDescription;
    }

    public void setCharacterDescription(String characterDescription) {
        this.characterDescription = characterDescription;
    }

    public int getCharacterImage() {
        return characterImage;
    }

    public void setCharacterImage(int characterImage) {
        this.characterImage = characterImage;
    }
    public String getCharacterName() {
        return characterName;
    }










}
