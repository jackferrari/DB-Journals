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
                {
                    editors.map(editor =>
                        <li className="btn" key={editor.id}>
                            <a className="btn btn-light btn-block" href={`../editors/editor.html#/editors/${editor.id}`}>
                                {editor.role}
                            </a>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default ArticleEditorList;
