package com.rasysbox.controller;

import com.rasysbox.entity.Movie;
import com.rasysbox.repository.MovieRepository;
import com.rasysbox.error.MovieNotFoundException;
import com.rasysbox.error.MovieUnSupportedFieldPatchException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Validated
@RequestMapping("${controller.properties.base-path}")
public class MovieController {

    @Autowired
    private MovieRepository repository;

    /**
     * ALL MOVIES.
     * @return List of Movies.
     */
    @GetMapping("/movies")
    List<Movie> findAll() {
        return repository.findAll();
    }

    /**
     * CREATE NEW MOVIE.
     * @param newMovie
     * @return Movie
     */
    @PostMapping("/movies")
    @ResponseStatus(HttpStatus.CREATED)
    Movie newMovie(
            @Valid @RequestBody Movie newMovie) {
        return repository.save(newMovie);
    }

    /**
     * FIND MOVIE.
     * @param id
     * @return Movie.
     */
    @GetMapping("/movies/{id}")
    Movie findOne(
            @PathVariable @Min(1) Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    /**
     * CREATE OR UPDATE MOVIE.
     * @param newMovie
     * @param id
     * @return Movie.
     */
    @PutMapping("/movies/{id}")
    Movie saveOrUpdate(
            @RequestBody Movie newMovie,
            @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {
                    x.setName(newMovie.getName());
                    x.setAuthor(newMovie.getAuthor());
                    x.setScore(newMovie.getScore());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newMovie.setId(id);
                    return repository.save(newMovie);
                });
    }

    /**
     * UPDATE AUTHOR MOVIE.
     * @param update
     * @param id
     * @return Movie.
     */
    @PatchMapping("/movies/{id}")
    Movie patch(
            @RequestBody Map<String, String> update,
            @PathVariable Long id) {
        return repository.findById(id)
                .map(x -> {
                    String author = update.get("author");
                    if (!StringUtils.isEmpty(author)) {
                        x.setAuthor(author);

                        // Create a custom method to update a value = :newValue where id = :id
                        return repository.save(x);
                    } else {
                        throw new MovieUnSupportedFieldPatchException(update.keySet());
                    }
                })
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    /**
     * DELETE MOVIE.
     * @param id
     * @return nothing.
     */
    @DeleteMapping("/movies/{id}")
    void deleteMovie(
            @PathVariable Long id) {
        repository.deleteById(id);
    }

}
