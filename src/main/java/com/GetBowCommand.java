package com;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemBow;
import cn.nukkit.item.ItemID;
import cn.nukkit.nbt.tag.CompoundTag;

public class GetBowCommand extends Command {
    public GetBowCommand(String name, String description, String usageMessage) {
        super(name, description, usageMessage);
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {

        if(commandSender.isOp()){
            Player player;
            try {
                player = (Player) commandSender;
            }catch(ClassCastException e){
                commandSender.sendMessage("Ingame only");
                return true;
            }
            ItemBow bow = (ItemBow) Item.get(ItemID.BOW);
            CompoundTag nameTag = new CompoundTag();

            nameTag.putBoolean("autoBow", true);
            bow.setNamedTag(nameTag);
            player.getInventory().addItem(bow);
        }
        return false;
    }
}
