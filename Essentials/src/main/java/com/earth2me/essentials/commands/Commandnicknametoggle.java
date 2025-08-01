package com.earth2me.essentials.commands;

import com.earth2me.essentials.User;
import org.bukkit.Server;

public class Commandnicknametoggle extends EssentialsCommand {

    public Commandnicknametoggle() {
        super("nicknametoggle");
    }

    @Override
    public void run(final Server server, final User user, final String commandLabel, final String[] args) throws Exception {
        boolean confirmingNick = !user.isPromptingNickConfirm();
        if (commandLabel.toLowerCase().endsWith("on")) {
            confirmingNick = true;
        } else if (commandLabel.toLowerCase().endsWith("off")) {
            confirmingNick = false;
        }
        user.setPromptingNickConfirm(confirmingNick);
        if (confirmingNick) {
            user.sendTl("nicknameToggleOn");
        } else {
            user.sendTl("nicknameToggleOff");
        }
        user.setConfirmingNickCommand(null);
    }

}
