const {Link,useHistory} = window.ReactRouterDOM;

import userService from "./user-service"
const { useState, useEffect } = React;
const UsersList = () => {
    const [users, setUsers] = useState([])
    useEffect(() => {
        findAllUsers()
    }, [])
    const findAllUsers = () =>
        userService.findAllUsers()
            .then(users => setUsers(users))
    return(
        <div>
            <h2>User List for Author</h2>
            <ul className="list-group">
                {
                    users.map(user =>
                        <li className="btn" key={user.id}>
                            <Link className="btn btn-light btn-block" to={`/authors/${user.id}`}>
                                {user.username}
                            </Link>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default UsersList;
