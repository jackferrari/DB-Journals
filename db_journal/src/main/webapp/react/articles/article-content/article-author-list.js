const {Link,useHistory, useParams} = window.ReactRouterDOM;
import articleService from "./article-service"
const { useState, useEffect } = React;
const ArticleAuthorList = () => {
    const history = useHistory()
    const {id} = useParams()
    const [authors, setAuthors] = useState([])
    useEffect(() => {
        if(id !== "new") {
            findAuthorByArticleId(id)
        }
    }, []);
    const findAuthorByArticleId = (id) =>
        articleService.findAuthorByArticleId(id)
            .then(authors => setAuthors(authors))
    return(
        <div>
            <h2>Author List</h2>
            <ul className="list-group">
                {
                    authors.map(author =>
                        <li className="btn" key={author.id}>
                            <Link className="btn btn-light btn-block" to={`/articles/${author.id}/author`}>
                                {author.primaryTopic}
                            </Link>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default ArticleAuthorList;
