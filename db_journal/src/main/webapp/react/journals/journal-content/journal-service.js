const JOURNAL_URL = "http://localhost:8080/api/journals"
// needs to finish
const ARTICLE_URL = "http://localhost:8080/api/..."

export const findAllJournals = () =>
    fetch(JOURNAL_URL)
        .then(response => response.json())

export const findJournalById = (id) =>
    fetch(`${JOURNAL_URL}/${id}`)
        .then(response => response.json())

<<<<<<< HEAD
=======
export const findArticleByJournalId = (id) =>
    fetch(`${JOURNAL_URL}/${id}/articles`)
        .then(response => response.json())

>>>>>>> main
export const deleteJournal = (id) =>
    fetch(`${JOURNAL_URL}/${id}`, {
        method: "DELETE"
    })

export const createJournal = (journal) =>
    fetch(JOURNAL_URL, {
        method: 'POST',
        body: JSON.stringify(journal),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

export const updateJournal = (id, journal) =>
    fetch(`${JOURNAL_URL}/${id}`, {
        method: 'PUT',
        body: JSON.stringify(journal),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

export const findArticlesByJournalId = (id) =>
    fetch(ARTICLE_URL)
        .then(response => response.json())

export default {
    findAllJournals,
    findJournalById,
    deleteJournal,
    createJournal,
    updateJournal,
<<<<<<< HEAD
    findArticlesByJournalId
=======
    findArticleByJournalId
>>>>>>> main
}
