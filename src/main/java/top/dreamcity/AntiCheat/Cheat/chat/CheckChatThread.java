package top.dreamcity.AntiCheat.Cheat.chat;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.scheduler.Task;
import top.dreamcity.AntiCheat.AntiCheatAPI;

import java.util.HashMap;

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
public class CheckChatThread extends Task {

    private static HashMap<String, Integer> playerChat = new HashMap<>();

    public static void addPlayer(String name) {
        playerChat.put(name, AntiCheatAPI.getInstance().getMasterConfig().getChatSec());
    }

    public static boolean hasPlayer(String name) {
        return playerChat.containsKey(name);
    }

    @Override
    public void onRun(int i) {
        try {
            for (Player player : Server.getInstance().getOnlinePlayers().values()) {
                if (playerChat.containsKey(player.getName())) {
                    if (playerChat.get(player.getName()) > 0) {
                        playerChat.put(player.getName(), playerChat.get(player.getName()) - 1);
                    } else {
                        playerChat.remove(player.getName());
                    }
                }
            }
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
