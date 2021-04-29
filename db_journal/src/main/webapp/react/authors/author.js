import AuthorList from "./author-content/author-list";
import AuthorFormEditor from "./author-content/author-form-editor";
import ArticlesList from "./author-content/author-articles-list";
import UsersList from "./author-content/author-users-list";

const {HashRouter, Route} = window.ReactRouterDOM;
const App = () => {
    return (
        <div className="container-fluid">
            <HashRouter>
                <Route path={["/authors", "/"]} exact={true}>
                    <AuthorList/>
                </Route>
                <Route path="/authors/:id" exact={true}>
                    <AuthorFormEditor/>
                </Route>
                <Route path="/authors/:id/articles" exact={true}>
                    <ArticlesList/>
                </Route>
                <Route path="/authors/:id/users" exact={true}>
                    <UsersList/>
                </Route>
            </HashRouter>
        </div>
    );
}

export default App;
