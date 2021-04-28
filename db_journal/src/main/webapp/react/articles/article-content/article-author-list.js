const {Link,useHistory} = window.ReactRouterDOM;
import articleService from "./article-service"
const { useState, useEffect } = React;
const AuthorList = () => {
    const {id} = useParams()
    const [authors, setAuthors] = useState([])
    useEffect(() => {
        if(id !== "new") {
            articleService.findAuthorByArticleId(id)
        }
    }, [])
    return(
        <div>
            <h2>Author of The Article</h2>
            <ul className="list-group">
                {
                    authors.map(author =>
                        <li className="btn" key={authors.id}>
                            <Link className="btn btn-light btn-block" to={`/articles/${article.id}/authors`}>
                                {author.primaryTopic}
                            </Link>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default AuthorList;
