package com;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.item.ItemBow;
import cn.nukkit.item.ItemID;
import cn.nukkit.nbt.tag.CompoundTag;

public class Interact implements Listener {

    @EventHandler
    public void interact(final PlayerInteractEvent e) {

        if (!e.getPlayer().isCreative()) {
            if(e.getItem() == null) return;
            if (e.getItem().getId() == ItemID.BOW) {
                ItemBow i = (ItemBow) e.getItem();

                CompoundTag nameTag = i.getNamedTag();
                if(nameTag == null || !nameTag.contains("autoBow")) return;

                i.onRelease(e.getPlayer(), 20);
            }
        }
    }
}
