

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The HumanTest class contains JUnit tests for the Human creature.
 * It verifies that Humans start alive, take damage correctly,
 * and generate attack damage within the allowed range.
 *
 * @author Garry Ovide
 * @version 2026-11-17
 */
public class HumanTest
{
    /**
     * Default constructor for test class HumanTest
     */
    public HumanTest()
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
     * Test that a newly created Human is alive
     * and has not been knocked out.
     */
    @Test
    public void testHumanStartsAlive()
    {
        // Create a Human with randomly generated strength and health.
        Human human1 = new Human();

        // Verify that the Human starts alive.
        assertTrue(human1.isAlive());

        // Verify that the Human has not been knocked out.
        assertFalse(human1.isKnockedOut());
    }
    
    /**
     * Test that a Human becomes knocked out after
     * receiving more damage than its maximum possible health.
     */
    @Test
    public void testHumanTakesDamage()
    {
        // Create a Human with randomly generated health.
        Human human1 = new Human();

        // Inflict 30 damage, exceeding the Human's maximum of 25 HP.
        human1.takeDamage(30);

        // Verify that the Human is no longer alive.
        assertFalse(human1.isAlive());

        // Verify that the Human has been knocked out.
        assertTrue(human1.isKnockedOut());
    }
    
    /**
     * Test that a Human's attack generates damage
     * within the allowed range of 1 to 20.
     */
    @Test
    public void testHumanAttack()
    {
        // Create a Human with randomly generated strength.
        Human human1 = new Human();

        // Repeat the attack test 100 times.
        for (int i = 0; i < 100; i++)
        {
            // Generate an attack damage value.
            int damage = human1.attack();

            // Verify that damage is at least 1.
            assertTrue(damage >= 1);

            // Verify that damage does not exceed the
            // maximum possible Human strength of 20.
            assertTrue(damage <= 20);
        }
    }
}