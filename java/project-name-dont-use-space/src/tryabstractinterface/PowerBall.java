public enum PowerBall {

    // List<PowerBall> powerBalls; add to gameCharacter
    FIREBALL, //
    WATERBALL, //
    WINDBALL, //
    ;




    public static void healPool(GameCharacter gameCharacter) {
        gameCharacter.hp += 200;
        if(gameCharacter.hp>??)
        ??
    }

    public static void fireTrap(GameCharacter gameCharacter) {
        gameCharacter.hp -= 200;
        if (gameCharacter.hp <= 0)
            gameCharacter.die();
    }

    public static void endGame(Game game) {
        if(game.gameMode == RUNRACING)
        return runWin(game);
        if(game.gameMode == KILLTHEBOSS)
        return killWin(game);
        if(game.gameMode == FIGHTING5V5)
        return fightWin(game);
    }

public static runRank(){

}

public static runWin(){

}

}


public class EarthBoy extends GameCharacter {
    public EarthBoy() {
        super.hp = 1300;
    }


    
}
