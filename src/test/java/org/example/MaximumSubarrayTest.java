package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSubarrayTest {

    @Test
    void findMaxSubarray() {

        // given
        int[] arr = {-2, 3, -5, 2, 2, -1, 4, -3};

        // when
        final var result = MaximumSubarray.findMaxSubarray(arr);

        // then
        assertEquals(7, result);
    }
}