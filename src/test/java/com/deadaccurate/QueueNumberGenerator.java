package com.deadaccurate;

import java.util.LinkedList;
import java.util.Queue;

/**
 * QueueNumberGenerator is a predictable NumberGenerator. This allows me to mock the SecureRandom generator and control
 * the numbers generated to shuffle the deck of cards.
 */
public class QueueNumberGenerator implements NumberGenerator {
    private Queue<Integer> numbers;

    /**
     * Constructor allows the caller to specify the specific order of numbers to generate using a queue.
     * @param numbers is a queue containing numbers to generate and remove.
     */
    public QueueNumberGenerator(Queue<Integer> numbers) {
        this.numbers = numbers;
    }

    /**
     * Default initialization that causes nextInt to always return 0.
     */
    public QueueNumberGenerator() {
        numbers = new LinkedList<>();
    }

    /**
     * This generator returns the next integer from the initialized queue.
     *
     * @param bound is only used if the queue is empty, in which case it will return bound - 1.
     * @return the next number from the generator. If the queue is empty it returns bound - 1.
     */
    @Override
    public int nextInt(int bound) {
        if (!numbers.isEmpty()) {
            return numbers.remove();
        }
        return bound - 1;
    }
}
