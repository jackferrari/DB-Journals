const {useParams} = window.ReactRouterDOM;
import userService from "./user-service"
const { useState, useEffect } = React;
const AuthorsList = () => {
    const {id} = useParams()
    const [authors, setAuthors] = useState([])
    useEffect(() => {
        findAuthorsByUserId()
    }, [])
    const findAuthorsByUserId = () =>
        userService.findAuthorsByUserId(id)
            .then(authors => setAuthors(authors))
    return(
        <div>
            <h2>Authors List for User</h2>
            <ul className="list-group">
                {
                    authors.map(author =>
                        <li className="btn" key={author.id}>
                            <a className="btn btn-light btn-block" href={`../authors/author.html#/authors/${author.id}`}>
                                {author.topic}
                            </a>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default AuthorsList;
