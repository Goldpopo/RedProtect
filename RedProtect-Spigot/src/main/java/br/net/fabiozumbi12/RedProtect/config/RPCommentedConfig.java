package br.net.fabiozumbi12.RedProtect.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.bukkit.configuration.InvalidConfigurationException;

import br.net.fabiozumbi12.RedProtect.RedProtect;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class RPCommentedConfig {
	
	private HashMap<String, String> comments;

	RPCommentedConfig(){
		this.comments = new HashMap<String, String>();		
	}
	
	public void addDef(){
		File config = new File(RedProtect.pathConfig);
		if (config.exists()){
			try {
				RedProtect.plugin.getConfig().load(config);
			} catch (IOException | InvalidConfigurationException e) {
				e.printStackTrace();
			}
		}
				
		setDefault("config-version", 7.9, "Dont touch <3");
		setDefault("debug-messages", false, "Enable debug messages");
		setDefault("log-actions", true, "Log all commands used by players");
		setDefault("language", "en-EN", "Available: en-EN, pt-BR, zh-CN, de-DE, ru-RU");
		setDefault("file-type", "yml", "Available: yml and mysql");
		
		setDefault("flat-file", null, "If file-type: yml, configuration:");
		setDefault("flat-file.region-per-file", false, "Want to save the regions in your ow files?");
		setDefault("flat-file.auto-save-interval-seconds", 3600, null);
		setDefault("flat-file.backup", true, null);
		setDefault("flat-file.max-backups", 10, null);
		
		setDefault("mysql", null, "If file-type: mysql, configuration:");
		setDefault("mysql.db-name", "redprotect", null);
		setDefault("mysql.table-prefix", "rp_", null);
		setDefault("mysql.user-name", "root", null);
		setDefault("mysql.user-pass", "redprotect", null);
		setDefault("mysql.host", "localhost", null);
		
		setDefault("region-settings", null, "General settings about regions.");		
		setDefault("region-settings.claim-type", "BLOCK", "claim-type: Claim types allowed for normal players (without permission 'redprotect.admin.claim'). Options: BLOCK, WAND or BOTH.\n"
				+ "-> If BLOCK, the players needs to surround your house with the block type in configuration, and place a sign under this fence with [rp] on first line.\n"
				+ "-> If WAND, the players will need a wand (default glass_bottle), click on two point of your region, and then use /rp claim [name of region] to claim te region.\n"
				+ "-> If BOTH, will allow both claim type protections.");
		setDefault("region-settings.default-leader", "#server#", "The name of leader for regions created with /rp define or regions without leaders.");
		setDefault("region-settings.world-colors", new ArrayList<String>(), "Colors of world to show on /rp info and /rp list.");
		setDefault("region-settings.border.material", "GLOWSTONE", "Border block type when use /rp border.");
		setDefault("region-settings.border.time-showing", "BLOCK", null);
		setDefault("region-settings.region-list.simple-listing", true, "Show simple list with only name of region or all region info.");
		setDefault("region-settings.region-list.hover-and-click-teleport", true, "If running server 1.8+ enable hover and teleport click on simple list.");
		setDefault("region-settings.region-list.show-area", true, "Show region areas on list?");
		setDefault("region-settings.autoexpandvert-ondefine", true, "Automatically set max y to 256 and min y to 0 (sky to bedrock).");
		setDefault("region-settings.anti-hopper", true, "Deny break/place blocks under chests.");
		setDefault("region-settings.claim-modes.mode", "keep", "Default modes for claim regions. Modes available: keep, drop, remove or give.\n"
				+ "-> keep: Nothing happens\n"
				+ "-> drop: Will drop all protection blocks\n"
				+ "-> remove: Will remove all protection blocks\n"
				+ "-> give: Give back the protection blocks to player, and drop(on player location) if players's inventory is full.");
		setDefault("region-settings.claim-modes.allow-player-decide", false, "Allow players to decide what mode to use? If true, the player need to set the line 4 of the sign with [keep], [drop], [remove], [give] or a translation you is using on 'lang.ini'.");
		setDefault("region-settings.claim-modes.use-perm", false, "If 'allow-player-decide' is true, player need to have the permission 'redprotect.use-claim-modes' to use modes on signs.");
		setDefault("region-settings.limit-amount", 8000, "Limit of blocks until the player have other block permission.");
		setDefault("region-settings.claim-amount", 20, "Limit of claims a player can have until have other permission for claims.");
		setDefault("region-settings.block-id", "FENCE", "Block used to protect regions.");
		setDefault("region-settings.max-scan", 600, "Ammount of blocks to scan on place sign to claim a region. Consider this the max area.");
		setDefault("region-settings.date-format", "dd/MM/yyyy", "Time format to use with data and time infos.");
		setDefault("region-settings.record-player-visit-method", "ON-LOGIN", "Register player visits on... Available: ON-LOGIN, ON-REGION-ENTER.");
		setDefault("region-settings.allow-sign-interact-tags", Arrays.asList("Admin Shop", "{membername}"), "Allow players without permissions to interact with signs starting with this tags.");
		setDefault("region-settings.leadership-request-time", 20, "Time in seconds to wait player accept leadership request.");
		setDefault("region-settings.enable-flag-sign", true, "This wiil allow players to create flag signs to change flag states using [flag] on first line and the flag name on second line.");
		setDefault("region-settings.deny-build-near", 0, "Deny players to build near other regions. Distance in blocks. 0 to disable and > 0 to enable.");
		setDefault("region-settings.rent.default-level", "admin", "Set the default rent level of players renting regions. Options: member, admin, leader.");
		setDefault("region-settings.rent.add-player", false, "Allow who pay for rent to add more players in rent regions?");
		setDefault("region-settings.rent.command-renew-adds", "1:MONTH", "The amount of days or mounts the command to renew will be added. The sintax is: <number>:<type>. The types are: DAY or MONTH.");
		setDefault("region-settings.rent.renew-anytime", false, "Renew in anytime or only on renew date?");
		setDefault("region-settings.first-home.can-delete-after-claims", 10, "Player can remove the protection of first home after this amount of claims. Use -1 to do not allow to delete.");
		setDefault("region-settings.delay-after-kick-region", 60, "Delay before a kicked player can back to a region (in seconds).");
		setDefault("region-settings.claimlimit-per-world", true, "Use claim limit per worlds?");
		setDefault("region-settings.blocklimit-per-world", true, "Use block limit per worlds?");
		
		setDefault("allowed-claim-worlds", Arrays.asList("example_world"), "World where players can claim regions.");
		
		setDefault("needed-claim-to-build", null, "Worlds where players can't build without claim.");
		setDefault("needed-claim-to-build.worlds", Arrays.asList("example_world"), null);
		setDefault("needed-claim-to-build.allow-only-protections-blocks", true, "Allow player to place only protection blocks, like fences and sign.");
		
		setDefault("wands", null, "Wands configurations");
		setDefault("wands.adminWandID", 374, "Item used to define and redefine regions.");
		setDefault("wands.infoWandID", 339, "Item used to check regions.");
		
		setDefault("private", null, "Private options");
		setDefault("private.use", true, "Enable private signs?");
		setDefault("private.allow-outside", false, "Allow private signs outside regions");
		setDefault("private.allowed-blocks-use-ids", false, "Use number IDs instead item names?");
		setDefault("private.allowed-blocks", 
				Arrays.asList("DISPENSER", 
						"NOTE_BLOCK", 
						"BED_BLOCK", 
						"CHEST", 
						"WORKBENCH", 
						"FURNACE", 
						"JUKEBOX", 
						"ENCHANTMENT_TABLE", 
						"BREWING_STAND", 
						"CAULDRON",
						"ENDER_CHEST",
						"BEACON",
						"TRAPPED_CHEST",
						"HOPPER",
						"DROPPER"), "Blocks allowed to be locked with private signs.");
		
		setDefault("notify", null, "Notifications configs");
		setDefault("notify.region-exit", true, "Show region info(or wilderness message) when exit a region.");
		setDefault("notify.region-enter-mode", "BOSSBAR", "How to show the messages? Available: BOSSBAR, CHAT. If plugin BoobarApi not installed, will show on chat.");
		setDefault("notify.welcome-mode", "BOSSBAR", "Where to show the welcome message (/rp wel <message>)? Available: BOSSBAR, CHAT.");
		
		setDefault("netherProtection", null, "Deny players to go to nether roof.");		
		setDefault("netherProtection.maxYsize", 128, "Max size of your world nether.");
		setDefault("netherProtection.execute-cmd", Arrays.asList("spawn {player}"), "Execute this if player go up to maxYsize of nether.");
		
		setDefault("server-protection", null, "General server protections options.");		
		setDefault("server-protection.deny-potions", Arrays.asList("INVISIBILITY"), "List of potions the player cant use on server. Here the PotioTypes: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/potion/PotionType.html");
		setDefault("server-protection.deny-playerdeath-by", Arrays.asList("SUFFOCATION"), " List of causes the player cant die/take damage for. here the list of DamageCauses: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/entity/EntityDamageEvent.DamageCause.html");
		setDefault("server-protection.deny-commands-on-worlds.world", Arrays.asList("command"), "Deny certain commands on specific worlds.");
		setDefault("server-protection.nickname-cap-filter.enable", false, "Deny players with same nick but cap char diferences to join on server (most used on offline severs).");
		setDefault("server-protection.sign-spy.enable", false, "Show all lines of a sign when player place signs in any world.");
		setDefault("server-protection.sign-spy.only-console", true, "Show only on console or in-game too?");
		setDefault("server-protection.teleport-player.on-join.enable", false, "Teleport player on join the server.");
		setDefault("server-protection.teleport-player.on-join.need-world-to-teleport", "none", "The player need to be in this world to be teleported? Use 'none' for all worlds.");
		setDefault("server-protection.teleport-player.on-join.location", "world, 0, 90, 0", "The location, using as world, x, y, z.");
		setDefault("server-protection.teleport-player.on-leave.enable", false, "Teleport player on leave the server.");
		setDefault("server-protection.teleport-player.on-leave.need-world-to-teleport", "none", "The player need to be in this world to be teleported? Use 'none' for all worlds.");
		setDefault("server-protection.teleport-player.on-leave.location", "world, 0, 90, 0", "The location, using as world, x, y, z.");
		setDefault("server-protection.deny-structure-bypass-regions", true, "Deny structures like trees to bypass region borders?");
		setDefault("server-protection.check-killaura-freekill.enable", false, "Enable kill aura or freekill checker?");
		setDefault("server-protection.check-killaura-freekill.check-rate", 30, "This will count every block the player wall without fail to aim on player.");
		setDefault("server-protection.check-killaura-freekill.rate-multiples", 5, "What multiples of check-rate is considered kh or fk?");
		setDefault("server-protection.check-killaura-freekill.time-between-trys", 3, "Time to reset checks between attacker hits.");
		setDefault("server-protection.check-killaura-freekill.debug-trys", false, "Debug everu try? Used to see the try count on every block the player walk. Will be sequential if the player is using kill aura and will go to more than 60, 80 more than 100 if is free kill.");
		setDefault("server-protection.check-player-client", false, "Test client hack (beta)");
		
		setDefault("flags", null, "Default flag values for new regions.");
		setDefault("flags.pvp", false, null);
		setDefault("flags.chest", false, null);
		setDefault("flags.lever", false, null);
		setDefault("flags.button", false, null);
		setDefault("flags.door", false, null);
		setDefault("flags.smart-door", true, null);
		setDefault("flags.spawn-monsters", true, null);
		setDefault("flags.spawn-animals", true, null);
		setDefault("flags.passives", false, null);
		setDefault("flags.flow", true, null);
		setDefault("flags.fire", true, null);
		setDefault("flags.minecart", false, null);
		setDefault("flags.allow-home", false, null);
		setDefault("flags.allow-magiccarpet", true, null);
		setDefault("flags.mob-loot", false, null);
		setDefault("flags.flow-damage", false, null);
		setDefault("flags.iceform-player", true, null);
		setDefault("flags.iceform-world", true, null);
		setDefault("flags.allow-fly", false, null);
		setDefault("flags.teleport", false, null);
		setDefault("flags.clan", "", null);
		setDefault("flags.ender-chest", true, null);
		setDefault("flags.can-grow", true, null);
		setDefault("flags.use-potions", true, null);
		setDefault("flags.allow-effects", true, null);
		setDefault("flags.allow-spawner", false, null);
		setDefault("flags.leaves-decay", false, null);
		setDefault("flags.build", false, null);
		
		setDefault("flags-configuration", null, ""
				+ "effects-duration: Duration for timed flags like potions effects, jump, etc.\n"
				+ "enabled-flags: Flags enabled to players use with commands and flag Gui.\n"
				+ "pvparena-nopvp-kick-cmd: Command to use if players with pvp off enter in a region with 'pvparena' enabled.\n"
				+ "change-flag-delay: Delay the player can change a flag after last change.\n"
				+ "flags: List of flags the player will need to wait to change.");
		setDefault("flags-configuration.effects-duration", 5, "Duration for timed flags like potions effects, jump, etc.");
		setDefault("flags-configuration.enabled-flags", Arrays.asList(
				"pvp",
				"chest",
				"lever",
				"button",
				"door",
				"smart-door",
				"spawn-monsters",
				"spawn-animals",
				"passives",
				"flow",
				"fire",
				"minecart",
				"allow-potions",
				"allow-home",
				"allow-magiccarpet",
				"mob-loot",
				"flow-damage",
				"iceform-player",
				"iceform-world",
				"allow-fly",
				"teleport",
				"clan",
				"ender-chest",
				"leaves-decay",
				"build"), "Flags enabled to players use with commands and flag Gui.");		
		setDefault("flags-configuration.pvparena-nopvp-kick-cmd", "spawn {player}", "Command to use if players with pvp off enter in a region with 'pvparena' enabled.");
		setDefault("flags-configuration.change-flag-delay.enable", true, "Enable delay to change flags.");
		setDefault("flags-configuration.change-flag-delay.seconds", 10, "Delay the player can change a flag after last change.");
		setDefault("flags-configuration.change-flag-delay.flags", Arrays.asList("pvp"), "List of flags the player will need to wait to change.");
		
		setDefault("purge", null, null);
		setDefault("purge.enabled", false, null);
		setDefault("purge.remove-oldest", 90, null);
		setDefault("purge.regen.enable", false, "Hook with WorldEdit, will regen only the region areas to bedrock to sky. Theres no undo for this action!");
		setDefault("purge.regen.max-area-regen", 500, "Max area size to automatic regen the region.");
		setDefault("purge.regen.awe-logs", false, "Show regen logs if using AsyncWorldEdit.");
		setDefault("purge.ignore-regions-from-players", new ArrayList<String>(), null);
		
		setDefault("sell", null, null);
		setDefault("sell.enabled", false, "Put regions to sell after x time the player dont came online.");
		setDefault("sell.sell-oldest", 90, null);
		setDefault("sell.ignore-regions-from-players", new ArrayList<String>(), null);
		
		setDefault("performance", null, null);
		setDefault("performance.disable-onPlayerMoveEvent-handler", false, "Disable player move event to improve performance? Note: Disabling this will make some flags do not work, like deny enter, execute commands and effects.");
		setDefault("performance.piston.disable-PistonEvent-handler", false, "Disable piston listener? Disabling this will allow players to get blocks from protected regions to unprotected using pistons.");
		setDefault("performance.piston.use-piston-restricter", false, null);
		setDefault("performance.piston.restrict-piston-event", 10, "Fire the piston extract/retract every x ticks. Server default is 1 tick/event. Value in ticks (20 ticks = 1 sec)");
		
		setDefault("schematics", null, "This is the schematics configs for RedProtect.\n");
		setDefault("schematics.first-house-file", "house1.schematic", "Schematic file name to use with /rp start.");
		
		setDefault("hooks", null, null);
		setDefault("hooks.check-uuid-names-onstart", false, "Convert/check names if need to update to/from UUID/names on server start? Disable for Bungeecoord.");
		setDefault("hooks.essentials.import-lastvisits", false, "Import last visits from Essentials to RedProtect Regions.");
		setDefault("hooks.dynmap.enable", true, "Enable hook to show all regions on dynmap plugin?");
		setDefault("hooks.dynmap.hide-by-default", true, "Hide the Redprotect tab group by default?");
		setDefault("hooks.dynmap.marks-groupname", "RedProtect", "Group name to show on hide/show tab map.");
		setDefault("hooks.dynmap.layer-priority", 10, "If you use another region mark plugin.");
		setDefault("hooks.dynmap.show-label", true, "Show names under regions.");
		setDefault("hooks.dynmap.show-icon", true, "Show icons under regions.");
		setDefault("hooks.dynmap.marker-icon", "shield", "Icon name to show under regions. All icons are available here: http://i.imgur.com/f61GPoE.png");
		setDefault("hooks.dynmap.show-leaders-admins", false, "Show leaders and admins on hover?");
		setDefault("hooks.dynmap.cuboid-region.enable", true, "Cuboid region config.");
		setDefault("hooks.dynmap.cuboid-region.if-disable-set-center", 60, null);
		setDefault("hooks.dynmap.min-zoom", 0, null);
		setDefault("hooks.magiccarpet.fix-piston-getblocks", true, "Fix pistons allow get mc blocks.");
		setDefault("hooks.armor-stands.spawn-arms", true, null);
		setDefault("hooks.mcmmo.fix-acrobatics-fireoff-leveling", true, "Fix players leveling with creeper explosions on flag fire disabled.");
		setDefault("hooks.mcmmo.fix-berserk-invisibility", true, "Fix the ability berserk making players and mobs invisible around who activated the ability.");
		setDefault("hooks.worldedit.use-for-schematics", true, "Use WorldEdit to paste newbie home-schematics (/rp start)? *RedProtect already can paste schematics without WorldEdit, but dont support NBT tags like chest contents and sign messages.");
		setDefault("hooks.asyncworldedit.use-for-regen", false, "Use AsyncWorldEdit for regen regions? (need WorldEdit).");
		setDefault("hooks.factions.claim-over-rps", false, "Allow players claim Factions chunks under RedProtect regions?");		
		setDefault("hooks.simpleclans.use-war", false, "Enable Clan Wars from SimleClans.");	
		setDefault("hooks.simpleclans.war-on-server-regions", false, "Allow war clans to pvp on #server# regions?");
	}
	
	private void setDefault(String key, Object def, String comment){
		if (def != null){
			RedProtect.plugin.getConfig().set(key, RedProtect.plugin.getConfig().get(key, def));
		}		
 		if (comment != null){
 			setComment(key, comment);
 		}
 	}
 	
 	private void setComment(String key, String comment){
 		comments.put(key, comment);
 	}
 	
 	public void saveConfig(){
 		StringBuilder b = new StringBuilder();
 		RedProtect.plugin.getConfig().options().header(null);
 		
 		b.append(""
					+ "# +--------------------------------------------------------------------+ #\n"
					+ "# <               RedProtect World configuration File                  > #\n"
	                + "# <--------------------------------------------------------------------> #\n"
	                + "# <       This is the configuration file, feel free to edit it.        > #\n"
	                + "# <        For more info about cmds and flags, check our Wiki:         > #\n"
	                + "# <         https://github.com/FabioZumbi12/RedProtect/wiki            > #\n"
	                + "# +--------------------------------------------------------------------+ #\n"
	                + "#\n"
	                + "# Notes:\n"
	                + "# Lists are [object1, object2, ...]\n"
	                + "# Strings containing the char & always need to be quoted").append('\n');
 		
 		for (String line:RedProtect.plugin.getConfig().getKeys(true)){ 			
 			String[] key = line.split("\\"+RedProtect.plugin.getConfig().options().pathSeparator()); 			
 			String spaces = new String(); 			
 			for (int i = 0; i < key.length; i++){
 				if (i == 0) continue;
 				spaces = spaces+" "; 				
 			} 			
 			if (comments.containsKey(line)){
 				if (spaces.isEmpty()){
 					b.append("\n# "+comments.get(line).replace("\n", "\n# ")).append('\n');
 				} else {
 					b.append(spaces+"# "+comments.get(line).replace("\n", "\n"+spaces+"# ")).append('\n');
 				}
 			} 			
 			Object value = RedProtect.plugin.getConfig().get(line); 			
 			if (!RedProtect.plugin.getConfig().isConfigurationSection(line)){
 				if (value instanceof String){
 					b.append(spaces+key[key.length-1]+": '"+value+"'\n");
 				} else if (value instanceof List<?>) {
 					b.append(spaces+key[key.length-1]+":\n");
 					for (Object lineCfg:(List<?>)value){
 						if (lineCfg instanceof String){
 							b.append(spaces+"- '"+lineCfg+"'\n");
 		 				} else {
 		 					b.append(spaces+"- "+lineCfg+"\n");
 		 				}
 					}
 				} else {
 					b.append(spaces+key[key.length-1]+": "+value+"\n");
 				}
 			} else {
 				b.append(spaces+key[key.length-1]+":\n");
 			}
 					
 		}
 		
 		try {
 			Files.write(b, new File(RedProtect.pathMain, "config.yml"), Charsets.UTF_8);
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
 	}
}
