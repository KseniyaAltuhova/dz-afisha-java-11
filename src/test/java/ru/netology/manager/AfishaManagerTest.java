package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {
    Movie movie1 = new Movie(1, "Бладшот", "Боевик");
    Movie movie2 = new Movie(2, "Властелин колец", "Фэнтези");
    Movie movie3 = new Movie(3, "Джентельмены", "Боевик");
    Movie movie4 = new Movie(4, "Человек-невидимка", "Ужасы");
    Movie movie5 = new Movie(5, "Вперед", "Мультфильм");
    Movie movie6 = new Movie(6, "Мальчишник в Вегасе", "Комедия");
    Movie movie7 = new Movie(7, "Отель Белград", "Комедия");
    Movie movie8 = new Movie(8, "Номер один", "Комедия");
    Movie movie9 = new Movie(9, "Форест Гамп", "Драма");
    Movie movie10 = new Movie(10, "Титаник", "Драма");


    @Test
    void shouldAddOneMovie() {
        AfishaManager afishaManger = new AfishaManager();
        afishaManger.addMovie(movie1);
        Movie[] actual = afishaManger.findAll();
        Movie[] expected = new Movie[]{movie1};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldAddSeveralMovie() {
        Movie[] expected = new Movie[]{movie1, movie2, movie3};
        AfishaManager afishaManager = new AfishaManager();
        afishaManager.addMovie(movie1);
        afishaManager.addMovie(movie2);
        afishaManager.addMovie(movie3);
        Movie[] actual = afishaManager.findAll();
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldFindLastMoviesLessNumShow() {
        Movie[] expected = new Movie[]{movie4, movie3, movie2, movie1};
        AfishaManager afishaManager = new AfishaManager();
        afishaManager.addMovie(movie1);
        afishaManager.addMovie(movie2);
        afishaManager.addMovie(movie3);
        afishaManager.addMovie(movie4);
        Movie[] actual = afishaManager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastMoviesMoreNumShow() {
        Movie[] expected = new Movie[]{movie7, movie6, movie5, movie4, movie3};
        AfishaManager afishaManager = new AfishaManager(5);
        afishaManager.addMovie(movie2);
        afishaManager.addMovie(movie3);
        afishaManager.addMovie(movie4);
        afishaManager.addMovie(movie5);
        afishaManager.addMovie(movie6);
        afishaManager.addMovie(movie7);

        Movie[] actual = afishaManager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastMoviesLessNumShowDefault() {
        Movie[] expected = new Movie[]{movie4, movie3, movie2, movie1};
        AfishaManager afishaManager = new AfishaManager(5);
        afishaManager.addMovie(movie1);
        afishaManager.addMovie(movie2);
        afishaManager.addMovie(movie3);
        afishaManager.addMovie(movie4);
        Movie[] actual = afishaManager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastMovies() {
        Movie[] expected = new Movie[]{movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        AfishaManager afishaManager = new AfishaManager();
        afishaManager.addMovie(movie1);
        afishaManager.addMovie(movie2);
        afishaManager.addMovie(movie3);
        afishaManager.addMovie(movie4);
        afishaManager.addMovie(movie5);
        afishaManager.addMovie(movie6);
        afishaManager.addMovie(movie7);
        afishaManager.addMovie(movie8);
        afishaManager.addMovie(movie9);
        afishaManager.addMovie(movie10);

        Movie[] actual = afishaManager.findLast();
        assertArrayEquals(expected, actual);
    }

}