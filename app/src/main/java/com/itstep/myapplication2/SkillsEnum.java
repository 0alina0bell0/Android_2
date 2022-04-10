package com.itstep.myapplication2;

public enum SkillsEnum {
    JAVA("Java"),
    XML("Xml"),
    ANDROID("Android");

    private final String skill;

    SkillsEnum(String skill) {
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }
}
