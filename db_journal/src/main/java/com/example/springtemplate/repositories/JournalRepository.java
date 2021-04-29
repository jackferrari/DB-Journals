package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Journal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JournalRepository
        extends CrudRepository<Journal, Integer> {
    @Query(value = "SELECT * FROM journals",
            nativeQuery = true)
    public List<Journal> findAllJournals();

    @Query(value = "SELECT * FROM journals WHERE id=:journalId",
            nativeQuery = true)
    public Journal findJournalById(@Param("journalId") Integer id);

    @Query (value = "select * from journals, ( Select journal from articles where id =:articleId) " +
            "as wanted_journal where journals.id = wanted_journal.journal",
            nativeQuery = true)
    public Journal findJournalByArticleId(@Param("articleId") Integer id);
}
