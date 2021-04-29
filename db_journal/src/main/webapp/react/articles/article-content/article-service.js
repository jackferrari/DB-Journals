const ARTICLES_URL = "http://localhost:8080/api/articles"

export const findAllArticles = () =>
    fetch(ARTICLES_URL)
        .then(response => response.json())

export const findArticleById = (id) =>
    fetch(`${ARTICLES_URL}/${id}`)
        .then(response => response.json())

export const findAuthorByArticleId = (id) =>
    fetch(`${ARTICLES_URL}/${id}/authors`)
        .then(response => response.json())

export const findEditorByArticleId = (id) =>
    fetch(`${ARTICLES_URL}/${id}/editors`)
        .then(response => response.json())

export const findJournalByArticleId = (id) =>
    fetch(`${ARTICLES_URL}/${id}/journals`)
        .then(response => response.json())

export const deleteArticle = (id) =>
    fetch(`${ARTICLES_URL}/${id}`, {
        method: "DELETE"
    })

export const createArticle = (article) =>
    fetch(ARTICLES_URL, {
        method: 'POST',
        body: JSON.stringify(article),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

export const updateArticle = (id, article) =>
    fetch(`${ARTICLES_URL}/${id}`, {
        method: 'PUT',
        body: JSON.stringify(article),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

export default {
    findAllArticles,
    findArticleById,
    deleteArticle,
    createArticle,
    updateArticle,
    findAuthorByArticleId,
    findEditorByArticleId,
    findJournalByArticleId
}
