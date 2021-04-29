const {Link,useHistory, useParams} = window.ReactRouterDOM;
import articleService from "./article-service"
const { useState, useEffect } = React;
const ArticleJournalList = () => {
    const history = useHistory()
    const {id} = useParams()
    const [journals, setJournals] = useState([])
    useEffect(() => {
        findJournalByArticleId()
    }, []);
    const findJournalByArticleId = () =>
        articleService.findJournalByArticleId(id)
            .then(journals => setJournals(journals))
    console.log(journals)
    return(
        <div>
            <h2>Journal</h2>
            <ul className="list-group">
                        <li className="btn" key={journals.id}>
                            <a className="btn btn-light btn-block" href={`../journals/journal.html#/journals/${journals.id}`}>
                                {journals.name}
                            </a>
                        </li>
            </ul>
        </div>
    )
}

export default ArticleJournalList;
