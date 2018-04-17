package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class FizzBuzzGameTest {
    private FizzBuzzGame game;

    @Before
    public void setup() {
        game = new FizzBuzzGame();
    }

    @Test
    public void should_return_Fizz_when_have_3() {
        List<String> expectedResults = Arrays.asList(
                "1", "2", "Fizz", "4"
        );
        game.start(4);
        List<String> results = game.getResults();
        assertThat(results, equalTo(expectedResults));
    }

    @Test
    public void test_theThirdAndFourthRule() {
        List<String> expectedResults = Arrays.asList(
                "1", "2", "Fizz", "4", "Buzz", "Fizz", "Whizz", "8", "Fizz", "Buzz",
                "11", "Fizz", "Fizz", "Whizz", "FizzBuzz", "16", "17", "Fizz", "19", "Buzz"
        );
        game.start(20);
        List<String> results = game.getResults();
        assertThat(results, equalTo(expectedResults));
    }
}
