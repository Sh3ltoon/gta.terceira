package org.academiadecodigo.apiores.carcrashteam.assault;

import org.academiadecodigo.apiores.carcrashteam.Player;

public interface Assault {

    void successRate(Player player);

    double weaponsRate();

    void execute(Player player);
}
