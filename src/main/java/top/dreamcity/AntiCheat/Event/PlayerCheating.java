package top.dreamcity.AntiCheat.Event;

import cn.nukkit.Player;
import cn.nukkit.event.Cancellable;
import cn.nukkit.event.HandlerList;
import cn.nukkit.event.player.PlayerEvent;
import top.dreamcity.AntiCheat.Cheat.AntiCheat;

/**
 * Copyright © 2017 WetABQ&DreamCityAdminGroup All right reserved.
 * Welcome to DreamCity Server Address:dreamcity.top:19132
 * Created by WetABQ(Administrator) on 2017/10/8.
 * |||    ||    ||||                           ||        ||||||||     |||||||
 * |||   |||    |||               ||         ||  |      |||     ||   |||    |||
 * |||   |||    ||     ||||||  ||||||||     ||   ||      ||  ||||   |||      ||
 * ||  |||||   ||   |||   ||  ||||        ||| |||||     ||||||||   |        ||
 * ||  || ||  ||    ||  ||      |        |||||||| ||    ||     ||| ||      ||
 * ||||   ||||     ||    ||    ||  ||  |||       |||  ||||   |||   ||||||||
 * ||     |||      |||||||     |||||  |||       |||| ||||||||      |||||    |
 * ||||
 */
public class PlayerCheating extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    AntiCheat.CheatType cheatType;

    public PlayerCheating(Player player, AntiCheat.CheatType cheatType) {
        this.player = player;
        this.cheatType = cheatType;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    public AntiCheat.CheatType getCheatType() {
        return cheatType;
    }

}
