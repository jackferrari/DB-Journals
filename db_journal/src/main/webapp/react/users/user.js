import UserList from "./user-content/user-list";
import UserFormEditor from "./user-content/user-form-editor";
import AuthorsList from "./user-content/user-authors-list";
import EditorsList from "./user-content/user-editors-list";
const {HashRouter, Route} = window.ReactRouterDOM; 
const App = () => {
    return (
        <div className="container-fluid">
            <HashRouter>
                <Route path={["/users", "/"]} exact={true}>
                    <UserList/>
                </Route>
                <Route path="/users/:id" exact={true}>
                    <UserFormEditor/>
                </Route>
                <Route path="/users/:id/authors" exact={true}>
                    <AuthorsList/>
                </Route>
                <Route path="/users/:id/editors" exact={true}>
                    <EditorsList/>
                </Route>
            </HashRouter>
        </div>
    );
}

export default App;
