

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The BalrogTest class contains JUnit tests for the Balrog creature.
 * It verifies that Balrogs start alive, take damage correctly,
 * and generate double-attack damage within the allowed range,
 * including their magical attack bonuses.
 *
 * @author Garry Ovide
 * @version 2026-11-17
 */
public class BalrogTest
{
    /**
     * Default constructor for test class BalrogTest
     */
    public BalrogTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    /**
     * Test that a newly created Balrog is alive
     * and has not been knocked out.
     */
    @Test
    public void testBalrogStartsAlive()
    {
        // Create a Balrog with randomly generated strength and health.
        Balrog balrog1 = new Balrog();

        // Verify that the Balrog starts alive.
        assertTrue(balrog1.isAlive());

        // Verify that the Balrog has not been knocked out.
        assertFalse(balrog1.isKnockedOut());
    }
    
    /**
     * Test that a Balrog becomes knocked out after receiving
     * more damage than its maximum possible hit points.
     */
    @Test
    public void testBalrogTakesDamage()
    {
        // Create a Balrog with randomly generated hit points.
        Balrog balrog1 = new Balrog();

        // Inflict 210 damage, exceeding the Balrog's maximum of 200 HP.
        balrog1.takeDamage(210);

        // Verify that the Balrog is no longer alive.
        assertFalse(balrog1.isAlive());

        // Verify that the Balrog has been knocked out.
        assertTrue(balrog1.isKnockedOut());
    }
    
    /**
     * Test that a Balrog's double attack generates damage
     * within the allowed range, including magical bonuses.
     */
    @Test
    public void testBalrogDoubleAttack()
    {
        // Create a Balrog with randomly generated strength.
        Balrog balrog1 = new Balrog();

        // Repeat the double-attack test 100 times.
        for (int i = 0; i < 100; i++)
        {
            // Generate the combined damage from two attacks.
            int damage = balrog1.attack();

            // Each attack causes at least 1 damage.
            // Therefore, two attacks must cause at least 2 damage.
            assertTrue(damage >= 2);

            // Each attack can cause up to 150 damage.
            // Therefore, the maximum combined damage is 300.
            assertTrue(damage <= 300);
        }
    }
}