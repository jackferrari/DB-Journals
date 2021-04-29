const {Link,useHistory, useParams} = window.ReactRouterDOM;

import journalService from "./journal-service"
const { useState, useEffect } = React;
const ArticleList = () => {
    const {id} = useParams()
    const [articles, setArticles] = useState([])
    useEffect(() => {
        findArticleByJournalId()
    }, [])
    const findArticleByJournalId = () =>
        journalService.findArticleByJournalId(id)
            .then(articles => setArticles(articles))
    console.log(articles)
    return(
        <div>
            <h2>Articles List for This Journal</h2>
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

export default ArticleList;
