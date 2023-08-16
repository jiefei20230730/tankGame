package com.example.tankegame.game5.util;

import com.example.tankegame.game5.Tank;

import java.io.Serializable;

/**
 * @author wza
 * @version 1.0.0
 */
public class TankUtils implements Serializable {
    public static boolean isInnerTank(int x, int y, Tank tank) {
        if (tank == null) {
            return false;
        }
        switch (tank.getDirect()) {
            case 0:
            case 2:
                if (x >= tank.getX() - 20 && x <= tank.getX() + 20 && y >= tank.getY() - 30 && y <= tank.getY() + 30) {
                    return true;
                }
                break;
            case 1:
            case 3:
                if (x >= tank.getX() - 30 && x <= tank.getX() + 30 && y >= tank.getY() - 20 && y <= tank.getY() + 20) {
                    return true;
                }
                break;
            default:

        }
        return false;
    }
}
