package org.example.lab_6;

import org.example.lab_6.exceptions.InvalidCinemaParameters;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CinemaTest {
    private final Cinema cinema1 = new Cinema(2, 3, 5);
    private final Cinema cinema2 = new Cinema(2, 3, 5);

    @Test
    void bookSeats_ShouldSuccessful() throws InvalidCinemaParameters {
        assertTrue(cinema1.bookSeats(0, 0, new int[]{1, 2, 3}));
        assertEquals(1, cinema1.cinema[0][0][1]);
        assertEquals(1, cinema1.cinema[0][0][2]);
        assertEquals(1, cinema1.cinema[0][0][3]);
    }

    @Test
    void bookSeats_ShouldThrow() {
        assertThrows(InvalidCinemaParameters.class,
                ()-> cinema1.bookSeats(3, 1, new int[]{1, 2, 3}));
        assertThrows(InvalidCinemaParameters.class,
                ()-> cinema1.bookSeats(0, 6, new int[]{1, 2, 3}));
        assertThrows(InvalidCinemaParameters.class,
                ()-> cinema1.bookSeats(0, 1, new int[]{4, 2, 8}));
    }

    @Test
    void cancelSeats_ShouldSuccessful() throws InvalidCinemaParameters {
        assertTrue(cinema1.cancelBooking(0, 0, new int[]{1, 2, 3}));
        assertEquals(0, cinema1.cinema[0][0][1]);
        assertEquals(0, cinema1.cinema[0][0][2]);
        assertEquals(0, cinema1.cinema[0][0][3]);
    }

    @Test
    void cancelBooking_ShouldThrow() {
        assertThrows(InvalidCinemaParameters.class,
                ()-> cinema1.cancelBooking(3, 1, new int[]{1, 2, 3}));
        assertThrows(InvalidCinemaParameters.class,
                ()-> cinema1.cancelBooking(0, 6, new int[]{1, 2, 3}));
        assertThrows(InvalidCinemaParameters.class,
                ()-> cinema1.cancelBooking(0, 1, new int[]{4, 2, 8}));
    }

    @Test
    void checkAvailability_ShouldSuccessful() throws InvalidCinemaParameters {
        assertTrue(cinema2.checkAvailability(1, 3));
        assertFalse(cinema2.checkAvailability(1, 5));
    }

    @Test
    void checkAvailability_ShouldThrow() {
        assertThrows(InvalidCinemaParameters.class,
                () -> cinema2.checkAvailability(3, 2));
        assertThrows(InvalidCinemaParameters.class,
                () -> cinema2.checkAvailability(1, 6));
    }

    @Test
    void findBestAvailable() throws InvalidCinemaParameters {
        cinema2.bookSeats(1, 0, new int[]{1, 2, 3});

        Optional<Cinema.RowAndSeats> result = cinema2.findBestAvailable(1, 2);

        assertTrue(result.isPresent());
        assertEquals(1, result.get().getRow());
        assertArrayEquals(new int[]{1, 2}, result.get().getSeats());

        cinema2.bookSeats(1, 1, new int[]{0, 1, 2});

        result = cinema2.findBestAvailable(1, 3);

        assertTrue(result.isPresent());
        assertEquals(2, result.get().getRow());
        assertArrayEquals(new int[]{1, 2, 3}, result.get().getSeats());

        cinema2.bookSeats(1, 0, new int[]{1, 2, 3, 4});
        cinema2.bookSeats(1, 1, new int[]{1, 2, 3, 4});
        cinema2.bookSeats(1, 2, new int[]{1, 2, 3, 4});

        result = cinema2.findBestAvailable(1, 5);

        assertFalse(result.isPresent());
    }

    @Test
    void autoBook() throws InvalidCinemaParameters {
        assertTrue(cinema2.autoBook(1, 2));
        assertThrows(InvalidCinemaParameters.class,() -> cinema2.autoBook(0, 6));
        assertThrows(InvalidCinemaParameters.class,() -> cinema2.autoBook(3, 2));
    }
}