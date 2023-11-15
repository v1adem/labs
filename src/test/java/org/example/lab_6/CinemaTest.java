package org.example.lab_6;

import org.example.lab_6.exceptions.InvalidCinemaParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CinemaTest {
    private Cinema cinema;
    @BeforeEach
    public void init(){
        cinema = new Cinema(2, 3, 5);
    }
    @Test
    void bookAndCancelSeats() throws InvalidCinemaParameters {
        assertTrue(cinema.bookSeats(0, 0, new int[]{1, 2, 3}));
        assertEquals(1, cinema.cinema[0][0][1]);
        assertEquals(1, cinema.cinema[0][0][2]);
        assertEquals(1, cinema.cinema[0][0][3]);

        assertTrue(cinema.cancelBooking(0, 0, new int[]{1, 2, 3}));
        assertEquals(0, cinema.cinema[0][0][1]);
        assertEquals(0, cinema.cinema[0][0][2]);
        assertEquals(0, cinema.cinema[0][0][3]);
    }

    @Test
    void checkAvailability() throws InvalidCinemaParameters {
        assertTrue(cinema.checkAvailability(1, 3));
        assertFalse(cinema.checkAvailability(1, 5));

        assertThrows(InvalidCinemaParameters.class, () -> cinema.checkAvailability(3, 2));
        assertThrows(InvalidCinemaParameters.class, () -> cinema.checkAvailability(1, 6));
    }

    @Test
    void findBestAvailable() throws InvalidCinemaParameters {
        cinema.bookSeats(1, 0, new int[]{1, 2, 3});

        Optional<Cinema.RowAndSeats> result = cinema.findBestAvailable(1, 2);

        assertTrue(result.isPresent());
        assertEquals(1, result.get().getRow());
        assertArrayEquals(new int[]{1, 2}, result.get().getSeats());

        cinema.bookSeats(1, 1, new int[]{0, 1, 2});

        result = cinema.findBestAvailable(1, 3);

        assertTrue(result.isPresent());
        assertEquals(2, result.get().getRow());
        assertArrayEquals(new int[]{1, 2, 3}, result.get().getSeats());

        cinema.bookSeats(1, 0, new int[]{1, 2, 3, 4});
        cinema.bookSeats(1, 1, new int[]{1, 2, 3, 4});
        cinema.bookSeats(1, 2, new int[]{1, 2, 3, 4});

        result = cinema.findBestAvailable(1, 5);

        assertFalse(result.isPresent());
    }

    @Test
    void autoBook() throws InvalidCinemaParameters {
        assertTrue(cinema.autoBook(1, 2));
        assertThrows(InvalidCinemaParameters.class,() -> cinema.autoBook(0, 6));
        assertThrows(InvalidCinemaParameters.class,() -> cinema.autoBook(3, 2));
    }
}