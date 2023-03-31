package MonsterFactory;

import Monster.Gobelin.Gobelin;
import Monster.Harpy.Harpy;
import Monster.Monster;
import Monster.Troll.Troll;
import Monster.Zombie.Zombie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MonsterFactory {

    public static Monster generateMonster() {
        ArrayList<Monster> array = new ArrayList<>();
        array.addAll(Arrays.asList(new Zombie(), new Harpy(), new Gobelin(), new Troll()));
        Random rand = new Random();
        int index = rand.nextInt(array.size());
        return array.get(index);
    }
}
