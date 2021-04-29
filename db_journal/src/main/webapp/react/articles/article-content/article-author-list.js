const {Link,useHistory, useParams} = window.ReactRouterDOM;
import articleService from "./article-service"
const { useState, useEffect } = React;
const ArticleAuthorList = () => {
    const history = useHistory()
    const {id} = useParams()
    const [authors, setAuthors] = useState([])
    useEffect(() => {
            findAuthorByArticleId()
    }, []);
    const findAuthorByArticleId = () =>
        articleService.findAuthorByArticleId(id)
            .then(authors => setAuthors(authors))
    return(
        <div>
            <h2>Author List</h2>
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

export default ArticleAuthorList;
