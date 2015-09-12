package com.seventh_root.atherna.waywardclassesconnector;

import com.seventh_root.atherna.Atherna;
import com.seventh_root.atherna.character.AthernaCharacter;
import com.seventh_root.atherna.classes.AthernaClass;
import com.seventh_root.atherna.player.AthernaPlayer;
import com.seventh_root.atherna.waywardclassesconnector.classes.AthernaClassWaywardWrapper;
import net.wayward_realms.waywardlib.character.Character;
import net.wayward_realms.waywardlib.classes.Class;
import net.wayward_realms.waywardlib.classes.ClassesPlugin;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AthernaWaywardClassesConnector extends JavaPlugin implements ClassesPlugin {

    @Override
    public Collection<? extends Class> getClasses() {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        List<AthernaClass> athernaClasses = atherna.getClassManager().getAthernaClasses();
        List<AthernaClassWaywardWrapper> waywardWrappers = new ArrayList<>();
        athernaClasses.forEach(athernaClass -> waywardWrappers.add(new AthernaClassWaywardWrapper(this, athernaClass)));
        return null;
    }

    @Override
    public void addClass(Class clazz) {

    }

    @Override
    public void removeClass(Class clazz) {

    }

    @Override
    public Class getClass(OfflinePlayer player) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaPlayer athernaPlayer = atherna.getPlayerManager().getByBukkitPlayer(player);
        AthernaCharacter character = athernaPlayer.getActiveCharacter();
        return new AthernaClassWaywardWrapper(this, character.getAthernaClass());
    }

    @Override
    public void setClass(OfflinePlayer player, Class clazz) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaPlayer athernaPlayer = atherna.getPlayerManager().getByBukkitPlayer(player);
        AthernaCharacter athernaCharacter = athernaPlayer.getActiveCharacter();
        athernaCharacter.setAthernaClass(atherna.getClassManager().getByName(clazz.getName()));
    }

    @Override
    public Class getClass(String name) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        return new AthernaClassWaywardWrapper(this, atherna.getClassManager().getByName(name));
    }

    @Override
    public int getLevel(OfflinePlayer player) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaPlayer athernaPlayer = atherna.getPlayerManager().getByBukkitPlayer(player);
        AthernaCharacter athernaCharacter = athernaPlayer.getActiveCharacter();
        return atherna.getClassManager().getLevel(athernaCharacter, athernaCharacter.getAthernaClass());
    }

    @Override
    public void setLevel(OfflinePlayer player, int level) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaPlayer athernaPlayer = atherna.getPlayerManager().getByBukkitPlayer(player);
        AthernaCharacter athernaCharacter = athernaPlayer.getActiveCharacter();
        atherna.getClassManager().setLevel(athernaCharacter, athernaCharacter.getAthernaClass(), level);
    }

    @Override
    public int getTotalExperience(OfflinePlayer player) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaPlayer athernaPlayer = atherna.getPlayerManager().getByBukkitPlayer(player);
        AthernaCharacter athernaCharacter = athernaPlayer.getActiveCharacter();
        return atherna.getClassManager().getTotalExperience(athernaCharacter, athernaCharacter.getAthernaClass());
    }

    @Override
    public void setTotalExperience(OfflinePlayer player, int amount) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaPlayer athernaPlayer = atherna.getPlayerManager().getByBukkitPlayer(player);
        AthernaCharacter athernaCharacter = athernaPlayer.getActiveCharacter();
        atherna.getClassManager().setTotalExperience(athernaCharacter, athernaCharacter.getAthernaClass(), amount);
    }

    @Override
    public int getExperienceTowardsNextLevel(OfflinePlayer player) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaPlayer athernaPlayer = atherna.getPlayerManager().getByBukkitPlayer(player);
        AthernaCharacter athernaCharacter = athernaPlayer.getActiveCharacter();
        return atherna.getClassManager().getExperienceTowardsNextLevel(athernaCharacter, athernaCharacter.getAthernaClass());
    }

    @Override
    public void setExperienceTowardsNextLevel(OfflinePlayer player, int amount) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaPlayer athernaPlayer = atherna.getPlayerManager().getByBukkitPlayer(player);
        AthernaCharacter athernaCharacter = athernaPlayer.getActiveCharacter();
        atherna.getClassManager().setTotalExperience(athernaCharacter, athernaCharacter.getAthernaClass(),
                atherna.getClassManager().getTotalExperienceForLevel(atherna.getClassManager().getLevel(athernaCharacter, athernaCharacter.getAthernaClass()) + amount));
    }

    @Override
    public void giveExperience(OfflinePlayer player, int amount) {
        setTotalExperience(player, getTotalExperience(player) + amount);
    }

    @Override
    public int getLevel(OfflinePlayer player, Class clazz) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaPlayer athernaPlayer = atherna.getPlayerManager().getByBukkitPlayer(player);
        AthernaCharacter athernaCharacter = athernaPlayer.getActiveCharacter();
        AthernaClass athernaClass = atherna.getClassManager().getByName(clazz.getName());
        return atherna.getClassManager().getLevel(athernaCharacter, athernaClass);
    }

    @Override
    public void setLevel(OfflinePlayer player, Class clazz, int level) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaPlayer athernaPlayer = atherna.getPlayerManager().getByBukkitPlayer(player);
        AthernaCharacter athernaCharacter = athernaPlayer.getActiveCharacter();
        AthernaClass athernaClass = atherna.getClassManager().getByName(clazz.getName());
        atherna.getClassManager().setLevel(athernaCharacter, athernaClass, level);
    }

    @Override
    public int getTotalExperience(OfflinePlayer player, Class clazz) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaPlayer athernaPlayer = atherna.getPlayerManager().getByBukkitPlayer(player);
        AthernaCharacter athernaCharacter = athernaPlayer.getActiveCharacter();
        AthernaClass athernaClass = atherna.getClassManager().getByName(clazz.getName());
        return atherna.getClassManager().getTotalExperience(athernaCharacter, athernaClass);
    }

    @Override
    public void setTotalExperience(OfflinePlayer player, Class clazz, int amount) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaPlayer athernaPlayer = atherna.getPlayerManager().getByBukkitPlayer(player);
        AthernaCharacter athernaCharacter = athernaPlayer.getActiveCharacter();
        AthernaClass athernaClass = atherna.getClassManager().getByName(clazz.getName());
        atherna.getClassManager().setTotalExperience(athernaCharacter, athernaClass, amount);
    }

    @Override
    public int getExperienceTowardsNextLevel(OfflinePlayer player, Class clazz) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaPlayer athernaPlayer = atherna.getPlayerManager().getByBukkitPlayer(player);
        AthernaCharacter athernaCharacter = athernaPlayer.getActiveCharacter();
        AthernaClass athernaClass = atherna.getClassManager().getByName(clazz.getName());
        return atherna.getClassManager().getExperienceTowardsNextLevel(athernaCharacter, athernaClass);
    }

    @Override
    public void setExperienceTowardsNextLevel(OfflinePlayer player, Class clazz, int amount) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaPlayer athernaPlayer = atherna.getPlayerManager().getByBukkitPlayer(player);
        AthernaCharacter athernaCharacter = athernaPlayer.getActiveCharacter();
        AthernaClass athernaClass = atherna.getClassManager().getByName(clazz.getName());
        atherna.getClassManager().setTotalExperience(athernaCharacter, athernaClass,
                atherna.getClassManager().getTotalExperienceForLevel(atherna.getClassManager().getLevel(athernaCharacter, athernaClass)) + amount);
    }

    @Override
    public void giveExperience(OfflinePlayer player, Class clazz, int amount) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaPlayer athernaPlayer = atherna.getPlayerManager().getByBukkitPlayer(player);
        AthernaCharacter athernaCharacter = athernaPlayer.getActiveCharacter();
        AthernaClass athernaClass = atherna.getClassManager().getByName(clazz.getName());
        atherna.getClassManager().setTotalExperience(athernaCharacter, athernaClass,
                atherna.getClassManager().getTotalExperience(athernaCharacter, athernaClass) + amount);
    }

    @Override
    public Class getClass(Character character) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaCharacter athernaCharacter = atherna.getCharacterManager().getById(character.getId());
        return new AthernaClassWaywardWrapper(this, athernaCharacter.getAthernaClass());
    }

    @Override
    public void setClass(Character character, Class clazz) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaCharacter athernaCharacter = atherna.getCharacterManager().getById(character.getId());
        AthernaClass athernaClass = atherna.getClassManager().getByName(clazz.getName());
        athernaCharacter.setAthernaClass(athernaClass);
    }

    @Override
    public int getLevel(Character character) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaCharacter athernaCharacter = atherna.getCharacterManager().getById(character.getId());
        return atherna.getClassManager().getLevel(athernaCharacter, athernaCharacter.getAthernaClass());
    }

    @Override
    public void setLevel(Character character, int level) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaCharacter athernaCharacter = atherna.getCharacterManager().getById(character.getId());
        atherna.getClassManager().setLevel(athernaCharacter, athernaCharacter.getAthernaClass(), level);
    }

    @Override
    public int getLevel(Character character, Class clazz) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaCharacter athernaCharacter = atherna.getCharacterManager().getById(character.getId());
        AthernaClass athernaClass = atherna.getClassManager().getByName(clazz.getName());
        return atherna.getClassManager().getLevel(athernaCharacter, athernaClass);
    }

    @Override
    public void setLevel(Character character, Class clazz, int level) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaCharacter athernaCharacter = atherna.getCharacterManager().getById(character.getId());
        AthernaClass athernaClass = atherna.getClassManager().getByName(clazz.getName());
        atherna.getClassManager().setLevel(athernaCharacter, athernaClass, level);
    }

    @Override
    public int getTotalExperience(Character character) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaCharacter athernaCharacter = atherna.getCharacterManager().getById(character.getId());
        return atherna.getClassManager().getTotalExperience(athernaCharacter, athernaCharacter.getAthernaClass());
    }

    @Override
    public void setTotalExperience(Character character, int amount) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaCharacter athernaCharacter = atherna.getCharacterManager().getById(character.getId());
        atherna.getClassManager().setTotalExperience(athernaCharacter, athernaCharacter.getAthernaClass(), amount);
    }

    @Override
    public int getTotalExperience(Character character, Class clazz) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaCharacter athernaCharacter = atherna.getCharacterManager().getById(character.getId());
        AthernaClass athernaClass = atherna.getClassManager().getByName(clazz.getName());
        return atherna.getClassManager().getTotalExperience(athernaCharacter, athernaClass);
    }

    @Override
    public void setTotalExperience(Character character, Class clazz, int amount) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaCharacter athernaCharacter = atherna.getCharacterManager().getById(character.getId());
        AthernaClass athernaClass = atherna.getClassManager().getByName(clazz.getName());
        atherna.getClassManager().setTotalExperience(athernaCharacter, athernaClass, amount);
    }

    @Override
    public int getExperienceTowardsNextLevel(Character character) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaCharacter athernaCharacter = atherna.getCharacterManager().getById(character.getId());
        return atherna.getClassManager().getExperienceTowardsNextLevel(athernaCharacter, athernaCharacter.getAthernaClass());
    }

    @Override
    public void setExperienceTowardsNextLevel(Character character, int amount) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaCharacter athernaCharacter = atherna.getCharacterManager().getById(character.getId());
        atherna.getClassManager().setTotalExperience(athernaCharacter, athernaCharacter.getAthernaClass(),
                atherna.getClassManager().getTotalExperience(athernaCharacter, athernaCharacter.getAthernaClass()) + amount);
    }

    @Override
    public int getExperienceTowardsNextLevel(Character character, Class clazz) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaCharacter athernaCharacter = atherna.getCharacterManager().getById(character.getId());
        AthernaClass athernaClass = atherna.getClassManager().getByName(clazz.getName());
        return atherna.getClassManager().getExperienceTowardsNextLevel(athernaCharacter, athernaClass);
    }

    @Override
    public void setExperienceTowardsNextLevel(Character character, Class clazz, int amount) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaCharacter athernaCharacter = atherna.getCharacterManager().getById(character.getId());
        AthernaClass athernaClass = atherna.getClassManager().getByName(clazz.getName());
        atherna.getClassManager().setTotalExperience(athernaCharacter,
                athernaClass, atherna.getClassManager().getTotalExperience(athernaCharacter, athernaClass) + amount);
    }

    @Override
    public void giveExperience(Character character, int amount) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaCharacter athernaCharacter = atherna.getCharacterManager().getById(character.getId());
        atherna.getClassManager().setTotalExperience(athernaCharacter, athernaCharacter.getAthernaClass(),
                atherna.getClassManager().getTotalExperience(athernaCharacter, athernaCharacter.getAthernaClass()) + amount);
    }

    @Override
    public void giveExperience(Character character, Class clazz, int amount) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaCharacter athernaCharacter = atherna.getCharacterManager().getById(character.getId());
        AthernaClass athernaClass = atherna.getClassManager().getByName(clazz.getName());
        atherna.getClassManager().setTotalExperience(athernaCharacter, athernaClass, atherna.getClassManager().getTotalExperience(athernaCharacter, athernaClass) + amount);
    }

    @Override
    public int getTotalExperienceForLevel(int level) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        return atherna.getClassManager().getTotalExperienceForLevel(level);
    }

    @Override
    public int getExpToNextLevel(int level) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        return atherna.getClassManager().getExperienceForLevel(level + 1);
    }

    @Override
    public String getPrefix() {
        return "";
    }

    @Override
    public void loadState() {

    }

    @Override
    public void saveState() {

    }
}
