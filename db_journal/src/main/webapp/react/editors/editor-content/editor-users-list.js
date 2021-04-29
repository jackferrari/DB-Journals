const {Link,useHistory, useParams} = window.ReactRouterDOM;

import editorService from "./editor-service"
const { useState, useEffect } = React;
const UsersList = () => {
    const {id} = useParams()
    const [users, setUsers] = useState([])
    useEffect(() => {
        findUsersByEditorId()
    }, [])
    const findUsersByEditorId = () =>
        editorService.findUsersByEditorId(id)
            .then(users => setUsers(users))
    console.log(users);
    return(
        <div>
            <h2>User List for Editor</h2>
            <ul className="list-group">
                {
                    users.map(user =>
                        <li className="btn" key={user.id}>
                            <a className="btn btn-light btn-block" href={`../users/user.html#/users/${user.id}`}>
                                {user.username}
                            </a>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default UsersList;
