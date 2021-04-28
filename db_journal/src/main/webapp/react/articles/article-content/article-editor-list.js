const {Link,useHistory, useParams} = window.ReactRouterDOM;
import articleService from "./article-service"
const { useState, useEffect } = React;
const ArticleEditorList = () => {
    const history = useHistory()
    const {id} = useParams()
    const [editors, setEditors] = useState([])
    useEffect(() => {
        if(id !== "new") {
            findEditorByArticleId(id)
        }
    }, []);
    const findEditorByArticleId = (id) =>
        articleService.findEditorByArticleId(id)
            .then(editors => setEditors(editors))
    return(
        <div>
            <h2>Editor List</h2>
            <ul className="list-group">
                {
                    editors.map(editor =>
                        <li className="btn" key={editor.id}>
                            <Link className="btn btn-light btn-block" to={`/articles/${editor.id}/editor`}>
                                {editor.role}
                            </Link>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default ArticleEditorList;
