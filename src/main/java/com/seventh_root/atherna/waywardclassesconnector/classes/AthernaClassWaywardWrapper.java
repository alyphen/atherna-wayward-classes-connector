package com.seventh_root.atherna.waywardclassesconnector.classes;

import com.seventh_root.atherna.classes.AthernaClass;
import com.seventh_root.atherna.waywardclassesconnector.AthernaWaywardClassesConnector;
import net.wayward_realms.waywardlib.classes.Class;
import net.wayward_realms.waywardlib.classes.Stat;
import net.wayward_realms.waywardlib.skills.SkillType;

import java.util.HashMap;
import java.util.Map;

public class AthernaClassWaywardWrapper implements net.wayward_realms.waywardlib.classes.Class {

    private AthernaWaywardClassesConnector plugin;
    private AthernaClass athernaClass;

    public AthernaClassWaywardWrapper(AthernaWaywardClassesConnector plugin, AthernaClass athernaClass) {
        this.plugin = plugin;
        this.athernaClass = athernaClass;
    }

    @Override
    public String getName() {
        return athernaClass.getName();
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public boolean hasPrerequisites(net.wayward_realms.waywardlib.character.Character character) {
        return true;
    }

    @Override
    public Map<Class, Integer> getPrerequisites() {
        return new HashMap<>();
    }

    @Override
    public void addPrerequisite(Class clazz, int level) {

    }

    @Override
    public void removePrerequisite(Class clazz) {

    }

    @Override
    public double getHpBonus() {
        return 0;
    }

    @Override
    public void setHpBonus(double hpBonus) {

    }

    @Override
    public int getStatBonus(Stat stat) {
        return 0;
    }

    @Override
    public void setStatBonus(Stat stat, int bonus) {

    }

    @Override
    public int getMeleeAttackBonus() {
        return 0;
    }

    @Override
    public void setMeleeAttackBonus(int attackBonus) {

    }

    @Override
    public int getRangedAttackBonus() {
        return 0;
    }

    @Override
    public void setRangedAttackBonus(int attackBonus) {

    }

    @Override
    public int getMagicAttackBonus() {
        return 0;
    }

    @Override
    public void setMagicAttackBonus(int attackBonus) {

    }

    @Override
    public int getMeleeDefenceBonus() {
        return 0;
    }

    @Override
    public void setMeleeDefenceBonus(int defenceBonus) {

    }

    @Override
    public int getRangedDefenceBonus() {
        return 0;
    }

    @Override
    public void setRangedDefenceBonus(int defenceBonus) {

    }

    @Override
    public int getMagicDefenceBonus() {
        return 0;
    }

    @Override
    public void setMagicDefenceBonus(int defenceBonus) {

    }

    @Override
    public int getSpeedBonus() {
        return 0;
    }

    @Override
    public void setSpeedBonus(int speedBonus) {

    }

    @Override
    public int getManaBonus() {
        return 0;
    }

    @Override
    public void setManaBonus(int manaBonus) {

    }

    @Override
    public int getSkillPointBonus(SkillType type) {
        return 0;
    }

    @Override
    public void setSkillPointBonus(SkillType type, int bonus) {

    }

    @Override
    public int getMaxLevel() {
        return athernaClass.getMaxLevel();
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> serialised = new HashMap<>();
        serialised.put("name", getName());
        serialised.put("max-level", getMaxLevel());
        return serialised;
    }

}
