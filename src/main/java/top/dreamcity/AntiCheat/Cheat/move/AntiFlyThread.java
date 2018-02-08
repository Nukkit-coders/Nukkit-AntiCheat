package top.dreamcity.AntiCheat.Cheat.move;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.math.Vector3;
import cn.nukkit.scheduler.Task;

import java.util.HashMap;

import static cn.nukkit.utils.TextFormat.AQUA;
import static cn.nukkit.utils.TextFormat.RED;

/**
 * Copyright © 2016 WetABQ&DreamCityAdminGroup All right reserved.
 * Welcome to DreamCity Server Address:dreamcity.top:19132
 * Created by WetABQ(Administrator) on 2017/11/17.
 * |||    ||    ||||                           ||        ||||||||     |||||||
 * |||   |||    |||               ||         ||  |      |||     ||   |||    |||
 * |||   |||    ||     ||||||  ||||||||     ||   ||      ||  ||||   |||      ||
 * ||  |||||   ||   |||   ||  ||||        ||| |||||     ||||||||   |        ||
 * ||  || ||  ||    ||  ||      |        |||||||| ||    ||     ||| ||      ||
 * ||||   ||||     ||    ||    ||  ||  |||       |||  ||||   |||   ||||||||
 * ||     |||      |||||||     |||||  |||       |||| ||||||||      |||||    |
 * ||||
 */
public class AntiFlyThread extends Task {

    private HashMap<String, Integer> Flycount = new HashMap<>();

    @Override
    public void onRun(int i) {
        try {
            for (Player player : Server.getInstance().getOnlinePlayers().values()) {
                if (!player.isOnGround()) {
                    double y = player.y;
                    boolean flag = false;
                    if (player.y == y) {
                        flag = true;
                    }
                    if (player.y >= y) {
                        y = player.y;
                        if (player.move(0, -3, 0)) {
                            if (player.move(0, -3, 0)) {
                                if (player.y + 6 == y) {
                                    flag = true;
                                }
                            }
                        }
                    }
                    if (flag) {
                        player.setMotion(new Vector3(0, 0, 0));
                        player.teleport(player);
                        if (Flycount.containsKey(player.getName())) {
                            if (Flycount.get(player.getName()) > 5) {
                                player.kick(AQUA + "Cheat Type: " + RED + "Fly");
                            }
                            Flycount.put(player.getName(), Flycount.get(player.getName()) + 1);
                        } else {
                            Flycount.put(player.getName(), 1);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
