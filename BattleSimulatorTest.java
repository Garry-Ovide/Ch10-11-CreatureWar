import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Test class for the BattleSimulator.
 *
 * These tests verify army creation, simultaneous combat,
 * and the completion of the battle simulation.
 *
 * @author Garry Ovide
 * @version 2026-11-15
 */
public class BattleSimulatorTest
{
    /**
     * Test that the Good Army contains exactly 100 creatures.
     */
    @Test
    public void testPopulateGoodArmy()
    {
        // Create a new BattleSimulator object.
        BattleSimulator battle = new BattleSimulator();

        // Populate the Good Army.
        battle.populateGoodArmy();

        // Verify that the Good Army contains 100 creatures.
        assertEquals(100, battle.getGoodArmySize());
    }

    /**
     * Test that the Evil Army contains exactly 40 creatures.
     */
    @Test
    public void testPopulateEvilArmy()
    {
        // Create a new BattleSimulator object.
        BattleSimulator battle = new BattleSimulator();

        // Populate the Evil Army.
        battle.populateEvilArmy();

        // Verify that the Evil Army contains 40 creatures.
        assertEquals(40, battle.getEvilArmySize());
    }

   /**
     * Test that both creatures receive damage during combat.
     */
    @Test
    public void testFightRound()
    {
        // Create a BattleSimulator object.
        BattleSimulator battle = new BattleSimulator();

        // Create two Human creatures for combat.
        Human goodCreature = new Human();
        Human evilCreature = new Human();

        // Both creatures should initially be alive.
        assertTrue(goodCreature.isAlive());
        assertTrue(evilCreature.isAlive());

        // Apply enough rounds of combat to defeat both creatures.
        // Both creatures attack simultaneously during each round.
        for (int i = 0; i < 30; i++)
        {
            battle.fightRound(goodCreature, evilCreature);
        }

        // Verify that both creatures received enough damage
        // to become knocked out.
        assertTrue(goodCreature.isKnockedOut());
        assertTrue(evilCreature.isKnockedOut());
    }

    /**
     * Test that the battle simulation finishes
     * with at least one army eliminated.
     */
    @Test
    public void testStartBattle()
    {
        // Create a new BattleSimulator object.
        BattleSimulator battle = new BattleSimulator();

        // Run the complete battle simulation.
        battle.startBattle();

        // Verify that at least one army has no survivors.
        assertTrue(
            battle.getGoodArmySize() == 0 ||
            battle.getEvilArmySize() == 0
        );
    }
}