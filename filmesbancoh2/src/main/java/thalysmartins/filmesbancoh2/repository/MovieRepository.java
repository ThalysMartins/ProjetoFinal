package thalysmartins.filmesbancoh2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thalysmartins.filmesbancoh2.model.MovieEntity;

/**
 * @Author Thalys Figueira Martins
 * @Since 24/04/2020
 * @version 1.0
 */

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity, Long> {
    }


