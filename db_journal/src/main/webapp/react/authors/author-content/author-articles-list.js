const {Link,useHistory} = window.ReactRouterDOM;

import articleService from "./article-service"
const { useState, useEffect } = React;
const ArticlesList = () => {
    const [articles, setArticles] = useState([])
    useEffect(() => {
        findAllArticles()
    }, [])
    const findAllArticles = () =>
        articleService.findAllArticles()
            .then(articles => setArticles(articles))
    return(
        <div>
            <h2>Articles List for This Author</h2>
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
