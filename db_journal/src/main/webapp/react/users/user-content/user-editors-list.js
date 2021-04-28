const {Link,useHistory} = window.ReactRouterDOM;

import editorService from "./editor-service"
const { useState, useEffect } = React;
const EditorList = () => {
    const [editors, setEditors] = useState([])
    useEffect(() => {
        findAllEditors()
    }, [])
    const findAllEditors = () =>
        editorService.findAllEditors()
            .then(editors => setEditors(editors))
    return(
        <div>
            <h2>Editors List for Users</h2>
            <ul className="list-group">
                {
                    editors.map(editor =>
                        <li className="btn" key={editor.id}>
                            <Link className="btn btn-light btn-block" to={`/editors/${editor.id}`}>
                                {editor.role}
                            </Link>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default EditorList;
