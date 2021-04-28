const USERS_URL = "http://localhost:8080/api/users"
// Needs to complete
const EDITORS_URL = "http://localhost:8080/api/..."
const AUTHORS_URL = "http://localhost:8080/api/..."

export const findAllUsers = () =>
    fetch(USERS_URL)
        .then(response => response.json())

export const findUserById = (id) =>
    fetch(`${USERS_URL}/${id}`)
        .then(response => response.json())

export const findAuthorsByUserId = (id) =>
fetch(`${USERS_URL}/${id}/authors`)
    .then(response => response.json())

export const findEditorsByUserId = (id) =>
    fetch(`${USERS_URL}/${id}/editors`)
        .then(response => response.json())

export const deleteUser = (id) =>
    fetch(`${USERS_URL}/${id}`, {
        method: "DELETE"
    })

export const createUser = (user) =>
    fetch(USERS_URL, {
        method: 'POST',
        body: JSON.stringify(user),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

export const updateUser = (id, user) =>
    fetch(`${USERS_URL}/${id}`, {
        method: 'PUT',
        body: JSON.stringify(user),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

export const findEditorsByUserId = (id) =>
    fetch(`${EDITORS_URL}/${id}`)
        .then(response => response.json())

export const findAuthorsByUserId = (id) =>
fetch(`${AUTHORS_URL}/${id}`)
    .then(response => response.json())

export default {
    findAllUsers,
    findUserById,
    deleteUser,
    createUser,
    updateUser,
<<<<<<< HEAD
    findEditorsByUserId,
    findAuthorsByUserId
=======
    findAuthorsByUserId,
    findEditorsByUserId
>>>>>>> main
}
