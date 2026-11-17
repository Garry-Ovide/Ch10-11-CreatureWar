import java.util.ArrayList;

/**
 * The BattleSimulator class manages a battle between
 * two armies of creatures.
 *
 * The Good Army contains Humans and Elves.
 * The Evil Army contains Humans, CyberDemons, and Balrogs.
 *
 * This class uses ArrayList and polymorphism to
 * manage different types of creatures.
 *
 * @author Garry Ovide
 * @version 2026-11-15
 */
public class BattleSimulator
{
    // Store the creatures fighting for the Good Army.
    private ArrayList<Creature> goodArmy;

    // Store the creatures fighting for the Evil Army.
    private ArrayList<Creature> evilArmy;

    /**
     * Constructor for objects of class BattleSimulator.
     * Initializes both armies as empty collections.
     */
    public BattleSimulator()
    {
        // Create an empty collection for the Good Army.
        goodArmy = new ArrayList<>();

        // Create an empty collection for the Evil Army.
        evilArmy = new ArrayList<>();
    }

    /**
     * Populate the Good Army with 100 randomly selected creatures.
     * The army consists of approximately 60% Humans and 40% Elves.
     */
    public void populateGoodArmy()
    {
        // Remove existing creatures before creating a new army.
        goodArmy.clear();

        // Create 100 creatures for the Good Army.
        for (int i = 0; i < 100; i++)
        {
            // Generate a random number between 1 and 10.
            int creatureType = Randomizer.nextInt(10);

            // Numbers 1 through 6 select a Human.
            if (creatureType <= 6)
            {
                goodArmy.add(new Human());
            }
            else
            {
                // Numbers 7 through 10 select an Elf.
                goodArmy.add(new Elf());
            }
        }
    }

    /**
     * Populate the Evil Army with 40 randomly selected creatures.
     * The army consists of Humans, CyberDemons, and Balrogs.
     */
    public void populateEvilArmy()
    {
        // Remove existing creatures before creating a new army.
        evilArmy.clear();

        // Create 40 creatures for the Evil Army.
        for (int i = 0; i < 40; i++)
        {
            // Generate a random number between 1 and 25.
            int creatureType = Randomizer.nextInt(25);

            // Numbers 1 through 18 select a Human.
            if (creatureType <= 18)
            {
                evilArmy.add(new Human());
            }
            // Numbers 19 through 24 select a CyberDemon.
            else if (creatureType <= 24)
            {
                evilArmy.add(new CyberDemon());
            }
            else
            {
                // Number 25 selects a Balrog.
                evilArmy.add(new Balrog());
            }
        }
    }

    /**
     * Return the number of creatures in the Good Army.
     *
     * @return the number of Good Army creatures
     */
    public int getGoodArmySize()
    {
        // Return the number of creatures currently in the Good Army.
        return goodArmy.size();
    }

    /**
     * Return the number of creatures in the Evil Army.
     *
     * @return the number of Evil Army creatures
     */
    public int getEvilArmySize()
    {
        // Return the number of creatures currently in the Evil Army.
        return evilArmy.size();
    }

    /**
     * Simulate one round of combat between two creatures.
     * Both creatures attack simultaneously, allowing both
     * to cause damage even if one is knocked out.
     *
     * @param goodCreature the creature from the Good Army
     * @param evilCreature the creature from the Evil Army
     */
    public void fightRound(Creature goodCreature, Creature evilCreature)
    {
        // Calculate both attacks before applying any damage.
        int goodDamage = goodCreature.attack();
        int evilDamage = evilCreature.attack();

        // Apply the Evil creature's attack to the Good creature.
        goodCreature.takeDamage(evilDamage);

        // Apply the Good creature's attack to the Evil creature.
        evilCreature.takeDamage(goodDamage);
    }

    /**
     * Simulate a battle between the Good Army and the Evil Army.
     * Defeated creatures are removed from their armies.
     *
     * The battle continues until one or both armies are empty.
     */
    public void startBattle()
    {
        // Create both armies before starting the battle.
        populateGoodArmy();
        populateEvilArmy();

        // Display the starting number of creatures.
        System.out.println("=== CREATURE WAR ===");
        System.out.println("Good Army: " + goodArmy.size() + " creatures");
        System.out.println("Evil Army: " + evilArmy.size() + " creatures");
        System.out.println();

        // Continue fighting while both armies have creatures.
        while (!goodArmy.isEmpty() && !evilArmy.isEmpty())
        {
            // Select the first creature from each army.
            Creature goodCreature = goodArmy.get(0);
            Creature evilCreature = evilArmy.get(0);

            // Both creatures attack during the same round.
            fightRound(goodCreature, evilCreature);

            // Remove the Good creature if it was knocked out.
            if (goodCreature.isKnockedOut())
            {
                goodArmy.remove(0);
            }

            // Remove the Evil creature if it was knocked out.
            if (evilCreature.isKnockedOut())
            {
                evilArmy.remove(0);
            }
        }

        // Display the number of surviving creatures.
        System.out.println("=== BATTLE FINISHED ===");
        System.out.println("Good Army survivors: " + goodArmy.size());
        System.out.println("Evil Army survivors: " + evilArmy.size());

        // Determine which army won the battle.
        if (goodArmy.isEmpty() && evilArmy.isEmpty())
        {
            // Both armies lost their final creatures.
            System.out.println("The battle ended in a DRAW!");
        }
        else if (evilArmy.isEmpty())
        {
            // The Good Army still has surviving creatures.
            System.out.println("The GOOD ARMY wins!");
        }
        else
        {
            // The Evil Army still has surviving creatures.
            System.out.println("The EVIL ARMY wins!");
        }
    }
}