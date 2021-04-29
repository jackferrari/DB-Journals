const {Link,useHistory} = window.ReactRouterDOM;

import editorService from "./editor-service"
const { useState, useEffect } = React;
const ArticlesList = () => {
    const {id} = useParams()
    const [articles, setArticles] = useState([])
    useEffect(() => {
        findArticlesByEditorId()
    }, [])
    const findArticlesByEditorId = () =>
        editorService.findArticlesByEditorId(id)
            .then(articles => setArticles(articles))
    return(
        <div>
            <h2>Articles List for This Editor</h2>
            <ul className="list-group">
                {
                    articles.map(article =>
                        <li className="btn" key={articles.id}>
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
