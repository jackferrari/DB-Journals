const {Link,useHistory} = window.ReactRouterDOM;

import articleService from "./article-service"
const { useState, useEffect } = React;
const ArticlesList = () => {
    const {id} = useParams()
    const [articles, setArticles] = useState([])
    useEffect(() => {
        findArticleByJournalId(id)
    }, [])
    const findArticleByJournalId = () =>
        articleService.findArticleByJournalId(id)
            .then(articles => setArticles(articles))
    return(
        <div>
            <h2>Articles List for This Journal</h2>
            <ul className="list-group">
                {
                    articles.map(article =>
                        <li className="btn" key={articles.id}>
                            <Link className="btn btn-light btn-block" to={`/articles/${article.id}`}>
                                {article.title}
                            </Link>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default ArticlesList;
