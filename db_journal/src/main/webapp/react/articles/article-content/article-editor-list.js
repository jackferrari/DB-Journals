const {Link,useHistory, useParams} = window.ReactRouterDOM;
import articleService from "./article-service"
const { useState, useEffect } = React;
const ArticleEditorList = () => {
    const history = useHistory()
    const {id} = useParams()
    const [editors, setEditors] = useState([])
    useEffect(() => {
        findEditorByArticleId()
    }, []);
    const findEditorByArticleId = () =>
        articleService.findEditorByArticleId(id)
            .then(editors => setEditors(editors))
    return(
        <div>
            <h2>Editor List</h2>
            <ul className="list-group">
                <li className="btn" key={editors.id}>
                    <a className="btn btn-light btn-block"
                       href={`../editors/editor.html#/editors/${editors.id}`}>
                        {editors.role}
                    </a>
                </li>
            </ul>
        </div>
    )
}

export default ArticleEditorList;
