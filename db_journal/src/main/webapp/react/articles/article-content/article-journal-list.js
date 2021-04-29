const {Link,useHistory, useParams} = window.ReactRouterDOM;
import articleService from "./article-service"
const { useState, useEffect } = React;
const ArticleJournalList = () => {
    const history = useHistory()
    const {id} = useParams()
    const [journals, setJournals] = useState([])
    useEffect(() => {
        if(id !== "new") {
            findJournalByArticleId(id)
        }
    }, []);
    const findJournalByArticleId = (id) =>
        articleService.findJournalByArticleId(id)
            .then(journals => setJournals(journals))
    return(
        <div>
            <h2>Journal</h2>
            <ul className="list-group">
                {
                    journals.map(journal =>
                        <li className="btn" key={journal.id}>
                            <Link className="btn btn-light btn-block" to={`/articles/${journal.id}/journal`}>
                                {journal.name}
                            </Link>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default ArticleJournalList;
