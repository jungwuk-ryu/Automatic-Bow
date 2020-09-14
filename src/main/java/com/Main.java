package com;

import cn.nukkit.plugin.PluginBase;

public class Main extends PluginBase {

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new Interact(),this);
        getServer().getCommandMap().register("getautomatic",new GetBowCommand("getautomatic","Get an automatic bow","/getautomatic"));

        super.onEnable();
    }
    @Override
    public void onDisable() {
        super.onDisable();
    }
}
