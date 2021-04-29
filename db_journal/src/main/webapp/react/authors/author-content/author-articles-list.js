const {Link, useHistory, useParams} = window.ReactRouterDOM;

import authorService from "./author-service"
const { useState, useEffect } = React;
const ArticlesList = () => {
    const {id} = useParams()
    const [articles, setArticles] = useState([])
    useEffect(() => {
        findArticlesByAuthorId()
    }, [])
    const findArticlesByAuthorId = () =>
        authorService.findArticlesByAuthorId(id)
            .then(articles => setArticles(articles))
    return(
        <div>
            <h2>Articles List for This Author</h2>
            <ul className="list-group">
                {
                    articles.map(article =>
                        <li className="btn" key={article.id}>
                            <a className="btn btn-light btn-block" href={`../articles/article.html#/articles/${article.id}`}>
                                {article.title}
                            </a>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default ArticlesList;
