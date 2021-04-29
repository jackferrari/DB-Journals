const {useParams} = window.ReactRouterDOM;
import userService from "./user-service"
const { useState, useEffect } = React;
const EditorsList = () => {
    const {id} = useParams()
    const [editors, setEditors] = useState([])
    useEffect(() => {
        findEditorsByUserId()
    }, [])
    const findEditorsByUserId = () =>
        userService.findEditorsByUserId(id)
            .then(editors => setEditors(editors))
    return(
        <div>
            <h2>Editors List for User</h2>
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

export default EditorsList;
